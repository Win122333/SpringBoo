package ru.vsu.cs.testPrjct.demo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String getStudentView(Model model) {
        var list = studentService.getAll();
        model.addAttribute("students", list);
        model.addAttribute("title", "студенты");
        model.addAttribute("message", "список студентов");
        return "students";
    }

    @GetMapping("/university")
    public String getUniversityView(Model model) {
        var list = universityService.getAll();
        model.addAttribute("univs", list);
        model.addAttribute("title", "университеты");
        model.addAttribute("message", "список университетов");
        return "univs";
    }

    @GetMapping("/lectures")
    public String getLecturerView(Model model) {
        var list = lectService.getAll();
        model.addAttribute("lectures", list);
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
