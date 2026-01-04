package ru.vsu.cs.testPrjct.demo.Repository;

import ru.vsu.cs.testPrjct.demo.Dto.Filter.StudentFilter;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;

import java.util.List;
import java.util.logging.Filter;

public interface StudentFilterRepository {
    List<StudentEntity> findAllByFilter(StudentFilter filter);
}
