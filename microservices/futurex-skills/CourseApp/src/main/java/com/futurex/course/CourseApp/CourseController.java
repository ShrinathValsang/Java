package com.futurex.course.CourseApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String index() {
        return "Course App Home";
    }

    @RequestMapping("/courses")
    public List<Course> getCourses() {
        /*return Arrays.asList(
                new Course("21011", "Electrical Engg", "University of Morocco"),
                new Course("21012", "Mechanical Engg", "University of Edinburgh"),
                new Course("21010", "Civil Engg", "University of Sweden"));*/
        return courseRepository.findAll();
    }

    @RequestMapping("/course/{id}")
    public Course getCourse(@PathVariable(name = "id") BigInteger courseid) {
        //return courseRepository.getOne(courseid);
        Course course = courseRepository.findById(courseid).orElseThrow(()-> new IllegalArgumentException("Course id not found! " + courseid));
        return course;
        /*if (op.isPresent()) {
            return (Course) op.get();
        } else
            return new Course(new BigInteger("000000000"), "NULL", "NULL");*/
    }

    @RequestMapping(method = RequestMethod.POST, value = "/course")
    public Course saveCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    /*@RequestMapping(method = RequestMethod.DELETE, value = "/course")
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }*/

    @RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")
    public void deleteCoursebyId(@PathVariable(name = "id") BigInteger courseid) {
        courseRepository.deleteById(courseid);
    }
}
