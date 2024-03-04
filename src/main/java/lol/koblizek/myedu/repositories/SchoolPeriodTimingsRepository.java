package lol.koblizek.myedu.repositories;

import lol.koblizek.myedu.models.school.SchoolPeriodTimings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolPeriodTimingsRepository extends JpaRepository<SchoolPeriodTimings, Long> {
}