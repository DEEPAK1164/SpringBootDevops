package com.example.Module2HomeWork.advices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Module2HomeWork.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ApiResponse<?>>
   handleNotFound(ResourceNotFoundException ex) {
   ApiError error = ApiError.builder()
   .status(HttpStatus.NOT_FOUND)
   .message(ex.getMessage())
   .build();
   return new ResponseEntity<>(new ApiResponse<>(error),
   HttpStatus.NOT_FOUND);
}

@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>>
    handleValidation(MethodArgumentNotValidException ex) {
    List<String> errors = ex.getBindingResult().getAllErrors()
    .stream().map(ObjectError::getDefaultMessage).toList();
    ApiError error = ApiError.builder()
    .status(HttpStatus.BAD_REQUEST)
    .message(errors.toString())
    .build();
    return new ResponseEntity<>(new ApiResponse<>(error),
    HttpStatus.BAD_REQUEST);
}
}
