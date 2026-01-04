package ru.vsu.cs.testPrjct.demo.Mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.testPrjct.demo.Dto.UniversityDTO;
import ru.vsu.cs.testPrjct.demo.Entity.UniversityEntity;

@Mapper(componentModel = "spring")
public interface UniversityMapper {
    UniversityDTO toDto(UniversityEntity entity);
    UniversityEntity toEntity(UniversityDTO dto);
}
