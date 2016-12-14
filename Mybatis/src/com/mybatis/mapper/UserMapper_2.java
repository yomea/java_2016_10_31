package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.bean.User;

public interface UserMapper_2 {
	@Select(value="select * from t_user")
	List<User> getAll();
	@Select("select * from t_user where id=#{_parmeter}}")
	User get(int id);
	@Update(value="update t_user set password=#{password} where id=#{id}")
	int update(User user);
	@Insert("insert into t_user values(null, #{username}, #{password}, #{birthday})")
	int insert(User user);
	
}
