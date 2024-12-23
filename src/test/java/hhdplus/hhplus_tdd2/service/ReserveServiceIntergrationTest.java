package hhdplus.hhplus_tdd2.service;

import hhdplus.hhplus_tdd2.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ReserveServiceIntergrationTest {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private ReserveRepository reserveRepository;




}
