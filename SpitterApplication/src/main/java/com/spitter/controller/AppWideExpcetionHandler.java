package com.spitter.controller;

import com.spitter.util.exceptions.DuplicateSpitterException;
import com.spitter.util.exceptions.SpittleNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExpcetionHandler {

    @ExceptionHandler(SpittleNotFoundException.class)
    public String spittleNotFoundHandler(){
        return "error/notFound";
    }
    @ExceptionHandler(DuplicateSpitterException.class)
    public String duplicateSpitterHandler(){
        return "error/duplicate";
    }
}
