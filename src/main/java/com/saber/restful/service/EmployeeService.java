package com.saber.restful.service;

import com.saber.restful.entities.Employee;
import com.saber.restful.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/19
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee insertEmp(Employee employee){
        employeeMapper.insert(employee);
        return employee;
    }

    @Cacheable(cacheNames = {"emps"})
    public Employee queryById(Integer id){
        System.out.println("-------------employee-----------------");
        return employeeMapper.queryById(id);
    }

    @CachePut(cacheNames = {"emps"},key = "#result.id")
    public Employee update(Employee employee){
        employeeMapper.update(employee);
        return employee;
    }

    public void delete(Integer id){
        employeeMapper.delete(id);
    }


}
