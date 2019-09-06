package com.mindtree.studentsoap.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mindtree.studentsoap.service.StudentServiceImpl;

import https.mindtree_com.studentssoap.AddStudent;
import https.mindtree_com.studentssoap.DeleteStudent;
import https.mindtree_com.studentssoap.GetAllStudents;
import https.mindtree_com.studentssoap.GetStudentById;
import https.mindtree_com.studentssoap.GetStudentResponse;
import https.mindtree_com.studentssoap.Student;
import https.mindtree_com.studentssoap.UpdateStudent;

@Endpoint
public class StudentEndpoint 
{
	@Autowired
	StudentServiceImpl sv;
	
	@PayloadRoot(namespace="https://mindtree.com/studentssoap",localPart="addStudent")
	public void addStudent(@RequestPayload AddStudent addStudent)
	{
		Student student=new Student();
		student.setStudentId(addStudent.getStudentId());
		student.setStudentName(addStudent.getStudentName());
		student.setMarks(addStudent.getMarks());
		sv.addStudent(student);
		
	}
	
	@PayloadRoot(namespace="https://mindtree.com/studentssoap",localPart="getAllStudents")
	@ResponsePayload
	public GetAllStudents getAllStudents(@RequestPayload GetAllStudents getAllStudents)
	{
		List<Student> students=new ArrayList<>();
		students=sv.getAllStudents();
		getAllStudents.getStudents().addAll(students);
		return getAllStudents;
	}
	
	@PayloadRoot(namespace="https://mindtree.com/studentssoap",localPart="updateStudent")
	public void updateStudent(@RequestPayload UpdateStudent updateStudent)
	{
		sv.updateStudent(updateStudent.getStudentId(),updateStudent.getMarks());
	}
	
	@PayloadRoot(namespace="https://mindtree.com/studentssoap",localPart="deleteStudent")
	public void deleteStudent(@RequestPayload DeleteStudent deleteStudent)
	{
		sv.deleteStudent(deleteStudent.getStudentId());
	}
	
	@PayloadRoot(namespace="https://mindtree.com/studentssoap",localPart="getStudentById")
	@ResponsePayload
	public GetStudentResponse getStudentById(@RequestPayload GetStudentById getStudent)
	{
		String name=sv.getStudentById(getStudent.getStudentId());
		GetStudentResponse get=new GetStudentResponse();
		get.setStudentName(name);
		return get;
	}
}
