package com.pfcti.spring.dev.app.exceptions;

import com.pfcti.spring.dev.app.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) { List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(x -> "Error al invocar al servicio: "+ x.getDefaultMessage() +" el campo: " +x.getField()) .collect(Collectors.toList());
        return new ResponseEntity<>(new ErrorDto(status.value(),errors.toString()), headers, status); }
}
