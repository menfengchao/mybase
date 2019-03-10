package com.men.mybase.util.jdk;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.DelayQueue;

/**
 * 定时执行队列
 */
@Component
public class MyNotice {

    @PostConstruct
    public void  init(){
        System.out.println("I'm  init  method  using  @PostConstrut....");
    }

    @PreDestroy
    public void  dostory(){
        System.out.println("I'm  destory method  using  @PreDestroy.....");
    }



}
