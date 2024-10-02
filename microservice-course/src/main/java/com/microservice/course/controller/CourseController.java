package com.microservice.course.controller;


import com.microservice.course.entities.CourseEntity;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    // FindAll no enviamos nada solo recibimos todos los elementos de la tabla
    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse(){
        return ResponseEntity.ok(courseService.findAll());
    }

    //Update Student  envía DTO + id
    @PutMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok (courseService.findById(id));
    }



    //Create Student  envía DTO
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@RequestBody CourseEntity course){
        courseService.save(course);

    }

    @PutMapping("/update/{id}")
    public void updateCourse(@RequestBody CourseEntity course,@PathVariable Long id){
        courseService.save(course);

    }

    //Delete Student
    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@RequestBody CourseEntity course,@PathVariable Long id){
        courseService.delete(course);
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(courseService.findStudentByIdCourse(idCourse));
    }
}
