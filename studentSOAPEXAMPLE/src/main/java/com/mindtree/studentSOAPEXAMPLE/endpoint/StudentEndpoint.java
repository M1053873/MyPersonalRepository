package com.mindtree.studentSOAPEXAMPLE.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mindtree.studentSOAPEXAMPLE.service.StudentService;

import https.mindtree_com.studentsoapexample.AddStudent;
import https.mindtree_com.studentsoapexample.DeleteStudent;
import https.mindtree_com.studentsoapexample.GetAllStudents;
import https.mindtree_com.studentsoapexample.Student;
import https.mindtree_com.studentsoapexample.UpdateStudent;

@Endpoint
public class StudentEndpoint 
{
	@Autowired
	StudentService sv;
	
	@PayloadRoot(namespace="https://mindtree.com/studentSOAPEXAMPLE",localPart="addStudent")
	public void addStudent(@RequestPayload AddStudent addStudent)
	{
		Student student=new Student();
		student.setStudentId(addStudent.getStudentId());
		student.setStudentName(addStudent.getStudentName());
		student.setMarks(addStudent.getMarks());
		
		sv.addStudent(student);
		
	}
	
	@PayloadRoot(namespace="https://mindtree.com/studentSOAPEXAMPLE",localPart="getAllStudents")
	@ResponsePayload
	public GetAllStudents getStudents(@RequestPayload GetAllStudents get)
	{
		List<Student> students=new ArrayList<>();
		students=sv.getAllStudents();
		get.getStudents().addAll(students);
		return get;
	}
	
	@PayloadRoot(namespace="https://mindtree.com/studentSOAPEXAMPLE",localPart="updateStudent")
	public void updateStudent(@RequestPayload UpdateStudent updateStudent)
	{
		sv.updateStudent(updateStudent.getStudentId(),updateStudent.getMarks());
	}
	
	@PayloadRoot(namespace="https://mindtree.com/studentSOAPEXAMPLE",localPart="deleteStudent")
	public void deleteStudent(@RequestPayload DeleteStudent deleteStudent)
	{
		sv.deleteStudent(deleteStudent.getStudentId());
	}
}
