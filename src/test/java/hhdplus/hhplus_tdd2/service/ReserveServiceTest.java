package hhdplus.hhplus_tdd2.service;

import hhdplus.hhplus_tdd2.domain.Reserve;
import hhdplus.hhplus_tdd2.repository.ReserveRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveServiceTest {

    ReserveService reserveService;

    ReserveRepository reserveRepository;

    //동작하기 전에 넣어준다 BeforeEach
    @BeforeEach
    public void beforeEach(){
        reserveRepository = Mockito.mock(ReserveRepository.class);
        reserveService = new ReserveService(reserveRepository);
    }

    @AfterEach //테스트 돌때마다 초기화

    @Test
    void 아이디별_예약_내역() {


    }

    @Test
    void 예약하기() {


    }

    @Test
    void 예약수정() {
    }

    @Test
    void 예약삭제() {

    }
}