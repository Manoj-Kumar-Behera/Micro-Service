package com.projecr.api.school.dao;

import com.projecr.api.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
