package com;

import com.engine.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }


    @Autowired
    private OrderController orderController;

    @Override
    public void run(String... args) throws Exception {
        orderController.doABiz();
        orderController.doBBiz();
    }
}
