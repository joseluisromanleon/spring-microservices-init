package com.microservice.course.client;


import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// he eliminado la ruta: (localhost:8080/api/student) ya que utilizo eureka directamente (
@FeignClient(name = "msvc-student", url = "localhost:8080/api/student")
public interface StudentClient {

    @GetMapping("/search-by-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable("idCourse") Long idCourse);


}
