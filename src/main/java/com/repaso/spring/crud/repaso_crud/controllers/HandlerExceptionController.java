package com.repaso.spring.crud.repaso_crud.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.repaso.spring.crud.repaso_crud.exceptions.Exception;

@RestControllerAdvice
public class HandlerExceptionController {


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Exception> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){

            Exception exception = new Exception();

            exception.setDate(new Date());
            exception.setError("No se ha enviado la información correctamente");
            exception.setMessage(e.getMessage());
            exception.setStatus(e.getStatusCode().value());


            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(exception);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Exception> httpMessageNotReadableException(HttpMessageNotReadableException e){


        Exception exception = new Exception();

        exception.setDate(new Date());
        exception.setError("No se ha enviado la información correctamente");
        exception.setMessage(e.getMessage());
        exception.setStatus(e.hashCode());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(exception);

    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Exception> NoResourceFoundException(NoResourceFoundException e){


        Exception exception = new Exception();

        exception.setDate(new Date());
        exception.setError("La url no es correcta");
        exception.setMessage(e.getMessage());
        exception.setStatus(e.hashCode());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(exception);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Exception> methodArgumentNotValidException(MethodArgumentNotValidException e){

        Exception exception = new Exception();

        exception.setDate(new Date());
        exception.setError("No se han proporcionado todos los datos correctamente");
        exception.setMessage(e.getMessage());
        exception.setStatus(e.hashCode());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(exception);


    }


}
