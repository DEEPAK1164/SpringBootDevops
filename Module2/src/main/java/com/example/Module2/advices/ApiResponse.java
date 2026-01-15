package com.example.Module2.advices;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }

    // ✅ GENERIC success method (THIS FIXES EVERYTHING)
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data);
    }

    // (Optional, but good practice)
    public static <T> ApiResponse<T> failure(ApiError error) {
        return new ApiResponse<>(error);
    }
}
