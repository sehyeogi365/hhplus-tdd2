package hhdplus.hhplus_tdd2.domain.reserve.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReserveCommand {
    private int id;
    private int userId;
    private int lectureId;
}
