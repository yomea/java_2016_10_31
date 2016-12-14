package com.application.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.application.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from t_user where username = #{name}")
	User findUserByName(@Param("name")String name);


}
