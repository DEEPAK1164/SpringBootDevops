package com.example.Module2HomeWork.advices;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
private HttpStatus status;
private String message;
}
