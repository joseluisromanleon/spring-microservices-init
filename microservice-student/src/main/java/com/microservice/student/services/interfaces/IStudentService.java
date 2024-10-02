package com.microservice.student.services.interfaces;


import com.microservice.student.presentation.dto.StudentDTO;
import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();

    StudentDTO findById(Long id);

    StudentDTO createStudent(StudentDTO stutudentDTO);

    StudentDTO updateStudent(StudentDTO stutudentDTO, Long id);

    List<StudentDTO> findByCourseId(Long idCourse);

    String deleteStudent(Long id);

}
