package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.student;

@Repository
public interface studentrepository extends JpaRepository<student, Long>{

}
