package com.spring3nelio.course.resources.excpitions;

import com.spring3nelio.course.service.excption.ResourceNotFoundExcption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class ResourceExcptionHandler implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ResourceNotFoundExcption.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundExcption e, HttpServletRequest request) {
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }



    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {
        String error = "DataBase error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }




}
