package com.tcs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.jdbc.CourseJPADao;
import com.tcs.jdbc.StudentJPADao;
import com.tcs.model.Course;
import com.tcs.model.Passport;
import com.tcs.model.Review;
import com.tcs.model.Student;
import com.tcs.repository.CourseRepository;


//@SpringBootApplication
public class StudentJPAApp implements CommandLineRunner {

	@Autowired
	StudentJPADao studentJpadao;
	
	@Autowired
	CourseJPADao courseJpadao;
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(StudentJPAApp.class, args);
	}

	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//studentJpadao.saveStudentWithPassport();
		log.info("\n Find course by id :");
		
		// Student and passport has one- one relation ship so. it will be eager loading.
		 /*Though we are fetching only student detail, it will eagerly fetch Passport details as well
		  * solun: To fetch lazily : @OneToOne(fetch = FetchType.LAZY) on Passport field in Student class
		  * */
		
		List<Student> allStudents=studentJpadao.findAllStudents();   
		allStudents.forEach((students)->{
			
			log.info("\n"+students);
		
		});
		
		
		// student with passport details.
		
		studentJpadao.fetchStudentWithPassportDetails(1001L);
		
		List<Review> reviews=new ArrayList<>();
		
		reviews.add(new Review("Nice", "4"));
		reviews.add(new Review("Recomended to all learners", "5"));
		
		
		studentJpadao.addReviewsForTheCourse(1004, reviews);
		
		List<Course> coursesRegistered=new ArrayList<>();
		
		coursesRegistered.add(courseJpadao.findByid(4001));
		coursesRegistered.add(courseJpadao.findByid(4002));
		log.info("coursesRegistered: {}",coursesRegistered);
		
		// insert student and course
		
		Student student=new Student("Jack");
		Course course=new Course("python","3h");
		Passport passport=new Passport("B203020AV");
		student.setPassport(passport);
		
		studentJpadao.insertStudentAndCourse(student,course);
		
		//Register student for multiple courses
		
		List<Course> courses=courseJpadao.findAllCourses();
		
		studentJpadao.registerMultipleCoursesForStudent(courses, 4002L);
		
		
		//Register one student with one course.
		Course course1=courseJpadao.findByid(1004);
		Student student1 =new Student("Inayath");
		studentJpadao.registerCourseForStudent(course1,student1);
		
		
	}
	
	
	

}
