package com.rudra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudra.entity.Student;
import com.rudra.repo.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		
		return studentRepo.findById(id).orElseThrow(()-> new RuntimeException("User NotFound"));
	}

	@Override
	public Student updateStudentById(Integer id,Student student) {
		if(student.getStudentId().equals(id)) {
			return	studentRepo.save(student);
		}
		throw new RuntimeException("User Not found");
	}

	@Override
	public Student deleteStudentById(Integer id) {
		Student s=studentRepo.findById(id).orElseThrow(()-> new RuntimeException("User NotFound"));
		
		studentRepo.deleteById(s.getStudentId());
		return s;
	}

}
