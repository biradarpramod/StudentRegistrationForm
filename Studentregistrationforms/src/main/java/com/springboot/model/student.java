package com.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long rollno;
	
	private String name;
	
	private String standard;
	
	private String division;
	
	private String address;
	
	private String mobileno;

	public Long getRollno() {
		return rollno;
	}

	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public student( Long rollno, String name, String standard, String division, String address, String mobileno) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.standard = standard;
		this.division = division;
		this.address = address;
		this.mobileno = mobileno;
	}

	public student() {
		super();
	}

	@Override
	public String toString() {
		return "student [rollno=" + rollno + ", name=" + name + ", standard=" + standard + ", division=" + division
				+ ", address=" + address + ", mobileno=" + mobileno + "]";
	}

}
