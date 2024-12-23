package hhdplus.hhplus_tdd2.service;

import hhdplus.hhplus_tdd2.domain.Reserve;
import hhdplus.hhplus_tdd2.repository.ReserveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReserveService {

    private final ReserveRepository reserveRepository;

    public ReserveService(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    //예약내역 조회
    public List<Reserve> findReservation(int userId){

        return reserveRepository.findAll(userId);
    }

    //에약기능 최대 30명까지, 예약인원 중복 안되게
    public Reserve insertReservation(Reserve reserve){

        int count = reserveRepository.count(reserve);//예약인워

        boolean isDuplciate = reserveRepository.isDuplicate(reserve.getUserId());//중복조회


        if(count > 30){
            throw new IllegalStateException("예약 인원이 초과되었습니다. 최대 30명까지 예약 가능합니다.");
        }

        if(isDuplciate){
            throw new IllegalStateException("이미 예약을 했습니다.");
        }

        return reserveRepository.save(reserve);
    }

    //예약수정
    public Reserve modifyReservation(Reserve reserve){

        return reserveRepository.update(reserve);
    }

    //예약취소
    public int deleteReservation(Reserve reserve){

        return reserveRepository.delete(reserve);
    }

}
