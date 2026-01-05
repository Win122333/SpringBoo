package ru.vsu.cs.testPrjct.demo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.LecturerFilter;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.StudentFilter;
import ru.vsu.cs.testPrjct.demo.Dto.Filter.UniversityFilter;
import ru.vsu.cs.testPrjct.demo.Dto.QPredicate;
import ru.vsu.cs.testPrjct.demo.Dto.StudentDTO;
import ru.vsu.cs.testPrjct.demo.Dto.UniversityDTO;
import ru.vsu.cs.testPrjct.demo.Entity.*;
import ru.vsu.cs.testPrjct.demo.Service.LecturerService;
import ru.vsu.cs.testPrjct.demo.Service.StudentService;
import ru.vsu.cs.testPrjct.demo.Service.UniversityService;


@Controller
@RequiredArgsConstructor
public class ViewController {
    private final StudentService studentService;
    private final LecturerService lectService;
    private final UniversityService universityService;
    @GetMapping("/student")
    public String getStudentView(
            Model model,
            @ModelAttribute StudentFilter filter,
            Pageable pageable
    ) {
        var predicates = QPredicate.builder()
                .add(filter.city(), QStudentEntity.studentEntity.city::containsIgnoreCase)
                .add(filter.surname(), QStudentEntity.studentEntity.surname::containsIgnoreCase)
                .add(filter.name(), QStudentEntity.studentEntity.name::containsIgnoreCase)
                .add(filter.course(), QStudentEntity.studentEntity.course::loe)
                .add(filter.stipend(), QStudentEntity.studentEntity.stipend::loe)
                .buildAnd();
        Page<StudentDTO> page = studentService.getAllPagesByFilter(predicates, pageable);

        model.addAttribute("students", PageResponse.of(page));
        model.addAttribute("filter", filter);
        model.addAttribute("title", "студенты");
        model.addAttribute("message", "список студентов");
        return "students";
    }

    @GetMapping("/university")
    public String getUniversityView(
            Model model,
            @ModelAttribute UniversityFilter filter,
            Pageable pageable
    ) {
        var predicate = QPredicate.builder()
                .add(filter.city(), QUniversityEntity.universityEntity.city::containsIgnoreCase)
                .add(filter.rating(), QUniversityEntity.universityEntity.rating::eq)
                .buildAnd();

        Page<UniversityDTO> list = universityService.getAllPagesByFilter(predicate, pageable);
        model.addAttribute("university", PageResponse.of(list));
        model.addAttribute("filter", filter);
        model.addAttribute("title", "университеты");
        model.addAttribute("message", "список университетов");
        return "univs";
    }

    @GetMapping("/lectures")
    public String getLecturerView(
            Model model,
            @ModelAttribute LecturerFilter filter,
            Pageable pageable
            ) {
        var predicate = QPredicate.builder()
                .add(filter.city(), QLecturerEntity.lecturerEntity.city::containsIgnoreCase)
                .buildAnd();
        var list = lectService.getAllPagesByFilter(predicate, pageable);
        model.addAttribute("lectures", PageResponse.of(list));
        model.addAttribute("filter", filter);
        model.addAttribute("title", "лекторы");
        model.addAttribute("message", "список преподавателей");
        return "lects";
    }

    @GetMapping("/")
    public String getMainView(Model model) {
        model.addAttribute("message", "Главная страница");
        return "main";
    }
}
