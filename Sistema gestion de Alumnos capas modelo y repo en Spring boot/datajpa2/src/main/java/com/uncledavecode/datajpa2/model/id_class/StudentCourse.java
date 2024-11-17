//package com.uncledavecode.datajpa2.model.id_class;
//
//import com.uncledavecode.datajpa2.model.Course;
//import com.uncledavecode.datajpa2.model.Student;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@IdClass(StudentCourseKey.class)
//public class StudentCourse {
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Student student;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Course course;
//
//    @Column(name = "rating")
//    private int rating;
//
//    @Override
//    public String toString() {
//        return "StudentCourse{" +
//                "student=" + student +
//                ", course=" + course +
//                ", rating=" + rating +
//                '}';
//    }
//
//}
