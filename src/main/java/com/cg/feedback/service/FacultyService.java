package com.cg.feedback.service;

import java.util.List;

import javax.validation.Valid;

import com.cg.feedback.enitity.FacultyEntity;
import com.cg.feedback.model.FacultyModel;


public interface FacultyService {
	List<FacultyModel> getAllFaculty();
	FacultyModel getFacultyByName(String facultyName);
	void removeFaculty(long facultyId);
	FacultyModel addFaculty(@Valid FacultyModel faculty);
}
