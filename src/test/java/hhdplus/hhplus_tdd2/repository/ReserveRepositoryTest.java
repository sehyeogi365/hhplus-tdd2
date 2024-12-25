package hhdplus.hhplus_tdd2.repository;

import hhdplus.hhplus_tdd2.domain.reserve.Reserve;
import hhdplus.hhplus_tdd2.domain.reserve.ReserveInfo;
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


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class ReserveRepositoryTest {

//    @Autowired
//    ReserveRepository repository = mock(ReserveRepository.class);

    @Mock
    ReserveRepository repository = mock(ReserveRepository.class);
    private Reserve reserve;
    private ReserveRequest reserveRequest1;
    private ReserveRequest reserveRequest2;

    @Autowired
    public ReserveRepositoryTest(Reserve reserve, ReserveRequest reserveRequest1, ReserveRequest reserveRequest2) {
        this.reserve = reserve;
        this.reserveRequest1 = reserveRequest1;
        this.reserveRequest2 = reserveRequest2;
    }

    @BeforeEach
    void setup() {
        reserveRequest1 = new ReserveRequest();
        reserveRequest1.setId(1);
        reserveRequest1.setUserId(1);

        reserveRequest2 = new ReserveRequest();
        reserveRequest2.setId(2);
        reserveRequest2.setUserId(2);
    }

    @AfterEach
    void cleanUp(){
        repository.deleteAll();
    }

    @Test
    public void findAll() {

        //given 뭔가가 주어졌는데
        ReserveInfo reserveInfo = new ReserveInfo();
        reserveInfo.setId(1);
        reserveInfo.setUserId(1);

        //when 이거를 실행했을 떄
        List<ReserveInfo> list = repository.findAll(reserveInfo.getUserId());

        when(repository.findAll(reserveInfo.getUserId())).thenReturn(list);

        System.out.println("list.size()" + list.size());
        //then 결과가 이게 나와야 돼
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void save() {
        //given 뭔가가 주어졌는데
        ReserveResponse reserveResponse = new ReserveResponse();
        reserveResponse.setUserId(1);
        reserveResponse.setId(1);

        ReserveRequest reserveRequest = repository.findOne(reserveResponse.getUserId());

        //when 이거를 실행했을 떄
        Mockito.when(repository.save(reserveResponse)).thenReturn(reserveRequest);
        ReserveRequest result = repository.save(reserveResponse);
        //repository.save(reserveResponse);
        //ReserveResponse result = repository.findOne(reserveResponse.getUserId());

        //then 결과가 이게 나와야 돼
        assertThat(result.getUserId()).isEqualTo(1);
    }

    @Test
    public void update() {
        //given 뭔가가 주어졌는데
        ReserveResponse reserveResponse = new ReserveResponse();
        reserveResponse.setUserId(2);

        repository.save(reserveResponse); // 데이터를 저장

        //when 이거를 실행했을 떄
        repository.update(reserveResponse.getUserId());
        ReserveRequest result = repository.findOne(reserveResponse.getUserId());
        //then 결과가 이게 나와야 돼

        assertThat(result).isEqualTo(reserveResponse);
    }

    @Test
    public void delete() {
        //given 뭔가가 주어졌는데
        Reserve reserve = new Reserve();
        reserve.setId(1);
        reserve.setUserId(1);

        //when 이거를 실행했을 떄
        repository.delete(reserve);

        //then 결과가 이게 나와야 돼
        List<ReserveInfo> result = repository.findAll(reserve.getUserId());

        if(result == null){
            System.out.println("삭제 성공");
        }

    }
}