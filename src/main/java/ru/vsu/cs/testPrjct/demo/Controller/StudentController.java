package ru.vsu.cs.testPrjct.demo.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.testPrjct.demo.Dto.StudentDTO;
import ru.vsu.cs.testPrjct.demo.Entity.StudentEntity;
import ru.vsu.cs.testPrjct.demo.Service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
class StudentController {
    private final StudentService service;
    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAll() {
        log.info("вызван getAll");
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id) {
        log.info("вызван getById");
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping()
    public ResponseEntity<StudentEntity> save(@RequestBody StudentEntity student) {
        log.info("вызван delete");
        return ResponseEntity.ok(service.save(student));
    }

}
