package com.microservice.student.persistence.entity;


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
@Table(name="students")

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    private String name;

    @Column(name = "last_name") // se coloca column cuando hay un nombre compuesto
    private String lastName;
    private String email;

    @Column(name = "course_id")
    private Long courseId;
}
