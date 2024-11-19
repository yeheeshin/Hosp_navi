package com.Hosp.navi.mapper;

import com.Hosp.navi.domain.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void saveUser(user user);

    user findByEmail(String email);

    user findByEmailAndPwd(@Param("email") String email, @Param("password") String password);
}
