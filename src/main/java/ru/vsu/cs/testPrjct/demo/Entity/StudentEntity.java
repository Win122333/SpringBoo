package ru.vsu.cs.testPrjct.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDate;

@Builder
@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "stipend")
    private Integer stipend;
    @Column(name = "kurs")
    private Integer course;
    @Column(name = "city")
    private String city;
    @Column(name = "birthday")
    private LocalDate birthday;
    @JoinColumn(name = "univ_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @BatchSize(size = 20)
    private UniversityEntity university;
}
