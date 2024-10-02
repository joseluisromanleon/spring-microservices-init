package com.microservice.course.persistence;

import com.microservice.course.entities.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICourseRepository extends CrudRepository<CourseEntity, Long> {

// Aqui no creamos ningun metodo personalizado como esta en el microservicio de Estudent
}
