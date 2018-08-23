package com.microservices.studentdata.StudentDataDemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Controller {

private static final HttpStatus ResponseEntity = null;

@Autowired
private Service service;

@Autowired
private StudentDataRepository studentDataRepository;

@RequestMapping(value="/create", method= RequestMethod.POST)
@ResponseBody
@ResponseStatus(HttpStatus.CREATED)
 public ResponseEntity<String> createStudentData(@RequestBody StudentData studentdata)
 
 {
	
	StudentData studentData = studentDataRepository.save(studentdata);
	return new ResponseEntity<String>(HttpStatus.CREATED);
}
@RequestMapping(value="/get", method = RequestMethod.GET)
@ResponseBody
public List<StudentData> getAllStudentsData(){
	List<StudentData> studentsData = (List<StudentData>) studentDataRepository.findAll();
	return studentsData;
}

@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
@ResponseBody
public Optional<StudentData> getStudentsData(@PathVariable Long id){
	Optional<StudentData> studentsData = studentDataRepository.findById(id);
	return studentsData;
}
@RequestMapping(value="/update/{id}/{firstName}", method = RequestMethod.PUT)
@ResponseBody
public ResponseEntity<String> updateStudentsData(@RequestBody StudentData studentData,@PathVariable Long id, @PathVariable String firstName){
	Optional<StudentData> studentsData = studentDataRepository.findById(id);
	studentData.setFirstName(firstName);
	studentDataRepository.save(studentData);
	return new ResponseEntity<String>(HttpStatus.OK);
	
}

@RequestMapping(value="/del/{id}", method = RequestMethod.DELETE)
@ResponseBody
public void deleteStudentsData(@PathVariable Long id){

	 studentDataRepository.deleteById(id);
	
}






	
	
}
