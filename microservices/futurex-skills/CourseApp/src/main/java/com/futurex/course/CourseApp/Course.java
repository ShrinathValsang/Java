package com.futurex.course.CourseApp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {

    // Make sure the fields are smallcase otherwise for camelCase
    // JPA would insert an '_' between cases.
    // e.g. for courseId, it would look for field "course_id"
    @Id
    public BigInteger courseid;
    public String coursename;
    public String courseauthor;

    public Course() {
    }

    public Course(BigInteger courseId, String courseName, String courseAuthor) {
        this.courseid = courseId;
        this.coursename = courseName;
        this.courseauthor = courseAuthor;
    }

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCourseauthor() {
        return courseauthor;
    }

    public void setCourseauthor(String courseauthor) {
        this.courseauthor = courseauthor;
    }
}
