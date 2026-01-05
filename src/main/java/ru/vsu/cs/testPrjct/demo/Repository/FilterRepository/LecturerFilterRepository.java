package ru.vsu.cs.testPrjct.demo.Repository.FilterRepository;

import ru.vsu.cs.testPrjct.demo.Dto.Filter.LecturerFilter;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;

import java.util.List;

public interface LecturerFilterRepository {
    public List<LecturerEntity> getAllByFilter(LecturerFilter filter);
}
