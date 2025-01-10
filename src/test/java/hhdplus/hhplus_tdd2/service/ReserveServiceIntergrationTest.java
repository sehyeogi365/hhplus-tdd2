package hhdplus.hhplus_tdd2.service;

import hhdplus.hhplus_tdd2.domain.reserve.Reserve;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveCommand;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveInfo;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveService;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveRepository;
import hhdplus.hhplus_tdd2.interfaces.dto.ReserveRequest;
import hhdplus.hhplus_tdd2.interfaces.controller.ReserveResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class ReserveServiceIntergrationTest {

    @Autowired
    ReserveService reserveService;
    @Autowired
    ReserveRepository reserveRepository;

//    ReserveRequest reserveRequest = new ReserveRequest();
//    ReserveResponse reserveResponse = new ReserveResponse();
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

        ReserveInfo reserveInfo = ReserveInfo.builder()
                                            .id(1)
                                            .userId(userId)
                                            .name("테스트 예약 정보")
                                            .build();


        //List<ReserveInfo> reserveList = List.of(reserveInfo);

        reserveService.findReservation(1);

        //when 이거를 실행했을 떄
        List<ReserveInfo> result = reserveService.findReservation(userId);

        //then 결과가 이게 나와야 돼
        if(result != null){
            System.out.println("이름 : " + reserveInfo.getName());
        }

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getUserId()).isEqualTo(userId);
    }
    //성공 실패 케이스로 나눠서 하기, 변수가 아닌 디비 컬럼에 데이터가 30개 모였는지 체크하게 고치기, sysout 없애기
    @Test
    void 예약하기() {//40명이 예약 한다 쳐보면 30명만 예약이 되게끔 해보기
        //given 뭔가가 주어졌는데
        ReserveResponse reserveResponse = ReserveResponse.builder()
                                                        .id(1)
                                                        .userId(1)
                                                        .lectureId(1)
                                                        .build();

        ReserveRequest findOne = ReserveRequest.builder().userId(1).lectureId(1).build();

        //when 이거를 실행했을 떄
        findOne = reserveService.findOne(reserveResponse.getUserId());
        reserveService.insertReservation(reserveResponse);

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

        ReserveRequest findOne = ReserveRequest.builder()
                                                .userId(1)
                                                .lectureId(1)
                                                .build();
        int successCount = 0;
        int failCount = 0;

        //when 이거를 실행했을 떄 40명이 예약을 시도할 때 30명만 예약이되게 수정

        for(int i = 0; i < 40; i++){
            ReserveResponse reserveResponse = ReserveResponse.builder()
                                                                .id(i)
                                                                .userId(i)
                                                                .lectureId(i)
                                                                .build();


            //30명까진 성공 나머진 실패하게 하기
            if(i < 30){
                // 30명까지는 성공

                ReserveRequest result = reserveService.insertReservation(reserveResponse);
                // 성공 검증
                assertThat(findOne).isNotNull();
                assertThat(result.getLectureId()).isEqualTo(1);
                successCount++;
            } else {
                // 31번째부터는 실패를 시뮬레이션
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
        ReserveCommand reserveCommand = ReserveCommand.builder()
                                                        .lectureId(1)
                                                        .userId(1)
                                                        .build();


        //when 이거를 실행했을 때
        reserveService.modifyReservation(reserveCommand.getUserId());

        ReserveRequest findOne = reserveService.findOne(reserveCommand.getUserId());
        //then 결과가 이게 나와야 돼
        assertThat(findOne).isNotNull();
        if(findOne != null){
            System.out.println("findOne : " + findOne.getLectureId());
        }
    }

    @Test
    void 예약삭제() {
        //given 뭔가가 주어졌는데
        ReserveResponse reserveResponse = ReserveResponse.builder()
                                                            .id(1)
                                                            .userId(1)
                                                            .build();

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
