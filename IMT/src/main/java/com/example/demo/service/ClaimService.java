package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClaimDto;



public interface ClaimService {
	public List<ClaimDto> fetchAllClaims();
	public ClaimDto fetchClaims(int id);
	public 	ClaimDto createClaims(ClaimDto claim);
	public ClaimDto updateClaims(ClaimDto claimDto, int id);
	public void deleteClaims(int id);
}
