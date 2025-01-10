package hhdplus.hhplus_tdd2.interfaces.controller;

import hhdplus.hhplus_tdd2.domain.lecture.Lecture;
import hhdplus.hhplus_tdd2.domain.lecture.LectureService;
import hhdplus.hhplus_tdd2.interfaces.dto.LectureRequest;
import hhdplus.hhplus_tdd2.interfaces.dto.LectureResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController("/lecture")
public class LectureController {


    private LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    //강의 생성
    @PostMapping("/insert")
    public LectureRequest insertLecture(LectureResponse lectureResponse){
        return lectureService.insertLecture(lectureResponse);
    }

    //강의 조회
    @GetMapping("/select")
    public List<Lecture> lectureList(){

        List<Lecture> list = lectureService.lectureList();

        return list;
    }

}
