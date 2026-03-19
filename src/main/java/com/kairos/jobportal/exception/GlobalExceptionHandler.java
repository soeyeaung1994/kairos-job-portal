package com.kairos.jobportal.exception;

import com.kairos.jobportal.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Soe Ye Aung
 * @Date: 7/3/26
 * @Time: 5:01 pm
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponseDto> handleNullException(Exception exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR,
                "A NullPointerException occurred due to : " + exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String,String>> handleException(HandlerMethodValidationException exception) {
        Map<String, String> errors = new HashMap<>();
        List<ParameterValidationResult> results = exception.getParameterValidationResults();
        results.forEach(result -> {
            String paramName = result.getMethodParameter().getParameterName();

            // Combine all messages into a single comma-separated string
            String combinedMessages = result.getResolvableErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())  // extract each message
                    .collect(Collectors.joining(", "));       // join messages
            errors.put(paramName, combinedMessages);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(RegistrationValidationException.class)
    public ResponseEntity<Map<String, String>> handleRegistrationException(
            RegistrationValidationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getErrors());
    }

}
