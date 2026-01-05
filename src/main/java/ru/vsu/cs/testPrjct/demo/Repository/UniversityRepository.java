package ru.vsu.cs.testPrjct.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.testPrjct.demo.Entity.UniversityEntity;
import ru.vsu.cs.testPrjct.demo.Repository.FilterRepository.UniversityFilterRepository;

@Repository
public interface UniversityRepository
        extends JpaRepository<UniversityEntity, Long>,
        UniversityFilterRepository, QuerydslPredicateExecutor<UniversityEntity> {
}
