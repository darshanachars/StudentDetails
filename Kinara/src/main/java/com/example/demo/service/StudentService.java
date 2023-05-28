package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.StudentDetails;

public interface StudentService {
	public List<StudentDetails> findAllStudent(int pageSize, int pageNo);
	public List<StudentDetails> filterByMarks(Integer minMarks,Integer maxMarks,int pageSize,int pageNo);
	public List<StudentDetails> filterByGender(String gender1,String gender2,String gender3,int pageSize, int pageNo);
	public List<StudentDetails> filterByDateOfYear(int year, int pageSize, int pageNo);
	public List<StudentDetails> filterByGrade(Character gradeA, Character gradeB, Character gradeC, int pageSize, int pageNo);
}
