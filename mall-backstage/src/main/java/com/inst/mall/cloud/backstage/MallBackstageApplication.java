package com.inst.mall.cloud.backstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author aaron
 */
@SpringBootApplication(scanBasePackages = {"com.inst.mall.cloud.backstage","com.inst.cloud.mall.security","com.inst.cloud.mall.common"})
public class MallBackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallBackstageApplication.class, args);
    }

}
