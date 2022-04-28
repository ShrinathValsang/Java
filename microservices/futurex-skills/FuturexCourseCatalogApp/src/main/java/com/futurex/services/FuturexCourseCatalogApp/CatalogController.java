package com.futurex.services.FuturexCourseCatalogApp;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CatalogController {

  @Autowired
  private EurekaClient eurekaClient;

  /*@RequestMapping("/")
  public String home() {
    return "Welcome to Futurex Catalog app!";
  }*/

  /*@RequestMapping("/")
  public String getCourseAppHome() {
    String courseAppMessage = "";
    String courseAppUrl = "http://localhost:8080/";

    RestTemplate restTemplate = new RestTemplate();
    courseAppMessage = restTemplate.getForObject(courseAppUrl, String.class);

    return "Welcome to Futurex Course Catalog app!\n" + courseAppMessage;
  }*/

  @RequestMapping("/")
  @CircuitBreaker(name = "getCourseAppHomeCB", fallbackMethod = "fallback")
  public String getCourseAppHome() {
    //String courseAppUrl = "http://localhost:8080/";
    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("futurex-course-app", false);
    String courseAppMessage = "";
    String courseAppUrl = instanceInfo.getHomePageUrl();

    RestTemplate restTemplate = new RestTemplate();
    courseAppMessage = restTemplate.getForObject(courseAppUrl, String.class);

    return "Welcome to Futurex Course Catalog app!\n" + courseAppMessage;
  }

  public String fallback(Throwable t) {
    return "Welcome to Futurex Course Catalog app -- fallback!";
  }

  /**
   * Check actuator endpoints for the correct registration of
   * circuit breakers and rate limiters.
   * http://localhost:8083/actuator/circuitbreakers
   *
   *
   * @return
   */
  @RequestMapping("/catalog")
  @CircuitBreaker(name = "getCourseAppHomeCB", fallbackMethod = "fallback2")
  public String getCatalog() {
    /*String courseAppUrl = "http://localhost:8080/courses";
    RestTemplate restTemplate = new RestTemplate();
    String caResponse = restTemplate.getForObject(courseAppUrl, String.class);

    return "Our courses are: " + caResponse;*/

    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("futurex-course-app", false);
    String courseAppUrl = instanceInfo.getHomePageUrl();

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(courseAppUrl + "/courses", String.class);
  }

  public String fallback2() {
    return "fallback2";
  }


  @RequestMapping("/catalogCourses")
  public List<Course> getCatalogCourses() {
    //String courseAppUrl = "http://localhost:8080/courses";
    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("futurex-course-app", false);
    String courseAppUrl = instanceInfo.getHomePageUrl();
    RestTemplate restTemplate = new RestTemplate();
    List<Course> courses = restTemplate.getForObject(courseAppUrl + "/courses", List.class);

    return courses;
  }

  @RequestMapping("/catalogCourse/{id}")
  public Course getCatalogCourse(@PathVariable(name = "id") BigInteger courseid) {
    //String courseAppUrl = "http://localhost:8080/course/" + courseid;

    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("futurex-course-app", false);
    String courseAppUrl = instanceInfo.getHomePageUrl();
    RestTemplate restTemplate = new RestTemplate();
    Course course = restTemplate.getForObject(courseAppUrl+ "/course/" + courseid, Course.class);
    return course;
  }

  @RequestMapping("/catalogUser/{id}")
  public List<User> getCatalogUser(@PathVariable(name = "id") BigInteger userid) {
    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("futurex-user-app", false);
    String userAppUrl = instanceInfo.getHomePageUrl();
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(userAppUrl+ "/user/" + userid, List.class);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/catalogCourse/{courseid}")
  public List<User> getCatalogUserByCourse(@PathVariable(name = "courseid") BigInteger courseid) {
    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("futurex-user-app", false);
    String userAppUrl = instanceInfo.getHomePageUrl();

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(userAppUrl + "/usercourse/" + courseid, List.class);
  }
}
