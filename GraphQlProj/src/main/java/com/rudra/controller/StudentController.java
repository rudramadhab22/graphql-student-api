package com.rudra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.rudra.entity.Student;
import com.rudra.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	@QueryMapping
	public List<Student> findAllStudent(){
		return service.getAllStudents();
	}
	
    @QueryMapping
    public Student getStudentById(@Argument Integer sid) {
        return service.getStudentById(sid);
    }

    
    @MutationMapping
    public Student saveStudent(@Argument String studentName, @Argument String studentAdress) {
        Student student = new Student();
        student.setStudentName(studentName);
        student.setStudentAdress(studentAdress);
        return service.saveStudent(student);
    }

    
    @MutationMapping
    public Student updateStudentById(@Argument Integer id,
                                     @Argument String studentName,
                                     @Argument String studentAdress) {
    	 Student stud= service.getStudentById(id);
        
        if(studentName!=null) {
        	stud.setStudentName(studentName);
        }
        if(studentAdress!=null) {
        	stud.setStudentAdress(studentAdress);
        }
     
      return service.updateStudentById(id, stud);
    }

    
    @MutationMapping
    public Student deleteStudentById(@Argument Integer id) {
        return service.deleteStudentById(id);
    }

}
