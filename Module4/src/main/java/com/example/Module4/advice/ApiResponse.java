package com.example.Module4.advice;
import java.time.LocalDateTime;
import java.util.List;

import com.example.Module4.dto.EmployeeDTO;

import lombok.Data;


@Data
public class ApiResponse<T> {
private LocalDateTime timestamp;
 private T data;
 private ApiError error;
 
 
 public ApiResponse() {
	 this.timestamp=LocalDateTime.now();
 }
 
 public ApiResponse(T data) {
	this();
	this.data = data;
	
 }
 

 public ApiResponse(ApiError error) {
	this();
	this.error = error;
 }

 // ✅ Generic success method (works for any type)
 public static <T> ApiResponse<T> success(T data) {
     return new ApiResponse<>(data);
 }

 // ✅ Generic error method
 public static <T> ApiResponse<T> failure(ApiError error) {
     return new ApiResponse<>(error);
 }
 
 
 
}
