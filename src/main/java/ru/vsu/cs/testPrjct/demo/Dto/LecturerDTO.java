package ru.vsu.cs.testPrjct.demo.Dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LecturerDTO {
    private String surname;
    private String name;
    private String city;
    private UniversityDTO university;
}
