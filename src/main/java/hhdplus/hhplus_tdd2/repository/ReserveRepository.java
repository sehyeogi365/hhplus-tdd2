package hhdplus.hhplus_tdd2.repository;

import hhdplus.hhplus_tdd2.domain.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReserveRepository extends JpaRepository {

    List<Reserve> findAll(int userId);//조회 아아디별

    Reserve save(Reserve reserve);//예약

    Integer count(Reserve reserve);//예약 인원
    boolean isDuplicate(int userId);//중복여부

    Reserve update(Reserve reserve);//수정

    int delete(Reserve reserve);//삭제

}
