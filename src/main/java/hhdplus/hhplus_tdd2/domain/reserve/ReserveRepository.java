package hhdplus.hhplus_tdd2.domain.reserve;

import hhdplus.hhplus_tdd2.interfaces.dto.ReserveRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.ReserveResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    ReserveRequest save(ReserveResponse reserveResponse);//예약
    List<ReserveInfo> findByUserId(int userId);//예약 내역 조회 유저 아아디별
    ReserveRequest findOne(int userId);//하나의 예약 내역 조회
    @Query("SELECT count(*) FROM Reserve r WHERE r.lectureId = :lectureId")
    Integer count(int lectureId);//강의별 예약 인원
    @Query("SELECT count(*) > 0 FROM Reserve r WHERE r.userId = :userId AND r.lectureId = :lectureId")
    boolean isDuplicate(int userId, int lectureId);//중복여부
    ReserveCommand updateReserve(int userId);//수정


    //Integer delete(Reserve reserve);//삭제

}
