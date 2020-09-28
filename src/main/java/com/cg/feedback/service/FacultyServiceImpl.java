package com.cg.feedback.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.feedback.enitity.FacultyEntity;
import com.cg.feedback.exception.CustomException;
import com.cg.feedback.model.FacultyModel;
import com.cg.feedback.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService{
	@Autowired
	FacultyRepository facultyRepository;

	public FacultyEntity of(FacultyModel source) {
		FacultyEntity result = null;
		if (source != null) {
			result = new FacultyEntity();
			result.setFacultyId(source.getFacultyId());
			result.setFacultyName(source.getFacultyName());
			result.setFacultySkills(source.getFacultySkills());
		}
		return result;
	}

	public FacultyModel of(FacultyEntity source) {
		FacultyModel result = null;
		if (source != null) {
			result = new FacultyModel();
			result.setFacultyId(source.getFacultyId());
			result.setFacultyName(source.getFacultyName());
			result.setFacultySkills(source.getFacultySkills());
		}
		return result;
	}

	@Override
	public List<FacultyModel> getAllFaculty() {
		try {
			List<FacultyModel> result = facultyRepository.findAll().stream().map(p -> of(p)).collect(Collectors.toList());
			if (result == null || result.size() < 1)
				throw new CustomException("No Facultys Available");
			return result;
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public FacultyModel getFacultyByName(String facultyName) {
		FacultyModel model = of(facultyRepository.findByFacultyName(facultyName));
		if (model == null) {
			throw new CustomException("No Such Faculty Exist");
		}
		return model;
	}

	@Override
	public void removeFaculty(long facultyId) {
		if(!facultyRepository.existsById(facultyId)) {
			throw new CustomException("Faculty doesn't exist...");
		}
		facultyRepository.deleteById(facultyId);
	}

	@Override
	public FacultyModel addFaculty(FacultyModel faculty) {

		if (faculty == null)
			throw new CustomException("Faculty Details should not be null...");
		if (facultyRepository.existsByFacultyIdOrFacultyName(faculty.getFacultyId(),faculty.getFacultyName()))
			throw new CustomException("Faculty Already Exist");
		return of(facultyRepository.save(of(faculty)));
	}
}
