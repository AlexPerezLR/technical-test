package com.alex.technicaltest.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex){
        
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ApiError apiError = new ApiError(
            LocalDateTime.now(),
            "El recurso no existe.",
            details
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex){
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ApiError apiError = new ApiError(
            LocalDateTime.now(),
            "Ha habido una excepción con la base de datos.",
            details
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        
        List<String> details = new ArrayList<>();
        ex.getFieldErrors().forEach(fieldError -> details.add(fieldError.getDefaultMessage()));
        ApiError apiError = new ApiError(
            LocalDateTime.now(),
            "Error de validación",
            details
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex){
        
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ApiError apiError = new ApiError(
            LocalDateTime.now(),
            "Ha ocurrido un error inesperado",
            details
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}
