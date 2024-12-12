package com.repaso.spring.crud.repaso_crud.exceptions;

import java.util.Date;

public class Exception {

    private Date date;
    private String  Error;
    private String Message;
    private Integer status;

    
    public Exception() {
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public String getError() {
        return Error;
    }


    public void setError(String error) {
        Error = error;
    }


    public String getMessage() {
        return Message;
    }


    public void setMessage(String message) {
        Message = message;
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    

}
