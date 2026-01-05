package ru.vsu.cs.testPrjct.demo.Repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;
import ru.vsu.cs.testPrjct.demo.Repository.FilterRepository.LecturerFilterRepository;

import java.util.List;

@Repository
public interface LecturerRepository
        extends JpaRepository<LecturerEntity, Long>, LecturerFilterRepository,
        QuerydslPredicateExecutor<LecturerEntity> {
    @Query("SELECT l FROM LecturerEntity l JOIN FETCH l.university")
    public List<LecturerEntity> getAllWithUniversity();
    @EntityGraph(attributePaths = {"university"})
    Page<LecturerEntity> findAll(Predicate predicate, Pageable pageable);
}
