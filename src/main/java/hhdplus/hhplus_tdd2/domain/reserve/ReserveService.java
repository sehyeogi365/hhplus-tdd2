package hhdplus.hhplus_tdd2.domain.reserve;

import hhdplus.hhplus_tdd2.infra.reserve.ReserveRepository;
import hhdplus.hhplus_tdd2.interfaces.controller.ReserveRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.ReserveResponse;
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

    //에약기능 최대 30명까지, 예약인원 중복 안되게
    @Transactional
    public ReserveRequest insertReservation(ReserveResponse reserveResponse){

        int count = reserveRepository.count(reserveResponse.getLectureId());//예약인원

        boolean isDuplciate = reserveRepository.isDuplicate(reserveResponse.getUserId(), reserveResponse.getLectureId());//중복조회

        if(count > 30){
            throw new IllegalStateException("예약 인원이 초과되었습니다. 최대 30명까지 예약 가능합니다.");
        }

        if(isDuplciate){
            throw new IllegalStateException("이미 예약을 했습니다.");
        }

        return reserveRepository.save(reserveResponse);
    }

    //예약내역 조회
    public List<ReserveInfo> findReservation(int userId){
        return reserveRepository.findAll(userId);
    }

    //예약내역 1행 조회
    public ReserveRequest findOne(int userId){
        return reserveRepository.findOne(userId);
    }

    //예약수정
    @Transactional
    public ReserveCommand modifyReservation(int userId){
        return reserveRepository.update(userId);
    }

    //예약취소
    @Transactional
    public void deleteReservation(int id){
        reserveRepository.findById(id).ifPresent(reserve -> reserveRepository.delete(reserve));
    }

}
