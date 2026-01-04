package ru.vsu.cs.testPrjct.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.testPrjct.demo.Entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
