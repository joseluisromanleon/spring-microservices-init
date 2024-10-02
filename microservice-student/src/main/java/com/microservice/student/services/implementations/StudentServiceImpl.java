package com.microservice.student.services.implementations;

import com.microservice.student.persistence.dao.interfaces.IStudentDAO;
import com.microservice.student.persistence.entity.StudentEntity;
import com.microservice.student.presentation.dto.StudentDTO;
import com.microservice.student.services.interfaces.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<StudentDTO> findAll() {
        // Biblioteca de Java para convertir Entity a DTO  porque debemos devolver un List<StutudentDTO

        ModelMapper modelMapper = new ModelMapper();

        return this.studentDAO.findAll()
                .stream()
                .map(studentEntity -> modelMapper.map(studentEntity, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Long id) {
        // puede que no exista, por lo tanto, uso Optional
        Optional<StudentEntity> studentEntity = this.studentDAO.findById(id);

        if (studentEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            StudentEntity currentUser = studentEntity.get();

            return modelMapper.map(currentUser, StudentDTO.class);
        } else {
            return new StudentDTO();
        }
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        try {
            ModelMapper modelMapper = new ModelMapper();
            //se va a mapear en un Entity para poder pasarlo a la base de datos y guardarlo directamente
            StudentEntity studentEntity = modelMapper.map(studentDAO, StudentEntity.class);
            this.studentDAO.saveStudent(studentEntity);

            return studentDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error al guardar el student");
        }
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO, Long id) {

        Optional<StudentEntity> studentEntity = this.studentDAO.findById(id);

        if (studentEntity.isPresent()) {

            StudentEntity currentStudentEntity = studentEntity.get();

            currentStudentEntity.setName(studentDTO.getName());
            currentStudentEntity.setLastName(studentDTO.getLastName());
            currentStudentEntity.setEmail(studentDTO.getEmail());
            currentStudentEntity.setCourseId(studentDTO.getCourseId());

            this.studentDAO.updateStudent(currentStudentEntity);

            ModelMapper modelMapper = new ModelMapper();


            return modelMapper.map(currentStudentEntity, StudentDTO.class);
        } else {
            throw new IllegalArgumentException("El estudiante no existe");
        }
    }

    @Override
    public List<StudentDTO> findByCourseId(Long idCourse) {
        ModelMapper modelMapper = new ModelMapper();

        return this.studentDAO.findByCourseId(idCourse)
                .stream()
                .map(studentEntity -> modelMapper.map(studentEntity, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteStudent(Long id) {
        // verificar que el id exista para que no se rompa la aplicación
        Optional<StudentEntity> studentEntity = this.studentDAO.findById(id);

        if (studentEntity.isPresent()) {
            StudentEntity currentStudentEntity = studentEntity.get();
            studentDAO.deleteStudent(currentStudentEntity);

            return "Student con id " + id + " ha sido eliminado";

        } else {
            throw new IllegalArgumentException("El Student con id " + id + " no existe");
        }
    }
}
