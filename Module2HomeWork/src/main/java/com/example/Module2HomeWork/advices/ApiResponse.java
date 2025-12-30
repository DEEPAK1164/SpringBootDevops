package com.example.Module2HomeWork.advices;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse<T> {
private LocalDateTime timestamp = LocalDateTime.now();
private T data;
private ApiError error;

public ApiResponse(T data) {
  this.data = data;
}
public ApiResponse(ApiError error) {
this.error = error;
}
}