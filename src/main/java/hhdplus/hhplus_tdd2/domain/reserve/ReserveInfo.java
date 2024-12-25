package hhdplus.hhplus_tdd2.domain.reserve;

import java.util.Date;

public class ReserveInfo {
    //예약 카드 한장에 들어갈 정보
    private int id;
    private int userId;
    private int lectureId;

    private String name;

    private String instructor;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
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
