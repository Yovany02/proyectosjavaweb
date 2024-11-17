package com.uncledavecode.datajpa2.repository;

import com.uncledavecode.datajpa2.dto.CourseDTO;
import com.uncledavecode.datajpa2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<CourseDTO> findByInstructor_Id(Long id);


}
