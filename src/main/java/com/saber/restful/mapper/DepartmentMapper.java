package com.saber.restful.mapper;

import com.saber.restful.entities.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2019/5/7
 */
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department queryById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insert(Department department);

}
