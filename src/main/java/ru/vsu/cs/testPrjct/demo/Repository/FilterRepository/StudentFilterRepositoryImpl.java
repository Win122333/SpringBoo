package ru.vsu.cs.testPrjct.demo.Repository.FilterRepository;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.StudentFilter;
import ru.vsu.cs.testPrjct.demo.Dto.QPredicate;
import ru.vsu.cs.testPrjct.demo.Entity.QStudentEntity;
import ru.vsu.cs.testPrjct.demo.Entity.QUniversityEntity;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;

import java.util.List;
@RequiredArgsConstructor
public class StudentFilterRepositoryImpl implements StudentFilterRepository {
    private final EntityManager entityManager;
    @Override
    public List<StudentEntity> findAllByFilter(StudentFilter filter) {

        var predicates = QPredicate.builder()
                .add(filter.city(), QStudentEntity.studentEntity.city::containsIgnoreCase)
                .add(filter.surname(), QStudentEntity.studentEntity.surname::containsIgnoreCase)
                .add(filter.name(), QStudentEntity.studentEntity.name::containsIgnoreCase)
                .add(filter.course(), QStudentEntity.studentEntity.course::loe)
                .add(filter.stipend(), QStudentEntity.studentEntity.stipend::loe)
                .buildAnd();

        return new JPAQuery<StudentEntity>(entityManager)
                .select(QStudentEntity.studentEntity)
                .from(QStudentEntity.studentEntity)
                .where(predicates)
                .leftJoin(QStudentEntity.studentEntity.university, QUniversityEntity.universityEntity).fetchJoin()
                .fetch();
    }
}
