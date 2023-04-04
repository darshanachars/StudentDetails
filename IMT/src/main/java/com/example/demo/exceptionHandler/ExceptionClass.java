package com.example.demo.exceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionClass {
	@ExceptionHandler(AllObjectsException.class)
	public ResponseEntity<ApiResponse> allResource(AllObjectsException e){
		ApiResponse api=new ApiResponse(e.getMessage(), false);
		return ResponseEntity.status(400).body(api);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFound res){
		String s=res.getMessage();
		ApiResponse api=new ApiResponse(s, false);
		return ResponseEntity.status(404).body(api);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> invalidCredentials(MethodArgumentNotValidException ex) {
		
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((err) -> {
			map.put(((FieldError) err).getField(), err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(map);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> ec(ConstraintViolationException e) {
		
		Map<String, String> map = new HashMap<>();

		e.getConstraintViolations().forEach(err -> {

			map.put(err.getPropertyPath().toString(), err.getMessage());

		});

		return ResponseEntity.ok(map);
	}
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<ApiResponse> dateTypeException(DateTimeParseException date){
		String s="Date should be in yyyy-mm-dd format";
		ApiResponse api=new ApiResponse(s, false);
		return ResponseEntity.status(400).body(api);
	}
}
