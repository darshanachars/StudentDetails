package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentDetailsServiceImplimentation.StudentServiceImplimentation;
import com.example.demo.entity.StudentDetails;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/studentDetails")
public class StudentController {
	@Autowired
	private StudentService studentService;

	// this method is to fetch all the student details without filtering
	@GetMapping("/findAll")
	public ResponseEntity<List<StudentDetails>> getAllStudent(
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "0", required = false) Integer pageNo) {
		List<StudentDetails> findAllStudent = studentService.findAllStudent(pageSize, pageNo);
		return ResponseEntity.ok(findAllStudent);
	}

	// This method is to fetch student details with marks filter
	@GetMapping("/filterByMarks")
	public ResponseEntity<List<StudentDetails>> filterByName(@RequestParam Integer minMarks,
			@RequestParam Integer maxMarks, @RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "0", required = false) Integer pageNo) {
		List<StudentDetails> findByName = studentService.filterByMarks(minMarks, maxMarks, pageSize, pageNo);
		return ResponseEntity.ok(findByName);
	}

	// This method is to fetch student details with gender filter
	@GetMapping("/filterByGender")
	public ResponseEntity<List<StudentDetails>> filterByGenderFilter(@RequestParam(required = false) String gender1,
			@RequestParam(required = false) String gender2, @RequestParam(required = false) String gender3,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "0", required = false) Integer pageNo) {
		List<StudentDetails> genderDetail = studentService.filterByGender(gender1, gender2, gender3, pageSize, pageNo);
		return ResponseEntity.ok(genderDetail);
	}

	// This method is to fetch student details with student birth year filter
	@GetMapping("/filterByBirthYear")
	public ResponseEntity<List<StudentDetails>> filterByBirthYear(@RequestParam int year,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "0", required = false) Integer pageNo) {
		List<StudentDetails> findByDateOfYear = studentService.filterByDateOfYear(year, pageSize, pageNo);
		return ResponseEntity.ok(findByDateOfYear);

	}

	// This method is to find student details with grade filter
	@GetMapping("/filterByGrade")
	public ResponseEntity<List<StudentDetails>> filterByGrade(@RequestParam(required = false) Character grade1,
			@RequestParam(required = false) Character grade2, @RequestParam(required = false) Character grade3,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "0", required = false) Integer pageNo) {
		List<StudentDetails> findByGrade = studentService.filterByGrade(grade1, grade2, grade3, pageSize, pageNo);

		return ResponseEntity.ok(findByGrade);
	}
}
