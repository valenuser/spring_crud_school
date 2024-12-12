package com.repaso.spring.crud.repaso_crud.controllers;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repaso.spring.crud.repaso_crud.entities.Student;
import com.repaso.spring.crud.repaso_crud.interfaces.IStudentService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/students")
public class StudentController {


    @Autowired 
    private IStudentService service;

    @GetMapping
    public ResponseEntity<?> getAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id ){

        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));


    }


    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult result){

        if(result.hasFieldErrors()){

            return validation(result);
            
        }
            
            return ResponseEntity.status(HttpStatus.OK).body(service.save(student));
            
    }
            
                
                
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student, @PathVariable Long id, BindingResult result){

        if(result.hasFieldErrors()){

            return validation(result);
            
        }

        Optional<Student> studentDb = service.update(id, student);

        if(!studentDb.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario solicitado no esta registrado");
        }
                    
        return ResponseEntity.status(HttpStatus.OK).body("Usuario actualizado!");
                    
                    
                    
    }
                
                
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){

        Optional<Student> deleteOptional =service.delete(id);

        if(!deleteOptional.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no ha sido encontrado.");

        }
                    
        return ResponseEntity.status(HttpStatus.OK).body(deleteOptional.orElseThrow());

    }
                
    private ResponseEntity<?> validation(BindingResult result) {

        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err ->{

            errors.put(err.getField(),err.getDefaultMessage());

        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
