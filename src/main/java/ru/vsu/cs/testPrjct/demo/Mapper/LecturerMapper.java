package ru.vsu.cs.testPrjct.demo.Mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.testPrjct.demo.Dto.LecturerDTO;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;

@Mapper(componentModel = "spring", uses = UniversityMapper.class)
public interface LecturerMapper {
    LecturerDTO toDto (LecturerEntity entity);
}
