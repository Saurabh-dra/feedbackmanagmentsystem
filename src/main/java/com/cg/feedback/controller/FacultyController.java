package com.cg.feedback.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.feedback.enitity.FacultyEntity;
import com.cg.feedback.model.FacultyModel;
import com.cg.feedback.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	FacultyService facultyService;
	
	@GetMapping(value = "/getall")
	public List<FacultyModel> getAllFacultys() {
		List<FacultyModel> Facultys = facultyService.getAllFaculty();
		return Facultys;
	}

	@GetMapping(value = "/{FacultyName}")
	public FacultyModel getFacultyByName(@PathVariable("facultyName") String facultyName) {
		FacultyModel Faculty = facultyService.getFacultyByName(facultyName);
		return Faculty;
	}

	@DeleteMapping(value = "/{facultyId}")
	public ResponseEntity<String> delteFacultyById(@PathVariable("facultyId") long facultyId) {
		facultyService.removeFaculty(facultyId);
		return new ResponseEntity<>("Faculty Deleted Successfully", HttpStatus.OK);
	}

	@PostMapping(value = "/addFaculty")
	public ResponseEntity<FacultyModel> addFaculty(@Valid @RequestBody FacultyModel faculty) {
		FacultyModel model = facultyService.addFaculty(faculty);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
}
