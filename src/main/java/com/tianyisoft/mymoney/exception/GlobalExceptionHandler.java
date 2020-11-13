package com.tianyisoft.mymoney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianyi
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Map<String, String>> statusCodeError(HttpClientErrorException exception) {
        Map<String, String> map = new HashMap<>(1);
        map.put("message", exception.getStatusText());
        return new ResponseEntity<>(map, exception.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> argumentNotValid(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        String message = bindingResult.getFieldErrors().get(0).getDefaultMessage();
        Map<String, String> map = new HashMap<>(1);
        map.put("message", message);
        return new ResponseEntity<>(map, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
