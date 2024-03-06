package lol.koblizek.myedu.util;

import lol.koblizek.myedu.dto.SchoolDto;
import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.models.school.SchoolPeriodTimings;
import lol.koblizek.myedu.models.user.Student;
import lol.koblizek.myedu.repositories.SchoolPeriodTimingsRepository;
import lol.koblizek.myedu.repositories.SchoolRepository;
import lol.koblizek.myedu.repositories.StudentRepository;
import lol.koblizek.myedu.services.SchoolService;
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
    private final SchoolService schoolService;

    @Override
    public void run(String... args) {
        if (!Arrays.asList(args).contains("--prod")) {
            log.warn("Loading test data..., use --prod to disable");
            SchoolPeriodTimings timings = schoolPeriodTimingsRepository.save(new SchoolPeriodTimings().lesson().pause(5).lesson());
            schoolService.save(SchoolDto.builder()
                            .name("SPST")
                            .contactEmail("office@spst.cz")
                            .timings(timings)
                            .address("Trebic")
                            .domain("spst.cz")
                    .build());
        }
    }
}
