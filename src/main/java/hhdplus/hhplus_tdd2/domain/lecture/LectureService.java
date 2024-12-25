package hhdplus.hhplus_tdd2.domain.lecture;

import hhdplus.hhplus_tdd2.infra.lecture.LectureRepository;
import hhdplus.hhplus_tdd2.interfaces.controller.LectureRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.LectureResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LectureService {

    LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public LectureRequest insertLecture(LectureResponse lectureResponse){

        return lectureRepository.save(lectureResponse);
    }
    public List<LectureInfo> lectureList(){

        return lectureRepository.findAll();
    }


}
