package com.example.demo.StudentDetailsServiceImplimentation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentDetails;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImplimentation implements StudentService {
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public List<StudentDetails> findAllStudent(int pageSize, int pageNo) {
		 org.springframework.data.domain.Pageable pageRequest = PageRequest.of(pageNo, pageSize);
		
		Page<StudentDetails> findAll = studentRepo.findAll(pageRequest);
		List<StudentDetails> content = findAll.getContent();
		
		return content;
	}

	@Override
	public List<StudentDetails> filterByMarks(Integer minMarks, Integer maxMarks,int pageSize,int pageNo) {
		Pageable page=PageRequest.of(pageNo, pageSize);
		
		Page filterByMarks= studentRepo.filterByMarks(minMarks,maxMarks,page);
		List content = filterByMarks.getContent();
		return content;
	}

	@Override
	public List<StudentDetails> filterByGender(String gender1,String gender2, String gender3, int pageSize, int pageNo) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		
		Page<StudentDetails> page = studentRepo.filterByGenderFilter(gender1,gender2,gender3, pageRequest);
		System.out.println(page+"hii");
		System.out.println(page.getContent()+"hello");
		List<StudentDetails> content = page.getContent(); 
		return content;
	}

	@Override
	public List<StudentDetails> filterByDateOfYear(int year, int pageSize, int pageNo) {
		Pageable page=PageRequest.of(pageNo, pageSize);
		Page<StudentDetails> byDateOfBirth = studentRepo.filterByDateOfBirth(year, page);
		List<StudentDetails> content = byDateOfBirth.getContent();
		return content;
	}

	@Override
	public List<StudentDetails> filterByGrade(Character gradeA, Character gradeB, Character gradeC, int pageSize, int pageNo) {
		Pageable page=PageRequest.of(pageNo, pageSize);
		Page<StudentDetails> findByGrade = studentRepo.filterByGrade(gradeA, gradeB, gradeC, page);
		List<StudentDetails> content = findByGrade.getContent();
		return content;
	}

	

}
