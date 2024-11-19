package com.Hosp.navi.controller;

import com.Hosp.navi.domain.Hospital;
import com.Hosp.navi.domain.enumType.Position;
import com.Hosp.navi.domain.user;
import com.Hosp.navi.domain.enumType.Role;
import com.Hosp.navi.dto.UserDto;
import com.Hosp.navi.service.HospitalService;
import com.Hosp.navi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final HospitalService hospitalService;

    // 회원가입 로직
    @PostMapping("/signUp")
    public ResponseEntity<String> joinUser(@RequestBody UserDto userDto){
        Hospital byName = hospitalService.findByName(userDto.getHospital_name());

        user user1 = convertToUser(userDto);

        user1.setHospital(byName.getHospital_id());
        user1.setRole(Role.USER);

        System.out.println(user1.getEmail());

        boolean isJoin = userService.save(user1);

        if (!isJoin) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 이메일입니다.");
        }
        return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
    }

    // 모든 병원 이름 검색
    @GetMapping("/hos_list")
    public List<Hospital> getAllHospitals() {
        return hospitalService.findAll();
    }

    public user convertToUser(UserDto userDto) {
        user user = new user();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());

        // 포지션 저장
        Position position = Position.changeEnum(userDto.getPosition());
        user.setPosition(position);


        return user;
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String password = requestBody.get("password");

        user user = userService.userLogin(email, password);

        return ResponseEntity.ok("안녕하세요. " + user.getUsername() + "님");
    }
}
