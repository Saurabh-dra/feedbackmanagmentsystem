package com.cg.feedback.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.feedback.enitity.CourseEntity;
import com.cg.feedback.exception.CustomException;
import com.cg.feedback.model.CourseModel;
import com.cg.feedback.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	public CourseEntity of(CourseModel source) {
		CourseEntity result = null;
		if (source != null) {
			result = new CourseEntity();
			result.setCourseId(source.getCourseId());
			result.setCourseName(source.getCourseName());
		}
		return result;
	}

	public CourseModel of(CourseEntity source) {
		CourseModel result = null;
		if (source != null) {
			result = new CourseModel();
			result.setCourseId(source.getCourseId());
			result.setCourseName(source.getCourseName());
		}
		return result;
	}

	@Override
	public List<CourseModel> getAllCourses() {
		try {
			List<CourseModel> result = courseRepository.findAll().stream().map(p -> of(p)).collect(Collectors.toList());
			if (result == null || result.size() < 1)
				throw new CustomException("No Courses Available");
			return result;
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public CourseModel getCourseByName(String courseName) {
		CourseModel model = of(courseRepository.findByCourseName(courseName));
		if (model == null) {
			throw new CustomException("No Such Course Exist");
		}
		return model;
	}

	@Override
	public void removeCourse(long courseId) {
		if(!courseRepository.existsById(courseId)) {
			throw new CustomException("Course doesn't exist...");
		}
		courseRepository.deleteById(courseId);
	}

	@Override
	public CourseModel addCourse(CourseModel course) {
		if (course == null)
			throw new CustomException("Course Details should not be null...");
		if (courseRepository.findByCourseName(course.getCourseName()) != null)
			throw new CustomException("Course Already Exist");
		return of(courseRepository.save(of(course)));
	}
}