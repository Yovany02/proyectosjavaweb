package com.uncledavecode.datajpa2.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CourseDTO {

    Long getId();
    String getName();

    @Value("#{target.instructor.getFirstName()}")
    String getInstructorName();
    @Value("#{target.studentCourses.size()}")
    int getStudentCount();

}
