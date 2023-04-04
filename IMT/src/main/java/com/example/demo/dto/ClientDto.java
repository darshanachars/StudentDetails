package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.Client;
import com.example.demo.entity.InsurancePolicy;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientDto {
	private int id;
	@NotBlank(message = "name cannot be blank")
	@Size(min = 2, max = 15, message = "name should me min 2 char and max 15 char.")
	private String name;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull(message = "please enter date in yyyy-mm-dd format")
	private String dateOfBirth;
	@NotBlank(message = "address cannot be empty")
	private String address;
	@NotBlank(message = "contact Information cannot be blank")
	private String contactInformation;
	
	private List<InsurancePolicy> insurancePolicies=new ArrayList<>();
	
	

	public List<InsurancePolicy> getInsurancePolicies() {
		return insurancePolicies;
	}

	public void setInsurancePolicies(List<InsurancePolicy> insurancePolicies) {
		this.insurancePolicies = insurancePolicies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	


	
	
}
