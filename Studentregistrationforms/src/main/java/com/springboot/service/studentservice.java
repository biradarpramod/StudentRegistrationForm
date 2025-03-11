package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.model.student;

@Service
public interface studentservice {

	student saveUser(student Student);	
	
	List<student> getAllstudents();
	
	student getstudentById(Long rollno);

	void deletestudent(Long rollno);
	
	void deleteAllstudent();
	
	student updatestudentById(Long rollno, student user);

}
