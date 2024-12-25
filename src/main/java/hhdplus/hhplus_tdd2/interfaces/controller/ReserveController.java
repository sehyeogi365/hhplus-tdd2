package hhdplus.hhplus_tdd2.interfaces.controller;

import hhdplus.hhplus_tdd2.domain.reserve.Reserve;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveCommand;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveInfo;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReserveController {

    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }



    //예약기능 최대 30명까지, 예약인원 중복 안되게
    @PostMapping("{userId}/reserve/insert")
    public ReserveRequest reserve(ReserveResponse reserveResponse, @PathVariable int userId){

        return reserveService.insertReservation(reserveResponse);
    }

    //예약내역 조회
    @GetMapping("{userId}/reserve/history")
    public List<ReserveInfo> history(@PathVariable int userId){

        return reserveService.findReservation(userId);
    }

    //예약수정
    @PostMapping("{userId}/reserve/update")
    public ReserveCommand update(@PathVariable int userId){

        ReserveCommand update = reserveService.modifyReservation(userId);

        update.setUserId(userId);

        return update;
    }

    //예약취소
    @GetMapping("/reserve/delete")
    public String delete(int id){

       reserveService.deleteReservation(id);

       return "취소성공";

    }


}
