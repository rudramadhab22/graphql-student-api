package com.rudra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudra.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	

}
