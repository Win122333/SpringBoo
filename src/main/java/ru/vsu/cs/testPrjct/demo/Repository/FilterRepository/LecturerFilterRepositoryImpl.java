package ru.vsu.cs.testPrjct.demo.Repository.FilterRepository;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.LecturerFilter;
import ru.vsu.cs.testPrjct.demo.Dto.QPredicate;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;
import ru.vsu.cs.testPrjct.demo.Entity.QLecturerEntity;
import ru.vsu.cs.testPrjct.demo.Entity.QStudentEntity;
import ru.vsu.cs.testPrjct.demo.Entity.QUniversityEntity;

import java.util.List;
@RequiredArgsConstructor
public class LecturerFilterRepositoryImpl implements LecturerFilterRepository {
    private final EntityManager entityManager;
    @Override
    public List<LecturerEntity> getAllByFilter(LecturerFilter filter) {
        var predicates = QPredicate.builder()
                .add(filter.city(), QLecturerEntity.lecturerEntity.city::containsIgnoreCase)
                .buildAnd();

        return new JPAQuery<LecturerEntity>(entityManager)
                .select(QLecturerEntity.lecturerEntity)
                .from(QLecturerEntity.lecturerEntity)
                .where(predicates)
                .leftJoin(QLecturerEntity.lecturerEntity.university, QUniversityEntity.universityEntity).fetchJoin()
                .fetch();
    }
}
