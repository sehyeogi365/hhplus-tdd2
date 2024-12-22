package hhdplus.hhplus_tdd2.controller;

import hhdplus.hhplus_tdd2.service.ReserveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ReserveController {

    private ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    //에약기능 최대 30명까지, 예약인원 중복 안되게
    //@PostMapping("/reserve/insert")
    //public String

    //예약수정
    //@PostMapping("/reserve/update")

    //예약취소
    //@GetMapping("/reserve/delete")

}
