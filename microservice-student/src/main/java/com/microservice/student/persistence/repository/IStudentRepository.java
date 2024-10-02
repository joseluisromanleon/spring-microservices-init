package com.microservice.student.persistence.repository;

import com.microservice.student.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<StudentEntity, Long> {

    // forma con querry configurable sin uso de JPA
    @Query("SELECT s FROM StudentEntity s WHERE s.courseId = :idCourse")
    List<StudentEntity> findAllStudent(Long idCourse);

    // forma con uso de JPA de forma automática
    // List<StudentEntity> findAllByCourseId(Long idCourse);

}
