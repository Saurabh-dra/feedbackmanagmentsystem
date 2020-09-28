package com.cg.feedback.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CourseModel {
	@NotNull(message = "Course ID cannot be empty")
    private long courseId;	
    
	@NotBlank(message="Course Name cannot be empty")
    private String courseName;
	
	public CourseModel() {
	}

	public CourseModel(long courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
}
