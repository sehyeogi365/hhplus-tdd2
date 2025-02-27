package hhdplus.hhplus_tdd2.infra.lecture;

import hhdplus.hhplus_tdd2.domain.lecture.Lecture;
import hhdplus.hhplus_tdd2.interfaces.controller.LectureRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.LectureResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    LectureRequest save(LectureResponse lectureResponse);//강의 생성
    List<Lecture> findAll();//강의 전체 조회

}
