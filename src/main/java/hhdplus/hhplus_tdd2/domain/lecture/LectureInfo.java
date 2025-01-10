package hhdplus.hhplus_tdd2.domain.lecture;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class LectureInfo {//강의 카드 한장에 들어가는 정보

    private int id;

    private String name;

    private String instructor;

    private Date enrollment_start_date;
    private Date enrollment_end_date;
    private Date course_start_date;
    private int max_enrollment;


}
