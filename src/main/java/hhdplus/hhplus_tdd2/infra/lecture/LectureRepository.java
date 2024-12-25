package hhdplus.hhplus_tdd2.infra.lecture;

import hhdplus.hhplus_tdd2.domain.lecture.Lecture;
import hhdplus.hhplus_tdd2.domain.lecture.LectureInfo;
import hhdplus.hhplus_tdd2.interfaces.controller.LectureRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.LectureResponse;

import java.util.List;

public interface LectureRepository {

    LectureRequest save(LectureResponse lectureResponse);//강의 생성
    List<LectureInfo> findAll();//강의 전체 조회

}
