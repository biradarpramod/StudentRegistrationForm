package com.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.student;
import com.springboot.service.studentservice;

@RestController
@RequestMapping("/api")
public class studentcontroller {
	
	@Autowired
	private studentservice Studentservice;
	
	@PostMapping("/savestudent")
	public ResponseEntity<student> saveStudent(@RequestBody student Student){
		student savedUser = Studentservice.saveUser(Student);
		return ResponseEntity.ok(savedUser);
	}

	@GetMapping("/getstudents")
	public ResponseEntity<List<student>> getAllstudents() {
		return ResponseEntity.ok(Studentservice.getAllstudents());
	}
	
	@GetMapping("/getstudent/{rollno}") 
    public ResponseEntity<student> getstudentById(@PathVariable Long rollno) {
	    student user = Studentservice.getstudentById(rollno);
	    if (user != null) {
	         return ResponseEntity.ok(user);
	    } else {
	         return ResponseEntity.notFound().build();
	    }
	}
    
    
    @DeleteMapping("deletestudent/{rollno}")
    public ResponseEntity<String> deletestudent(@PathVariable Long rollno) {
    	Studentservice.deletestudent(rollno);
    	return ResponseEntity.ok("Student Successfully deleted");
    }
    
    @DeleteMapping("deleteAllstudent")
    public ResponseEntity<String> deleteAllstudent() {
    	Studentservice.deleteAllstudent();
    	return ResponseEntity.ok("Delete All Students");
    }
    
    @PutMapping("updatestudent/{rollno}")
    public ResponseEntity<String> updatestudentById(@PathVariable Long rollno, @RequestBody student user) {
        student updatedStudent = Studentservice.updatestudentById(rollno, user);
        ResponseEntity.ok(updatedStudent);
        return ResponseEntity.ok("Updated Successfully");
    }
}
