package com.projecr.api.school.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String firstname;
    private String lastname;
    private String email;
}
