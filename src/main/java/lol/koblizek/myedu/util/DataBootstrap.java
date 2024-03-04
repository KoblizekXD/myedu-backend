package lol.koblizek.myedu.util;

import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.models.school.SchoolPeriodTimings;
import lol.koblizek.myedu.models.user.Student;
import lol.koblizek.myedu.repositories.SchoolPeriodTimingsRepository;
import lol.koblizek.myedu.repositories.SchoolRepository;
import lol.koblizek.myedu.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataBootstrap implements CommandLineRunner {

    private final SchoolPeriodTimingsRepository schoolPeriodTimingsRepository;
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) {
        if (!Arrays.asList(args).contains("--prod")) {
            log.warn("Loading test data..., use --prod to disable");

            schoolRepository.save(School.builder().name("SPST").address("Trebic")
                    .contactEmail("office@spst.cz")
                    .domain("spst.cz")
                    .schoolPeriodTimings(schoolPeriodTimingsRepository.save(new SchoolPeriodTimings()
                            .lesson().pause(5).lesson()))
                    .build());
        }
    }
}
