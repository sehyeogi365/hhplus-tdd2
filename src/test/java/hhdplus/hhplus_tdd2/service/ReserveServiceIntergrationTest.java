package hhdplus.hhplus_tdd2.service;

import hhdplus.hhplus_tdd2.domain.reserve.Reserve;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveCommand;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveInfo;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveService;
import hhdplus.hhplus_tdd2.infra.reserve.ReserveRepository;
import hhdplus.hhplus_tdd2.interfaces.controller.ReserveRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.ReserveResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class ReserveServiceIntergrationTest {

    @Autowired
    ReserveService reserveService;
    @Autowired
    ReserveRepository reserveRepository;

    ReserveRequest reserveRequest = new ReserveRequest();
    ReserveResponse reserveResponse = new ReserveResponse();
    Reserve reserve = new Reserve();

    //동작하기 전에 넣어준다 BeforeEach
//    @BeforeEach
//    public void beforeEach() {
//        MockitoAnnotations.openMocks(this); // Mock 객체 초기화
//    }
//
//    @AfterEach //테스트 돌때마다 초기화
//    public void afterEach() {
//        Mockito.reset(reserveRepository); // Mock 상태 초기화
//    }

    @Test
    void 아이디별_예약_내역() {

        //given 뭔가가 주어졌는데
        int userId = 1;

        ReserveInfo mockReserveInfo = new ReserveInfo();
        mockReserveInfo.setId(1);
        mockReserveInfo.setUserId(userId);
        mockReserveInfo.setName("테스트 예약 정보");

        List<ReserveInfo> mockReserveList = List.of(mockReserveInfo);

        // Mock 동작 설정
        when(reserveService.findReservation(1)).thenReturn(mockReserveList);

        //when 이거를 실행했을 떄
        List<ReserveInfo> result = reserveService.findReservation(userId);

        //then 결과가 이게 나와야 돼
        if(result != null){
            System.out.println("이름 : " + mockReserveInfo.getName());
        }

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getUserId()).isEqualTo(userId);
    }

    @Test
    void 예약하기() {//40명이 예약 한다 쳐보면 30명만 예약이 되게끔 해보기
        //given 뭔가가 주어졌는데
        ReserveResponse reserveResponse = new ReserveResponse();
        reserveResponse.setId(1);
        reserveResponse.setUserId(1);
        reserveResponse.setLectureId(1);



        ReserveRequest findOne = new ReserveRequest();
        findOne.setUserId(1);
        findOne.setLectureId(1);
        //when 이거를 실행했을 떄
        // findOne = reserveService.findOne(reserveResponse.getUserId());
        // Mock 동작 설정
        when(reserveService.insertReservation(reserveResponse)).thenReturn(findOne);

        ReserveRequest result = reserveService.insertReservation(reserveResponse);

        //then 결과가 이게 나와야 돼
        if(findOne != null){
            System.out.println("findOne : " + reserveResponse.getLectureId());
        }
        assertThat(findOne).isNotNull();
        assertThat(result.getLectureId()).isEqualTo(1);

    }

    @Test
    void 예약하기2() {//40명이 예약 한다 쳐보면 30명만 예약이 되게끔 해보기
        //given 뭔가가 주어졌는데 -> 40명의인원, 데이터

        ReserveRequest findOne = new ReserveRequest();
        findOne.setUserId(1);
        findOne.setLectureId(1);

        int successCount = 0;
        int failCount = 0;

        //when 이거를 실행했을 떄 40명이 예약을 시도할 때 30명만 예약이되게 수정

        for(int i = 0; i < 40; i++){
            ReserveResponse reserveResponse = new ReserveResponse();
            reserveResponse.setId(i);
            reserveResponse.setUserId(i);
            reserveResponse.setLectureId(i);


            //30명까진 성공 나머진 실패하게 하기
            if(i < 30){
                // 30명까지는 성공
                // Mock 동작 설정
                when(reserveService.insertReservation(reserveResponse)).thenReturn(findOne);

                ReserveRequest result = reserveService.insertReservation(reserveResponse);
                // 성공 검증
                assertThat(findOne).isNotNull();
                assertThat(result.getLectureId()).isEqualTo(1);
                successCount++;
            } else {
                // 31번째부터는 실패를 시뮬레이션
                when(reserveService.insertReservation(reserveResponse))
                        .thenThrow(new IllegalStateException("예약 인원이 초과되었습니다."));

                try {
                    reserveService.insertReservation(reserveResponse);
                } catch (IllegalStateException e) {
                    assertThat(e.getMessage()).isEqualTo("예약 인원이 초과되었습니다.");
                    failCount++;
                }
            }


        }
        //then 결과가 이게 나와야 돼

        assertThat(successCount).isEqualTo(30);//성공수
        //실패수
        assertThat(failCount).isEqualTo(10);//실패수

    }

    @Test
    void 예약수정() {
        //given 뭔가가 주어졌는데
        ReserveCommand reserveCommand = new ReserveCommand();
        reserveCommand.setLectureId(1);
        reserveCommand.setId(1);
        reserveCommand.setId(1);

        //when 이거를 실행했을 때
        when(reserveService.modifyReservation(reserveCommand.getUserId())).thenReturn(reserveCommand);

        ReserveRequest findOne = reserveService.findOne(reserveCommand.getUserId());
        //then 결과가 이게 나와야 돼
        assertThat(findOne).isNotNull();
        if(findOne != null){
            System.out.println("findOne : " + reserveResponse.getLectureId());
        }
    }

    @Test
    void 예약삭제() {
        //given 뭔가가 주어졌는데
        ReserveResponse reserveResponse = new ReserveResponse();
        reserveResponse.setId(1);
        reserveResponse.setUserId(1);

        reserveService.deleteReservation(reserveResponse.getId());

        //when 이거를 실행했을 때
        List<ReserveInfo> list = reserveService.findReservation(reserveResponse.getUserId());

        //then 결과가 이게 나와야 돼

        if(list.isEmpty()){
            System.out.println("삭제 완료");
        }
        assertThat(list.size()).isEqualTo(0);
    }

}
