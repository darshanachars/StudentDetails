package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.InsurancePolicyDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.InsurancePolicy;

public interface InsuracePolicyService {
	public List<InsurancePolicyDto> fetchAllInsurancePolicy();
	public InsurancePolicyDto fetchInsurancePolicy(int id);
	public 	InsurancePolicyDto createInsuracePolicy(InsurancePolicyDto insuranePolicy);
	public InsurancePolicyDto updateInsurancePolicy(InsurancePolicyDto insurancePolicy, int id);
	public void deleteInsurancePolicy(int id);
}
