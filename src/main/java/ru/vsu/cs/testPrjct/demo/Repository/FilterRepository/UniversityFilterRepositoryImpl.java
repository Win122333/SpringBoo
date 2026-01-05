package ru.vsu.cs.testPrjct.demo.Repository.FilterRepository;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.UniversityFilter;
import ru.vsu.cs.testPrjct.demo.Dto.QPredicate;
import ru.vsu.cs.testPrjct.demo.Entity.QUniversityEntity;
import ru.vsu.cs.testPrjct.demo.Entity.UniversityEntity;

import java.util.List;
@RequiredArgsConstructor
public class UniversityFilterRepositoryImpl implements UniversityFilterRepository {
    private final EntityManager entityManager;
    @Override
    public List<UniversityEntity> getAllByFilter(UniversityFilter filter) {
        var predicates = QPredicate.builder()
                .add(filter.city(), QUniversityEntity.universityEntity.city::containsIgnoreCase)
                .add(filter.rating(), QUniversityEntity.universityEntity.rating::eq)
                .buildAnd();

        return new JPAQuery<UniversityEntity> (entityManager)
                .select(QUniversityEntity.universityEntity)
                .from(QUniversityEntity.universityEntity)
                .where(predicates)
                .fetch();
    }
}
