package com.projecr.api.school.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {

    private String schoolName;
    private String schoolEmail;

    private List<Student> studentList;
}
