package ru.vsu.cs.testPrjct.demo.Dto;

import lombok.*;
import ru.vsu.cs.testPrjct.demo.Entity.UniversityEntity;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class StudentDTO {
    private String surname;
    private String name;
    private Integer stipend;
    private Integer course;
    private String city;
    private LocalDate birthday;
    private UniversityDTO university;
}
