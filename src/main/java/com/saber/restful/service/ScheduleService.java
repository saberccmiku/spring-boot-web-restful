package com.saber.restful.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/28
 */
@Service
public class ScheduleService {

    //@Scheduled(cron = "* * * * * 1-6")
    public void hello(){
        System.out.println("hello world");
    }
}
