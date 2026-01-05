package ru.vsu.cs.testPrjct.demo.Repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;
import ru.vsu.cs.testPrjct.demo.Repository.FilterRepository.StudentFilterRepository;

@Repository
public interface StudentRepository
        extends JpaRepository<StudentEntity, Long>, StudentFilterRepository, QuerydslPredicateExecutor<StudentEntity> {
    @EntityGraph(attributePaths = {"university"})
    Page<StudentEntity> findAll(Predicate predicate, Pageable pageable);
}
