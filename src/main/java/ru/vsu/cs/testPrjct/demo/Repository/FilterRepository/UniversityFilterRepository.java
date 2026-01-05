package ru.vsu.cs.testPrjct.demo.Repository.FilterRepository;

import ru.vsu.cs.testPrjct.demo.Dto.Filter.UniversityFilter;
import ru.vsu.cs.testPrjct.demo.Entity.UniversityEntity;

import java.util.List;

public interface UniversityFilterRepository {
    public List<UniversityEntity> getAllByFilter(UniversityFilter filter);
}
