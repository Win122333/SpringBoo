package ru.vsu.cs.testPrjct.demo.Service;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.UniversityFilter;
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
    public List<UniversityDTO> getAllByFilter(UniversityFilter filter) {
        return repository.getAllByFilter(filter).stream()
                .map(mapper::toDto)
                .toList();
    }
    public Page<UniversityDTO> getAllPagesByFilter(Predicate predicates, Pageable pageable) {
        var page = repository.findAll(predicates, pageable);
        return new PageImpl<>(
                page.get().map(mapper::toDto).toList(),
                pageable,
                page.getTotalElements()
        );
    }

    public UniversityDTO getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }
}
