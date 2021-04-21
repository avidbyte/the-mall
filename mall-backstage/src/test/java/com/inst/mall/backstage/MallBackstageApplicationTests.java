package com.inst.mall.backstage;

import com.inst.mall.backstage.service.IncrementSequenceService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MallBackstageApplicationTests {

    @Resource
    IncrementSequenceService incrementSequenceService;

    @Test
    void contextLoads() {
        Long id = incrementSequenceService.getSequence();
        System.out.println(id);
    }

}
