package com.uncledavecode.datajpa2.repository;

import com.uncledavecode.datajpa2.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //JPQL Query
    @Query("SELECT s FROM Student s WHERE s.firstName= ?1")
    List<Student> findByFirstName(String firstName);

    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1%")
    List<Student> findByFirstNameLike(String firstName);

    //Native SQL Query
    @Query(value = "SELECT * FROM student WHERE first_name = ?1", nativeQuery = true)
    List<Student> findByFirstNameNative(String firstName);

    //JPAQ Named Parameters
    @Query("SELECT s FROM Student s WHERE s.firstName= :firstName and s.lastName = :lastName")
    List<Student> findByFirstNameLastNameNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Modifying
    @Query("UPDATE Student s SET s.firstName = :firstName WHERE s.id = :id")
    void updateFirstNameById(@Param("id") Long id, @Param("firstName") String firstName);

    //Named Name Methods
    // Localiza rows por rango de edad
    List<Student> findByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> readByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> getByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> queryByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> searchByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> streamByBirthDateGreaterThan(LocalDate birthdate);

    // Localizar row en la BD
    boolean existsByFirstName(String firstName);

    // Contar registros
    int countByFirstName(String firstName);

    // Eliminar registros
    void deleteByFirstName(String firstName);
    void removeByFirstName(String firstName);

    //Multiples Tables
    List<Student> findByContactInfo_StateIgnoreCase(String state);
    // Ordenar por nombre ascendente y apellido descendente a la misma vez
    List<Student> findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc(String state);

    List<Student> findByContactInfo_StateIgnoreCaseOrderByIdDesc(String state);

    List<Student> findByContactInfo_StateOrContactInfo_StateAllIgnoreCase(String state, String state2);

    // Native Query paging
    @Query(value = "SELECT * FROM student WHERE first_name = ?1",
            countQuery = "SELECT COUNT(*) FROM student WHERE first_name = ?1", nativeQuery = true)
    Page<Student> findByFirstNameNativePaging(String firstName, Pageable pageable);

}
