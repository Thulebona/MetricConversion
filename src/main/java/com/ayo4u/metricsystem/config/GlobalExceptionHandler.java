package com.ayo4u.metricsystem.config;

import com.ayo4u.metricsystem.model.ErrorMessage;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ErrorMessage> handleConflict(RuntimeException ex) {
        return new ResponseEntity<>(errorMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGeneralError(Exception ex) {
        return new ResponseEntity<>(errorMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorMessage errorMessage(String msg){
        return ErrorMessage.builder().message(msg).build();
    }

}