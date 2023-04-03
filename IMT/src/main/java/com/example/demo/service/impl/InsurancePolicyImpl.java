package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.InsurancePolicyDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.InsurancePolicy;
import com.example.demo.exceptionHandler.ResourceNotFound;
import com.example.demo.repo.InsurancePolicyRepo;
import com.example.demo.service.InsuracePolicyService;

@Service
public class InsurancePolicyImpl implements InsuracePolicyService {
	@Autowired
	private InsurancePolicyRepo insuranceRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<InsurancePolicyDto> fetchAllInsurancePolicy() {
		List<InsurancePolicy> findAll = insuranceRepo.findAll();
		List<InsurancePolicyDto> collect = findAll.stream()
				.map(policy -> modelMapper.map(policy, InsurancePolicyDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public InsurancePolicyDto fetchInsurancePolicy(int id) {
		InsurancePolicy policy = insuranceRepo.findById(id).orElseThrow(() -> new ResourceNotFound("client", "id", id));
		return modelMapper.map(policy, InsurancePolicyDto.class);
	}

	@Override
	public InsurancePolicyDto createInsuracePolicy(InsurancePolicyDto insuranePolicy) {
		InsurancePolicy map = modelMapper.map(insuranePolicy, InsurancePolicy.class);
		InsurancePolicy save = insuranceRepo.save(map);
		return modelMapper.map(save, InsurancePolicyDto.class);
	}

	@Override
	public InsurancePolicyDto updateInsurancePolicy(InsurancePolicyDto insurancePolicy, int id) {
		InsurancePolicy policy = insuranceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("InsurancePolicy", "id", id));
		policy.setType(insurancePolicy.getType());
		policy.setStartDate(insurancePolicy.getStartDate());
		policy.setPremium(insurancePolicy.getPremium());
		policy.setPolicyNumber(insurancePolicy.getPolicyNumber());
		policy.setEndDate(insurancePolicy.getEndDate());
		policy.setCoverageAmount(insurancePolicy.getCoverageAmount());
		ClientDto cl = insurancePolicy.getClientDto();
		Client c = new Client();
		c.setName(cl.getName());
		c.setDateOfBirth(cl.getDateOfBirth());
		c.setContactInformation(cl.getContactInformation());
		c.setAddress(cl.getAddress());
		policy.setClient(c);

		return modelMapper.map(insuranceRepo.save(policy), InsurancePolicyDto.class);
	}

	@Override
	public void deleteInsurancePolicy(int id) {
		InsurancePolicy policy = insuranceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("InsurancePolicy", "id", id));
		insuranceRepo.delete(policy);

	}

}
