package ru.vsu.cs.testPrjct.demo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;
import ru.vsu.cs.testPrjct.demo.Service.LecturerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lecturer")
public class LecturerController {
    private final LecturerService service;
    @GetMapping()
    public ResponseEntity<List<LecturerEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<LecturerEntity>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
