package com.futurex.services.CourseCatalog;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CatalogController {

  /*@RequestMapping("/")
  public String home() {
    return "Welcome to Futurex Catalog app!";
  }*/

  @RequestMapping("/")
  public String getCourseAppHome() {
    String courseAppMessage = "";
    String courseAppUrl = "http://localhost:8080/";

    RestTemplate restTemplate = new RestTemplate();
    courseAppMessage = restTemplate.getForObject(courseAppUrl, String.class);

    return "Welcome to Futurex Course Catalog app!\n" + courseAppMessage;
  }

  @RequestMapping("/catalog")
  public String getCatalog() {
    String courseAppUrl = "http://localhost:8080/courses";
    RestTemplate restTemplate = new RestTemplate();
    String caResponse = restTemplate.getForObject(courseAppUrl, String.class);

    return "Our courses are: " + caResponse;
  }

  @RequestMapping("/catalogCourses")
  public List<Course> getCatalogCourses() {
    String courseAppUrl = "http://localhost:8080/courses";
    RestTemplate restTemplate = new RestTemplate();
    List<Course> courses = restTemplate.getForObject(courseAppUrl, List.class);

    return courses;
  }

  @RequestMapping("/catalogCourse/{id}")
  public Course getCatalogCourse(@PathVariable(name = "id") BigInteger courseid) {
    String courseAppUrl = "http://localhost:8080/course/" + courseid;

    RestTemplate restTemplate = new RestTemplate();
    Course course = restTemplate.getForObject(courseAppUrl, Course.class);
    return course;
  }
}
