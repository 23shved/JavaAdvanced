package ua.lviv.shved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.shved.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
