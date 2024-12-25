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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReserveServiceIntergrationTest {

    @InjectMocks
    ReserveService reserveService;
    @Mock
    ReserveRepository reserveRepository = mock(ReserveRepository.class);

    ReserveRequest reserveRequest = new ReserveRequest();
    ReserveResponse reserveResponse = new ReserveResponse();
    Reserve reserve = new Reserve();

    //동작하기 전에 넣어준다 BeforeEach
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this); // Mock 객체 초기화
    }

    @AfterEach //테스트 돌때마다 초기화
    public void afterEach() {
        Mockito.reset(reserveRepository); // Mock 상태 초기화
    }

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
        assertThat(result.get(0).getUserId()).isEqualTo(userId);
    }

    @Test
    void 예약하기() {
        //given 뭔가가 주어졌는데
        ReserveResponse reserveResponse = new ReserveResponse();
        reserveResponse.setId(1);
        reserveResponse.setUserId(1);
        reserveResponse.setLectureId(1);

        //when 이거를 실행했을 떄
        ReserveRequest findOne = reserveService.findOne(reserveResponse.getUserId());
        // Mock 동작 설정
        Mockito.when(reserveService.insertReservation(reserveResponse)).thenReturn(findOne);

        //then 결과가 이게 나와야 돼
        if(findOne != null){
            System.out.println("findOne : " + reserveResponse.getLectureId());
        }
        assertThat(reserveResponse.getLectureId()).isEqualTo(1);

    }

    @Test
    void 예약수정() {
        //given 뭔가가 주어졌는데
        ReserveCommand reserveCommand = new ReserveCommand();
        reserveCommand.setLectureId(1);
        reserveCommand.setId(1);
        reserveCommand.setId(1);

        //when 이거를 실행했을 때
        Mockito.when(reserveService.modifyReservation(reserveCommand.getUserId())).thenReturn(reserveCommand);

        ReserveRequest findOne = reserveService.findOne(reserveCommand.getUserId());
        //then 결과가 이게 나와야 돼
        //assertThat(findOne).isNotNull();
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
        ReserveRequest result = reserveService.findOne(reserveResponse.getUserId());
        List<ReserveInfo> list = reserveService.findReservation(reserveResponse.getUserId());

        Mockito.when(reserveService.findOne(reserveResponse.getUserId())).thenReturn(result);
        //then 결과가 이게 나와야 돼

        if(list == null){
            System.out.println("삭제 완료");
        }

    }

}
