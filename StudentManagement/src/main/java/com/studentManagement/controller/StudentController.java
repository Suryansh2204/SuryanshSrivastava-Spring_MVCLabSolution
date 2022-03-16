package com.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentManagement.entity.Student;
import com.studentManagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model model)
	{
		List<Student> students=studentService.findAll();
		model.addAttribute("student", students);
		return "list-Students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Student student =new Student();
		model.addAttribute("student", student);
		return "Student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model)
	{
		Student student=new Student();
		student=studentService.findById(id);
		model.addAttribute("student", student);
		return "Student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
								@RequestParam("name") String name,
								@RequestParam("department") String department,
								@RequestParam("country") String country)
	{
		if(id!=0)
		{
			Student student=studentService.findById(id);
			student.setName(name);
			student.setCountry(country);
			student.setDepartment(department);
		}
		else
		{
			Student student=new Student(name,department,country);
			studentService.save(student);
		}
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id)
	{
		studentService.deleteById(id);
		return "redirect:/student/list";
	}
	
}
