package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.student;
import com.springboot.repository.studentrepository;

@Service
public class studentserviceimplements implements studentservice{
	
	@Autowired
	private studentrepository Studentrepository;
	 
    public student saveUser(student Student) {
	   return Studentrepository.save(Student);
	}
		
    public List<student> getAllstudents(){
    	return Studentrepository.findAll();
    }
    
    public student getstudentById(Long rollno) {
    	return Studentrepository.findById(rollno).orElse(null);
    }
    
    public void deletestudent(Long rollno) {
    	Studentrepository.deleteById(rollno);
    }
    
    public void deleteAllstudent() {
    	Studentrepository.deleteAll();
    }
    
    public student updatestudentById(Long rollno, student user) {
        student existingStudentOptional = Studentrepository.findById(rollno).orElse(null);

        if(existingStudentOptional != null) {
            existingStudentOptional.setName(user.getName());
            existingStudentOptional.setAddress(user.getAddress());
            existingStudentOptional.setDivision(user.getDivision());
            existingStudentOptional.setMobileno(user.getMobileno());
            existingStudentOptional.setStandard(user.getStandard());
            return Studentrepository.save(existingStudentOptional);  
        } else {
            throw new RuntimeException("Student not found with ID: " + rollno);
        }
    }



}
