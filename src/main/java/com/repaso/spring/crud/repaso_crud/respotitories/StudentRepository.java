package com.repaso.spring.crud.repaso_crud.respotitories;

import org.springframework.data.repository.CrudRepository;

import com.repaso.spring.crud.repaso_crud.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {


}
