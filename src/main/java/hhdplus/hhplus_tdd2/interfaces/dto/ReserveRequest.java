package hhdplus.hhplus_tdd2.interfaces.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReserveRequest {
    private int id;
    private int userId;
    private int lectureId;
}
