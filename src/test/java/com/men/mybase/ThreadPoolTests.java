package com.men.mybase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPoolTests
 * @Description 线程池测试
 * @Author SuperMen
 * Date 2019/8/26 11:26
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolTests {

    @Test
    public void contextLoads() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i= 0; i<5 ;i++){
            executorService.submit(()->{
                System.out.println("当前线程名字"+ Thread.currentThread().getName());
            });

        }
    }
}
