package ru.vsu.cs.testPrjct.demo.Dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UniversityDTO {
    private String name;
    private Integer rating;
    private String city;
}
