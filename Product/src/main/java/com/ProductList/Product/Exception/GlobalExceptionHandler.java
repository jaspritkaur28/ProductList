package com.ProductList.Product.Exception;


import com.ProductList.Product.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<?> handleCategoryAlreadyExistException(CategoryAlreadyExistsException e,WebRequest request){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                request.getDescription(false),
                HttpStatus.CONFLICT,
                e.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryNotFound(CategoryNotFoundException e, WebRequest request){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
            request.getDescription(false),
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(Exception e, WebRequest request){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                LocalDateTime.now()
        );
                return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
