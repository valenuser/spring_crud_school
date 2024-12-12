package com.repaso.spring.crud.repaso_crud.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repaso.spring.crud.repaso_crud.entities.Student;
import com.repaso.spring.crud.repaso_crud.interfaces.IStudentService;
import com.repaso.spring.crud.repaso_crud.respotitories.StudentRepository;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        
        return (List<Student>) repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        
        return Optional.empty();
    }
    
    @Override
    public Student save(Student student) {
        
        return repository.save(student);
    }
    
    
    @Override
    public Optional<Student> delete(Long id) {

            Optional<Student> sOptional= repository.findById(id);

            if(sOptional.isPresent()){

                repository.delete(sOptional.orElseThrow()); 

            }

            return sOptional;
    }



    @Override
    public Optional<Student> update(Long id, Student student) {

        Optional<Student> sOptional = repository.findById(id);
        
        if(sOptional.isPresent()){

            Student studentDb =  sOptional.orElseThrow();

            studentDb.setId(student.getId());
            studentDb.setName(student.getName());
            studentDb.setLastname(student.getLastname());

            repository.save(studentDb);


            
        }

        return sOptional;


    }


    
}
