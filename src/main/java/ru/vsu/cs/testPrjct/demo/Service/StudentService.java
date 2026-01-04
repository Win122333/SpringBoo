package ru.vsu.cs.testPrjct.demo.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vsu.cs.testPrjct.demo.Dto.StudentDTO;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;
import ru.vsu.cs.testPrjct.demo.Entity.UniversityEntity;
import ru.vsu.cs.testPrjct.demo.Mapper.StudentMapper;
import ru.vsu.cs.testPrjct.demo.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;
    public List<StudentDTO> getAll() {
        log.info("getAll");
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
    public StudentDTO getById(Long id) {
        log.info("getById");
        return mapper.toDto(repository.findById(id).orElseThrow());
    }
    public StudentEntity save(StudentEntity entity) {
        return repository.save(entity);
    }
}
