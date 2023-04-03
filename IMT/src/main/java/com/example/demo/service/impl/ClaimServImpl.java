package com.example.demo.service.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClaimDto;
import com.example.demo.dto.ClientDto;
import com.example.demo.dto.InsurancePolicyDto;
import com.example.demo.entity.Claim;
import com.example.demo.entity.Client;
import com.example.demo.entity.InsurancePolicy;
import com.example.demo.exceptionHandler.ResourceNotFound;
import com.example.demo.repo.ClaimRepo;
import com.example.demo.service.ClaimService;

@Service
public class ClaimServImpl implements ClaimService {
	@Autowired
	private ClaimRepo claimRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ClaimDto> fetchAllClaims() {
		List<Claim> findAll = claimRepo.findAll();
		List<ClaimDto> claim = findAll.stream().map(cl -> modelMapper.map(cl, ClaimDto.class))
				.collect(Collectors.toList());
		return claim;
	}

	@Override
	public ClaimDto fetchClaims(int id) {
		Claim findById = claimRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Claim", "id", id));
		System.out.println(findById.getInsurancePolicy());
		return modelMapper.map(findById, ClaimDto.class);
	}

	@Override
	public ClaimDto createClaims(ClaimDto claim) {
		Claim c = modelMapper.map(claim, Claim.class);
		Claim save = claimRepo.save(c);

		return modelMapper.map(save, ClaimDto.class);
	}

	@Override
	public ClaimDto updateClaims(ClaimDto claimDto, int id) {
		Claim claim = claimRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Claim", "id", id));

		claim.setClaimDate(claimDto.getClaimDate());
		claim.setClaimNumber(claimDto.getClaimNumber());
		claim.setClaimStatus(claimDto.getClaimStatus());
		claim.setDescription(claimDto.getDescription());

		
		Claim newClaim = claimRepo.save(claim);
		return modelMapper.map(newClaim, ClaimDto.class);
	}

	@Override
	public void deleteClaims(int id) {
		Claim claim = claimRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Claim", "id", id));
		claimRepo.delete(claim);
	}

}
