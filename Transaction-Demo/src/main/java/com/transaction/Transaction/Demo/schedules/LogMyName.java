package com.transaction.Transaction.Demo.schedules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogMyName {

//    @Scheduled(fixedRate = 5000)
//    public void sayHello(){
//        log.info("First");
//        try{
//            Thread.sleep(2000);
//        }catch (InterruptedException e){
//            log.error(e.getMessage());
//        }
//        log.info("Task one completed");
//    }
//
//    @Scheduled(fixedRate = 5000)
//    public void sayHelloTwo(){
//        log.info("Second");
//        try{
//            Thread.sleep(3000);
//        }catch (InterruptedException e){
//            log.error(e.getMessage());
//        }
//        log.info("Task Two completed");
//    }

}
