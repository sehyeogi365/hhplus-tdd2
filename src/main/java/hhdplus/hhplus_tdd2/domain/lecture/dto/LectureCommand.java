package hhdplus.hhplus_tdd2.domain.lecture.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LectureCommand {
    private long id;
    private String name;
    private String instructor;
}
