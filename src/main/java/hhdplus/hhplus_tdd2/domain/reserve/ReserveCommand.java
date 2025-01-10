package hhdplus.hhplus_tdd2.domain.reserve;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReserveCommand {
    private int id;
    private int userId;
    private int lectureId;
}
