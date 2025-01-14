package hhdplus.hhplus_tdd2.domain.lecture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="instructor")
    private String instructor;

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name="updatedAt")
    private Date updatedAt;

    @Column(name="enrollment_start_date")
    private Date enrollment_start_date;

    @Column(name="enrollment_end_date")
    private Date enrollment_end_date;

    @Column(name="course_start_date")
    private Date course_start_date;

    @Column(name="max_enrollment")
    private int max_enrollment;

}
