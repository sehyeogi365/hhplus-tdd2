package hhdplus.hhplus_tdd2.repository;

import hhdplus.hhplus_tdd2.domain.Reserve;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReserveRepositoryTest {

    ReserveRepository repository;

    public ReserveRepositoryTest(ReserveRepository repository) {
        this.repository = repository;
    }

    @Test
    void findAll() {

        //given 뭔가가 주어졌는데
        Reserve reserve = new Reserve();
        reserve.setUserId(1);

        //when 이거를 실행했을 떄
        List<Reserve> result = repository.findAll(reserve.getUserId());

        //then 결과가 이게 나와야 돼
        assertThat(result).isEqualTo(reserve);
    }

    @Test
    void save() {
        //given 뭔가가 주어졌는데
        Reserve reserve = new Reserve();
        reserve.setUserId(1);

        //when 이거를 실행했을 떄
        repository.save(reserve);

        //then 결과가 이게 나와야 돼
        List<Reserve> result = repository.findAll(reserve.getUserId());

        assertThat(result).isEqualTo(reserve);
    }

    @Test
    void update() {
        //given 뭔가가 주어졌는데
        Reserve reserve = new Reserve();
        reserve.setUserId(2);

        //when 이거를 실행했을 떄
        repository.update(reserve);

        //then 결과가 이게 나와야 돼
        List<Reserve> result = repository.findAll(reserve.getUserId());

        assertThat(result).isEqualTo(reserve);
    }

    @Test
    void delete() {
        //given 뭔가가 주어졌는데
        Reserve reserve = new Reserve();
        reserve.setId(1);
        reserve.setUserId(1);

        //when 이거를 실행했을 떄
        repository.delete(reserve);

        //then 결과가 이게 나와야 돼
        List<Reserve> result = repository.findAll(reserve.getUserId());

        if(result == null){
            System.out.println("삭제 성공");
        }

    }
}