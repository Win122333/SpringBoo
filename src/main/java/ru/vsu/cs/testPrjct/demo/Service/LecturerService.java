package ru.vsu.cs.testPrjct.demo.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;
import ru.vsu.cs.testPrjct.demo.Repository.LecturerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LecturerService {
    private final LecturerRepository repository;

    public List<LecturerEntity> getAll() {
        return repository.findAll();
    }

    public Optional<LecturerEntity> getById(Long id) {
        return repository.findById(id);
    }
}
