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


import com.example.demo.dto.InsurancePolicyDto;
import com.example.demo.exceptionHandler.ApiResponse;
import com.example.demo.service.InsuracePolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {
	@Autowired
	private InsuracePolicyService insurancePolicy;
	
	
	
	@GetMapping("/policies")
	public ResponseEntity<Collection <InsurancePolicyDto>> fetchAllPolicy(){
		List<InsurancePolicyDto> fetchAllInsurancePolicy = insurancePolicy.fetchAllInsurancePolicy();
		
		return ResponseEntity.ok(fetchAllInsurancePolicy);
	}
	
	@GetMapping("/policies/{id}")
	public ResponseEntity<InsurancePolicyDto> fetchPolicy(@PathVariable Integer id){
		return ResponseEntity.ok(insurancePolicy.fetchInsurancePolicy(id));
	}
	
	@PostMapping("/policies")
	public ResponseEntity<InsurancePolicyDto> createPolicy(@Valid @RequestBody InsurancePolicyDto ip){
		InsurancePolicyDto createInsuracePolicy = insurancePolicy.createInsuracePolicy(ip);
		return ResponseEntity.ok(createInsuracePolicy);
	}
	
	@PutMapping("/policies/{id}")
	public ResponseEntity<InsurancePolicyDto> updatePolicy( @RequestBody InsurancePolicyDto ins, @PathVariable Integer id){
		InsurancePolicyDto updateInsurancePolicy = insurancePolicy.updateInsurancePolicy(ins, id);
		return ResponseEntity.status(201).body(updateInsurancePolicy);
	}
	
	@DeleteMapping("/policies/{id}")
	public ResponseEntity<ApiResponse> deletePolicy(@PathVariable Integer id){
		ApiResponse a=new ApiResponse("Deletion Successful", true);
		insurancePolicy.deleteInsurancePolicy(id);
		return ResponseEntity.status(204).body(a);
	}
}
