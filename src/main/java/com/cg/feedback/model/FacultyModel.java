package com.cg.feedback.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FacultyModel {
	@NotNull(message="ID cannot be null")
    private long facultyId;	
	@NotBlank(message="Faculty Name cannot be empty")
    private String facultyName;
	@NotBlank(message="Faculty Skills cannot be empty")
    private String facultySkills;
    
	public FacultyModel() {
	}

	public FacultyModel(long facultyId, String facultyName, String facultySkills) {
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultySkills = facultySkills;
	}

	public long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultySkills() {
		return facultySkills;
	}

	public void setFacultySkills(String facultySkills) {
		this.facultySkills = facultySkills;
	}

	@Override
	public String toString() {
		return "FacultyEntity [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultySkills="
				+ facultySkills + "]";
	}
}
