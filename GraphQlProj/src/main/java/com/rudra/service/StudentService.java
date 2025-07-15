package com.rudra.service;

import java.util.List;

import com.rudra.entity.Student;

public interface StudentService {
	public List<Student>getAllStudents();
	public Student saveStudent(Student student);
	public Student getStudentById(Integer id);
	public Student updateStudentById(Integer id,Student student);
	public Student deleteStudentById(Integer id);
	

}
