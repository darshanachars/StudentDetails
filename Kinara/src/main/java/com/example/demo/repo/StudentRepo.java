package com.example.demo.repo;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentDetails;

@Repository
public interface StudentRepo extends JpaRepository<StudentDetails,Integer> {
	@Query("select u from StudentDetails u where marks > ?1 and marks< ?2")
	public Page<StudentDetails> filterByMarks(Integer minMarks, Integer maxMarks,Pageable page);
	
	@Query("select u from StudentDetails u where gender in (?1,?2,?3)")
	public Page<StudentDetails> filterByGenderFilter(String gender1,String gender2, String gender3,Pageable page);
	
	@Query("select u from StudentDetails u where dateOfBirth like ?1%")
	public Page<StudentDetails> filterByDateOfBirth(int year, org.springframework.data.domain.Pageable page);
	
	@Query("select u from StudentDetails u where grade in (?1,?2,?3)")
	public  Page<StudentDetails> filterByGrade(Character gradeA,Character gradeB,Character gradeC, Pageable page);
}
