package hhdplus.hhplus_tdd2.domain.lecture;

import hhdplus.hhplus_tdd2.interfaces.controller.LectureRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.LectureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureRequest insertLecture(LectureResponse lectureResponse){

        return lectureRepository.save(lectureResponse);
    }
    public List<Lecture> lectureList(){

        return lectureRepository.findAll();
    }


}
