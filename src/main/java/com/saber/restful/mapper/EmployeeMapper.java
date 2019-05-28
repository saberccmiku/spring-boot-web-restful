package com.saber.restful.mapper;

import com.saber.restful.entities.Employee;

/**
 * Created by Administrator on 2019/5/8
 */

public interface EmployeeMapper {

     int insert(Employee employee);

     Employee queryById(Integer id);

     void update(Employee employee);

     void delete(Integer id);
}
