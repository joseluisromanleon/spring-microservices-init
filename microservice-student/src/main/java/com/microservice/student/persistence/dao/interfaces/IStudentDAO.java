package com.microservice.student.persistence.dao.interfaces;


import com.microservice.student.persistence.entity.StudentEntity;

import java.util.List;
import java.util.Optional;



public interface IStudentDAO {
    //Utilizamos StudentEntity porque DAO solo entiende StudentEntity y no StudentDTO
    List<StudentEntity> findAll();

    List<StudentEntity> findByCourseId(Long courseId);

    // usamos Optional para que si devuelve null no reviente la app
    Optional<StudentEntity> findById(Long id);

    void saveStudent(StudentEntity studentEntity);

    void updateStudent(StudentEntity studentEntity);

    void deleteStudent(StudentEntity studentEntity);



}
