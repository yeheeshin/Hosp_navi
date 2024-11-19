package com.Hosp.navi.service;

import com.Hosp.navi.domain.user;
import com.Hosp.navi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    // 이메일 중복 체크
     public boolean isEmailDuplicate(String email) {
         user byEmail = userMapper.findByEmail(email);

         return byEmail != null; // 이메일 존재 : true, 없으면 : false
     }

     // 유저 저장
    public boolean save(user user) {
        if (!isEmailDuplicate(user.getEmail())) {
            userMapper.saveUser(user);
            return true;
        } else {
            System.out.println("이미 존재하는 이메일입니다.");
            return false;
        }

    }

    // login
    public user userLogin(String email, String password) {
        user loginUser = userMapper.findByEmailAndPwd(email, password);

        if (loginUser != null) {
            return loginUser;
        } else {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }

    }

}