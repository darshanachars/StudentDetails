package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.InsurancePolicy;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ClaimDto {
	
	private int id;
	@NotBlank(message = "please enter claim number")
	private String claimNumber;
	
	private String description;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull(message = "please enter date in yyyy-mm-dd format")
	private LocalDate claimDate;
	
	private String claimStatus;
	@JsonIgnore
	private InsurancePolicy insurancePolicy;

	
	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	

	
	
}
