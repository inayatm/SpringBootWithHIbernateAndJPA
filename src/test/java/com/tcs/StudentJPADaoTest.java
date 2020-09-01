package com.tcs;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.jdbc.StudentJPADao;
import com.tcs.model.Review;

public class StudentJPADaoTest {
	
   @Autowired	
   StudentJPADao stdJpa;
	
	@Test
	public void retrieveReviewsForCourseTest() {
		List<Review> reviews=stdJpa.retrieveReviewsForCourse(1001);
		assertNotNull(reviews);
		
	}

}
