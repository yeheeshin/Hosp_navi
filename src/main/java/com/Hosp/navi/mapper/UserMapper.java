package com.Hosp.navi.mapper;

import com.Hosp.navi.domain.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(user user);

    user findByEmail(String email);
}
