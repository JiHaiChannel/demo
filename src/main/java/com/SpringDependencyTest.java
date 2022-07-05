package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import sun.misc.Launcher;

/**
 * @Author:jihai
 * @Date:2022/6/15
 * @Description:
 */
@SpringBootApplication
public class SpringDependencyTest {

    @Autowired
    private DistributedLock distributedLock;

    @Autowired
    private Lock lock;


    public static void main(String[] args) {
//        System.out.println(System.getenv());

        System.getenv().entrySet().forEach(e -> {
            System.out.println(e);
        });
        System.out.println(System.getProperties());

        System.out.println("Spring app -> " + SpringDependencyTest.class.getClassLoader());

        System.out.println("ResolvableType -> " + ResolvableType.class.getClassLoader());

        System.out.println("BeanFactory -> " + BeanFactory.class.getClassLoader());

        System.out.println("String -> " + String.class.getClassLoader());

        ClassLoader classLoader = Launcher.getLauncher().getClassLoader();
//        SpringApplication.run(SpringDependencyTest.class, args);
    }
}
@Configuration
class Config {

    @Bean
    public Lock lock() {
        return new DistributedLock();
    }

}
interface Lock {}

class DistributedLock implements Lock {}
