package ru.vsu.cs.testPrjct.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;

import java.util.List;

@Repository
public interface StudentRepository
        extends JpaRepository<StudentEntity, Long>, StudentFilterRepository {
}
