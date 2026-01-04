package ru.vsu.cs.testPrjct.demo.Mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.testPrjct.demo.Dto.StudentDTO;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;

@Mapper(componentModel = "spring", uses = UniversityMapper.class)

public interface StudentMapper {
    StudentDTO toDto(StudentEntity student);
}
