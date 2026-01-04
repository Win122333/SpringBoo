package ru.vsu.cs.testPrjct.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.testPrjct.demo.Entity.LecturerEntity;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<LecturerEntity, Long> {
    @Query("SELECT l FROM LecturerEntity l JOIN FETCH l.university")
    public List<LecturerEntity> getAllWithUniversity();
}
