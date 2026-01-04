package ru.vsu.cs.testPrjct.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@Table(name = "university")
@AllArgsConstructor
@NoArgsConstructor
public class UniversityEntity {
    @Id
    @Column(name = "univ_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "univ_name")
    private String name;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "city")
    private String city;
}
