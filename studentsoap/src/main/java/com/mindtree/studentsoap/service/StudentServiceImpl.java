package com.mindtree.studentsoap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import https.mindtree_com.studentssoap.Student;

@Service
public class StudentServiceImpl 
{
	static List<Student> students=new ArrayList<>();
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	public List<Student> getAllStudent()
	{
		return students;
	}
	
	public void updateStudent(int studentId,int marks)
	{
		for(Student s:students)
		{
			if(s.getStudentId()==studentId)
			{
				s.setMarks(marks);
				break;
			}
		}
	}
	
	public void deleteStudent(int studentId)
	{
		for(Student s:students)
		{
			if(s.getStudentId()==studentId)
			{
				students.remove(s);
				break;
			}
		}
	}
	
	public String getStudentById(int studentId)
	{
		String name="";
		for(Student s:students)
		{
			if(s.getStudentId()==studentId)
			{
				name=s.getStudentName();
			}
		}
		return name;
	}
}
