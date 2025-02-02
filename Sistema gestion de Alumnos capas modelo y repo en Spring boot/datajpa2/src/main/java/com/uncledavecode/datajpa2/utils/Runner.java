package com.uncledavecode.datajpa2.utils;

import com.uncledavecode.datajpa2.model.Student;
import com.uncledavecode.datajpa2.repository.CourseRepository;
import com.uncledavecode.datajpa2.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Runner(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        //Save and SaveAll
//        Student student1 = new Student(
//                "Jhon", "Doe", LocalDate.of(
//                        1980, 1, 1));
//
//        Student student2 = new Student(
//                "Jane", "Doe", LocalDate.of(
//                1990, 1, 1));
//
//        studentRepository.saveAll(Set.of(student1, student2));

        //Using @Query
//        studentRepository.findByFirstName("Leora").forEach(System.out::println);
//        studentRepository.findByFirstNameLike("ri").forEach(System.out::println);
//        studentRepository.findByFirstNameNative("Dari").forEach(System.out::println);

//        studentRepository.findByFirstNameLastNameNamed("Leora", "Tutill").forEach(System.out::println);

        //Update
//        studentRepository.updateFirstNameById(6L, "Jennifer");
//        studentRepository.findAll().forEach(System.out::println);

        //Using Named Methods
//        studentRepository.findByBirthDateGreaterThan(LocalDate.of(1980, 1, 1)).forEach(System.out::println);
//
//        if(studentRepository.existsByFirstName("Leora")){
//            System.out.println("Leora Exists");
//        }
//
//        System.out.println("Count: " + studentRepository.count());
//        System.out.println("Count: " + studentRepository.countByFirstName("Leora"));
//
//        studentRepository.deleteByFirstName("Leora");

        //Multiples Tables
//        studentRepository.findByContactInfo_StateIgnoreCase("michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc("michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateIgnoreCaseOrderByIdDesc("michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateOrContactInfo_StateAllIgnoreCase("michigan", "Ohio").forEach(System.out::println);

        //Sorting
//        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "birthDate"), new Sort.Order(Sort.Direction.ASC, "firstName"));
//        studentRepository.findAll(sort).forEach(System.out::println);

        //Pagination
//        System.out.println("Page 1");
//        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "birthDate"));
//        studentRepository.findAll(pageable).forEach(System.out::println);
//
//        System.out.println("Page 2");
//        pageable = PageRequest.of(1, 6, Sort.by(Sort.Direction.DESC, "birthDate"));
//        studentRepository.findAll(pageable).forEach(System.out::println);
//
//        pageable = Pageable.unpaged();

        var result = courseRepository.findByInstructor_Id(2L);

        for (var course : result){
            System.out.println(course.getName() + " -> Instructor: " + course.getInstructorName() + " -> Students: " + course.getStudentCount());
        }
    }
}
