package hhdplus.hhplus_tdd2.interfaces.controller;

import java.util.Date;

public class LectureResponse {

    private int id;
    private String name;

    private String instructor;

    private Date createdAt;
    private Date updatedAt;
    private Date enrollment_start_date;
    private Date enrollment_end_date;
    private Date course_start_date;
    private int max_enrollment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getEnrollment_start_date() {
        return enrollment_start_date;
    }

    public void setEnrollment_start_date(Date enrollment_start_date) {
        this.enrollment_start_date = enrollment_start_date;
    }

    public Date getEnrollment_end_date() {
        return enrollment_end_date;
    }

    public void setEnrollment_end_date(Date enrollment_end_date) {
        this.enrollment_end_date = enrollment_end_date;
    }

    public Date getCourse_start_date() {
        return course_start_date;
    }

    public void setCourse_start_date(Date course_start_date) {
        this.course_start_date = course_start_date;
    }

    public int getMax_enrollment() {
        return max_enrollment;
    }

    public void setMax_enrollment(int max_enrollment) {
        this.max_enrollment = max_enrollment;
    }
}
