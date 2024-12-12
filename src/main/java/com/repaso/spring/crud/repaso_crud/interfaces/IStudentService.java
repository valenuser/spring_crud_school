package com.repaso.spring.crud.repaso_crud.interfaces;

import java.util.List;
import java.util.Optional;


import com.repaso.spring.crud.repaso_crud.entities.Student;

public interface IStudentService {

    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);

    Optional<Student> delete(Long id);

    Optional<Student> update(Long id, Student student);

}
