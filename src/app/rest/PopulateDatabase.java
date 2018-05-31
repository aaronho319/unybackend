package app.rest;

import app.entity.*;
import app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PopulateDatabase {
    //region repositories
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    PointRepository pointRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfessorCourseRepository professorCourseRepository;
    //endregion

    @PostConstruct
    public void populateDatabase() throws Exception {
//        Student kurt = new Student("Kurt Vincent Bautista", "kurt.bautista@obf.ateneo.edu", "BS CS", 4);
//        Course es = new Course("CS 119.2", "SPECIAL TOPICS IN LANGUAGES: ENTERPRISE SYSTEMS PROGRAMMING");
//        Professor sir_jeff = new Professor("Jeffrey Jongko");
//        ProfessorCourse professorCourse = new ProfessorCourse();
//
//        Long studentId = studentRepository.saveAndFlush(kurt).getId();
//        Long courseId = courseRepository.saveAndFlush(es).getId();
//        Long professorId = professorRepository.saveAndFlush(sir_jeff).getId();
//        professorCourse.setCourse(courseRepository.findOne(courseId));
//        professorCourse.setProfessor(professorRepository.findOne(professorId));
//        Long professorCourseId = professorCourseRepository.saveAndFlush(professorCourse).getId();
//
//        Student student = studentRepository.findOne(studentId);
//        ProfessorCourse professorCourse2 = professorCourseRepository.findOne(professorCourseId);
//        Review review = new Review(5, "Very good", student, professorCourse2);
//        professorCourse2.getReviews().add(review);
//
//        Long reviewId = reviewRepository.saveAndFlush(review).getId();
//
//        Review review2 = reviewRepository.findOne(reviewId);
//        Point point = new Point(1, student, review2);
//        review2.getPoints().add(point);
//
//        pointRepository.saveAndFlush(point);
    }
}
