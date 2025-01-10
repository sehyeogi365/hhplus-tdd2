package hhdplus.hhplus_tdd2.interfaces.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ReserveResponse {
    private int id;
    private int userId;
    private int lectureId;
    private Date createdAt;
    private Date updatedAt;
}
