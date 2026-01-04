package ru.vsu.cs.testPrjct.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecturer")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LecturerEntity {
    @Id
    @Column(name = "lecturer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @ManyToOne()
    @JoinColumn(name = "univ_id")
    private UniversityEntity university;
}