package com.projecr.api.school.service;

import com.projecr.api.school.client.StudentClient;
import com.projecr.api.school.dao.SchoolRepository;
import com.projecr.api.school.model.FullSchoolResponse;
import com.projecr.api.school.model.School;
import com.projecr.api.school.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    public void saveSchool(School school){
        schoolRepository.save(school);
    }

    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolswithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(
                School.builder().schoolName("NOT_FOUND").schoolEmail("NOT_FOUND").build()
        );

        var student = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .schoolName(school.getSchoolName())
                .schoolEmail(school.getSchoolEmail())
                .studentList(student)
                .build();
    }
}
