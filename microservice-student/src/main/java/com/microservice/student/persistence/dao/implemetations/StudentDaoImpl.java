package com.microservice.student.persistence.dao.implemetations;

import com.microservice.student.persistence.dao.interfaces.IStudentDAO;
import com.microservice.student.persistence.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements IStudentDAO

 {
    // Cargamos el Administrador  de persistencia
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<StudentEntity> findAll() {

        return this.em.createQuery("select u from StudentEntity u").getResultList();
    }

     @Override
     public List<StudentEntity> findByCourseId(Long courseId) {
         //return this.em.createQuery("select u from StudentEntity u where u.courseId.id =  :courseId", StudentEntity.class)


         return this.em.createQuery("select u from StudentEntity u where u.courseId = :courseId", StudentEntity.class)
                 .setParameter("courseId", courseId)
                 .getResultList();

     }

     @Override
    @Transactional(readOnly = true)
    public Optional<StudentEntity

> findById(Long id) {
        return Optional.ofNullable(this.em.find(StudentEntity

.class, id));
    }

    @Override
    @Transactional
    public void saveStudent(StudentEntity studentEntity) {
        this.em.persist(studentEntity);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updateStudent(StudentEntity studentEntity) {
        this.em.merge(studentEntity);
    }

    @Override
    @Transactional
    public void deleteStudent(StudentEntity studentEntity) {
        this.em.remove(studentEntity);
    }
}
