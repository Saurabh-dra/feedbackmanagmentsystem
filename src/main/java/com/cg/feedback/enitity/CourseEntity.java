package com.cg.feedback.enitity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "course")
public class CourseEntity {
	@Id
    private long courseId;	
	
	@NotBlank(message="Course Name cannot be empty")
    private String courseName;
	
	public CourseEntity() {
	}

	public CourseEntity(long courseId, String courseName) {
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
