package com.alticci.exception;

import com.alticci.exception.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestErrorHandling {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleConstraintViolation(ConstraintViolationException exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        ErrorResponseDTO
                                .builder()
                                .message(exception.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(StackOverflowError.class)
    public ResponseEntity<ErrorResponseDTO> handleStackOverflow(StackOverflowError exception) {
        return ResponseEntity
                .internalServerError()
                .body(
                        ErrorResponseDTO
                                .builder()
                                .message("The input number power level is too strong, I could not handle it")
                                .build()
                );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> handleArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        ErrorResponseDTO
                                .builder()
                                .message("Number maximum is " + Long.MAX_VALUE)
                                .build()
                );
    }

}
