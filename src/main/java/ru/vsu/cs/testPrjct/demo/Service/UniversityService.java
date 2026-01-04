package ru.vsu.cs.testPrjct.demo.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.testPrjct.demo.Dto.UniversityDTO;
import ru.vsu.cs.testPrjct.demo.Mapper.UniversityMapper;
import ru.vsu.cs.testPrjct.demo.Repository.UniversityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepository repository;
    private final UniversityMapper mapper;

    public List<UniversityDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public UniversityDTO getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }
}
