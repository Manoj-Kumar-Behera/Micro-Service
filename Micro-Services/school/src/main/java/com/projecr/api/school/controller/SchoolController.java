package com.projecr.api.school.controller;

import com.projecr.api.school.model.FullSchoolResponse;
import com.projecr.api.school.service.SchoolService;
import com.projecr.api.school.model.School;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> getAllSchools(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(schoolService.findSchoolswithStudents(schoolId));
    }

}
