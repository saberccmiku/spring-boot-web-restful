package com.saber.restful.controller;

import com.saber.restful.entities.Department;
import com.saber.restful.entities.Employee;
import com.saber.restful.mapper.DepartmentMapper;
import com.saber.restful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/21
 */
@RestController
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeService employeeService;

    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT  * from department");
        Map<String,Object> emps = new HashMap<>();
        emps.put("emps",maps);
        return emps;
    }

    @GetMapping("/depart/{id}")
    public Department queryById(@PathVariable("id") Integer id){
        return departmentMapper.queryById(id);
    }

    @GetMapping("/depart")
    public Department insert(Department department){
         departmentMapper.insert(department);
         return department;
    }

    @GetMapping("/employee")
    public Employee insertEmp(Employee employee){
        employeeService.insertEmp(employee);
        return employee;
    }

    @GetMapping("/employee/{id}")
    public Employee queryEmpById(@PathVariable("id") Integer id){
        return employeeService.queryById(id);
    }

    @GetMapping("/employee/updateEmp")
    public Employee updateEmp(Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/employee/deleteEmp")
    public String deleteEmp(Integer id){
        employeeService.delete(id);
        return "success";
    }


}
