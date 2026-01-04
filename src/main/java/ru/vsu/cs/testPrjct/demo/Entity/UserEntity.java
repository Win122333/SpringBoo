package ru.vsu.cs.testPrjct.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.EnumMapping;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;
}
