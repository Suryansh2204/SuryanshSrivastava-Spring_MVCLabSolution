package com.studentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentManagement.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(int id);
	
	public void save(Student student);
	
	public void deleteById(int id);
}
