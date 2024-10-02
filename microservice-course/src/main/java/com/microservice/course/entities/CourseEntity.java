package com.microservice.course.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

// No usamos @Data "Contraindicado"  convención
@Entity
@Getter
@Setter
@Slf4j  // logs
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="courses")

public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    private String name;
    private String teacher;

//    @Column(name = "course_id")
//    private Long courseId;
}
