package com.microservice.course.service;

import com.microservice.course.entities.CourseEntity;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;


public interface ICourseService {
    // solo ponemos tres metodos por el momento

    List<CourseEntity> findAll();

    CourseEntity findById(Long id);

    void save(CourseEntity course);

    void delete(CourseEntity course);

    StudentByCourseResponse findStudentByIdCourse(Long idCourse);



}
