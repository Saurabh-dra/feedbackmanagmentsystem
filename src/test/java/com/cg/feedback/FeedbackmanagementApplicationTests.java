package com.cg.feedback;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.feedback.enitity.CourseEntity;
import com.cg.feedback.exception.CustomException;
import com.cg.feedback.model.CourseModel;
import com.cg.feedback.repository.CourseRepository;
import com.cg.feedback.service.CourseService;
import com.cg.feedback.service.CourseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackmanagementApplicationTests {

	@Autowired
	private CourseService service;
	@Autowired
	private CourseServiceImpl serviceImpl;

	@MockBean
	private CourseRepository repo;

//	@Test
//	public void addCourseTest() throws CustomException {
//		CourseEntity courseEntity = serviceImpl.of(new CourseModel(101, "Java"));
//		when(repo.save(courseEntity)).thenReturn(courseEntity);
//		CourseModel model = service.addCourse(courseEntity);
//		assertEquals(courseEntity.getCourseId(), model.getCourseId());
//	}
	
	@Test
	public void addCourseTestException() throws CustomException{
		assertThrows(CustomException.class,()->{service.addCourse(null);});
	}
	
	@Test
	public void removeCourseTest() throws CustomException {
		when(repo.existsById(2L)).thenReturn(true);
		service.removeCourse(2);
		verify(repo).deleteById(2L);
	}
}
