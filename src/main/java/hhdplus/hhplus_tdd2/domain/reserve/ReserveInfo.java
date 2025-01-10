package hhdplus.hhplus_tdd2.domain.reserve;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
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
}
