package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClaimDto;

import com.example.demo.exceptionHandler.ApiResponse;
import com.example.demo.service.ClaimService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClaimController {
	@Autowired
	private ClaimService claimServ;
	
	@GetMapping("/claims")
	public ResponseEntity<Collection <ClaimDto>> fetchAllClaims(){
		List<ClaimDto> fetchAllClaims = claimServ.fetchAllClaims();
		System.out.println(fetchAllClaims);
		return ResponseEntity.ok(fetchAllClaims);
	}
	
	@GetMapping("/claims/{id}")
	public ResponseEntity<ClaimDto> fetchClaims(@PathVariable Integer id){
		return ResponseEntity.ok(claimServ.fetchClaims(id));
	}
	
	@PostMapping("/claims")
	public ResponseEntity<ClaimDto> createClaims(@Valid @RequestBody ClaimDto claim){
		ClaimDto c=claimServ.createClaims(claim);
		return ResponseEntity.ok(c);
	}
	
	@PutMapping("/claims/{id}")
	public ResponseEntity<ClaimDto> updateClaims( @RequestBody ClaimDto claim, @PathVariable Integer id){
		ClaimDto c=claimServ.updateClaims(claim, id);
		return ResponseEntity.status(201).body(c);
	}
	
	@DeleteMapping("/claims/{id}")
	public ResponseEntity<ApiResponse> deleteClaim(@PathVariable Integer id){
		ApiResponse a=new ApiResponse("Deletion Successful", true);
		claimServ.deleteClaims(id);
		return ResponseEntity.status(204).body(a);
	}
}
