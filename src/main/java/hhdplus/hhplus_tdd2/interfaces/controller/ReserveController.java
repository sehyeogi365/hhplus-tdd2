package hhdplus.hhplus_tdd2.interfaces.controller;

import hhdplus.hhplus_tdd2.domain.reserve.Reserve;
import hhdplus.hhplus_tdd2.service.ReserveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReserveController {

    private ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    //예약내역 조회
    @GetMapping("{userId}/reserve/history")
    public List<Reserve> history(@PathVariable int userId){

        return reserveService.findReservation(userId);
    }

    //에약기능 최대 30명까지, 예약인원 중복 안되게
    @PostMapping("{userId}/reserve/insert")
    public Reserve reserve(Reserve reserve, @PathVariable int userId){

        Reserve insert = reserveService.insertReservation(reserve);

        reserve.setUserId(userId);

        return reserve;
    }

    //예약수정
    @PostMapping("{userId}/reserve/update")
    public Reserve update(Reserve reserve, @PathVariable int userId){

        Reserve update = reserveService.modifyReservation(reserve);

        reserve.setUserId(userId);

        return update;
    }

    //예약취소
    @GetMapping("/reserve/delete")
    public String delete(Reserve reserve){

       int count =  reserveService.deleteReservation(reserve);

       if(count > 0){
           return "삭제성공";
       }
        return "삭제 실패";
    }


}
