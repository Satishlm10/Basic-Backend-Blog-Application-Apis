package com.learning.blog.blogappapis.exceptions;

import com.learning.blog.blogappapis.payloads.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
    for exceptions generated in service class the new object of the exception is generated
    but since it will not be a spring bean then the spring context will not recognize it.
    To provide the client with custom exceptions we need to do as following:

    exception generated in service of class ResourceNotFound -> Parameters will be passed into the ResourceNotFound class's construction ->
    since it is not a bean generic exception will be generated -> hence we make a GlobalExceptionHandler Class make it a spring bean
    using @RestControllerAdvice -> thus this exception handler spring bean class will have methods with annotations @ExceptionHandler(CustomClass.class)
    which will allow us to generate our custom exception

    the class ApiResponse is returned in the method because we want to return our custom response when so exception is generated and the
    exception generating values are taken from the pojo class whose new object is created by the service
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponses> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage(); // getMessage is not a method of ResourceNotFoundExpection class but we can use it because of we've inherited RuntimeException class
        ApiResponses apiResponses = new ApiResponses(message,false);
        return new ResponseEntity<ApiResponses>(apiResponses, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
        Map<String, String>  resp  = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName,message);
        });
        return new ResponseEntity<Map<String ,String>>(resp,HttpStatus.BAD_REQUEST);
    }
}
