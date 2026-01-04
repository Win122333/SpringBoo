package ru.vsu.cs.testPrjct.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.testPrjct.demo.Entity.UniversityEntity;
@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {
}
