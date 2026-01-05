package ru.vsu.cs.testPrjct.demo.Service;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.LecturerFilter;
import ru.vsu.cs.testPrjct.demo.Dto.LecturerDTO;
import ru.vsu.cs.testPrjct.demo.Dto.UniversityDTO;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;
import ru.vsu.cs.testPrjct.demo.Mapper.LecturerMapper;
import ru.vsu.cs.testPrjct.demo.Repository.LecturerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LecturerService {
    private final LecturerRepository repository;
    private final LecturerMapper mapper;

    public List<LecturerEntity> getAll() {
        return repository.getAllWithUniversity();
    }
    public List<LecturerDTO> getAllByFilter(LecturerFilter filter) {
        return repository.getAllByFilter(filter).stream()
                .map(mapper::toDto)
                .toList();
    }
    public Page<LecturerDTO> getAllPagesByFilter(Predicate predicates, Pageable pageable) {
        var page = repository.findAll(predicates, pageable);
        return new PageImpl<>(
                page.get().map(mapper::toDto).toList(),
                pageable,
                page.getTotalElements()
        );
    }

    public Optional<LecturerEntity> getById(Long id) {
        return repository.findById(id);
    }
}
