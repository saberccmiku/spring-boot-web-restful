package com.saber.restful.service;

import com.saber.restful.entities.Department;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/26
 */
@Service
public class DepartmentService {

    @RabbitListener(queues = "saber")
    public void receive(Department department){
        System.out.println("收到信息:"+department);
    }

}
