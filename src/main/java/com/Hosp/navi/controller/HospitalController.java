package com.Hosp.navi.controller;

import com.Hosp.navi.domain.Hospital;
import com.Hosp.navi.domain.User;
import com.Hosp.navi.service.HospitalService;
import com.Hosp.navi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping("/all_hosName")
    public List<String> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.findAll();

        List<String> hospitalList = new ArrayList<>();

        for (Hospital hospital : hospitals) {
            hospitalList.add(hospital.getHos_name());
        }

        return hospitalList;
    }
}
