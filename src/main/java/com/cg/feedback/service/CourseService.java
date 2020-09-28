package com.cg.feedback.service;

import java.util.List;

import com.cg.feedback.enitity.CourseEntity;
import com.cg.feedback.model.CourseModel;

public interface CourseService {
	List<CourseModel> getAllCourses();
	CourseModel getCourseByName(String courseName);
	void removeCourse(long courseId);
	CourseModel addCourse(CourseModel course);

}
