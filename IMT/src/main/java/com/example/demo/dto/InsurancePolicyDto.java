package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InsurancePolicyDto {
private String policyNumber;
	private String id;
	@NotBlank(message = "type of policy cannot be empty")
	private String type;
	
	@NotBlank(message = "coverage amount cannot be blank")
	private double coverageAmount;
	
	@NotBlank(message = "premium amount cannot be blank")
	private double premium;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull(message = "please enter date in yyyy-mm-dd format")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull(message = "please enter date in yyyy-mm-dd format")
	private LocalDate endDate;
	
	@JsonIgnore
	private ClientDto clientDto;

	
	public ClientDto getClientDto() {
		return clientDto;
	}


	public void setClientDto(ClientDto clientDto) {
		this.clientDto = clientDto;
	}
//hello
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPolicyNumber() {
		return policyNumber;
	}


	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getCoverageAmount() {
		return coverageAmount;
	}


	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}


	public double getPremium() {
		return premium;
	}


	public void setPremium(double premium) {
		this.premium = premium;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	
	
}
