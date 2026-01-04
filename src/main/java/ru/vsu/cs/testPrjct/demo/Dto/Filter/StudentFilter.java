package ru.vsu.cs.testPrjct.demo.Dto.Filter;

import jakarta.persistence.Column;

public record StudentFilter (
        String surname,
        String name,
        Integer stipend,
        Integer course,
        String city
) {
}
