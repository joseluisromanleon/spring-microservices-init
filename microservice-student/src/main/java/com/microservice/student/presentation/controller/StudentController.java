package com.microservice.student.presentation.controller;


import com.microservice.student.presentation.dto.StudentDTO;
import com.microservice.student.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Recibimos el JSon por el endpoint.  (/student), (/find/{id}) etc.
 * Creamos la Respuesta con DTO según el formato requerido por el Service, (ResponseEntity)
 * Lo enviamos al Service (Return)
 */

@RestController
@RequestMapping("/api/student")
public class StudentController {

    //inyectar el servicio
    @Autowired
    private IStudentService studentService;

    // FindAll no enviamos nada solo recibimos todos los elementos de la tabla
    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> findAll(){
        return new ResponseEntity<> (this.studentService.findAll(), HttpStatus.OK);
    }

    // FindById envía id para recibir el elemento específico de la tabla.
    @GetMapping("/find/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id){
        return new ResponseEntity<> (this.studentService.findById(id), HttpStatus.OK);

    }

    //Create Student  envía DTO
    @PostMapping("/create")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<> (this.studentService.createStudent(studentDTO), HttpStatus.CREATED);

    }

    //Update Student  envía DTO + id
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO,@PathVariable Long id){
        return new ResponseEntity<> (this.studentService.updateStudent(studentDTO, id), HttpStatus.OK);

    }

    //Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        return new ResponseEntity<> (this.studentService.deleteStudent(id), HttpStatus.NO_CONTENT);

    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByCourseId(idCourse));
        // Recuerda que devuelve un Entity  por lo que se recoge en un DTO
    }

}
