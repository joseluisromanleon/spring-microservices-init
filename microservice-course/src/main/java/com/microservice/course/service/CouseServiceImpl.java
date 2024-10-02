package com.microservice.course.service;


import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.CourseEntity;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired  // este StudentClient  tiene la notacion @Feing  para conectar con el servicio de Cliente
    private StudentClient studentClient;

    @Autowired
    public void CourseServiceImpl(ICourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }

    @Override
    public List<CourseEntity> findAll() {
        return (List<CourseEntity>) courseRepository.findAll();
    }

    @Override
    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

   @Override
    public void save(CourseEntity course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(CourseEntity course) {
        courseRepository.delete(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {
        //1º Consultar el curso y si no lo encuentra crea uno nuevo sin parametros. (para no lanzar errores)
        CourseEntity course = courseRepository.findById(idCourse).orElse(new CourseEntity());

        // ahora obtenemos los estudiantes, necesito un atributo StudentClient @Autowired
        // (por el Feing de cliente  que comunicara mediante http con el mcsCurso)

        // con los datos de curso consumirá el micro-servicio  StudentController
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        // con los estudiantes de este curso se mapean para la entidad de respuesta que se construye StudentByCourseResponse
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacherName(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }


}
