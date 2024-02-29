package lol.koblizek.myedu.util;

import lol.koblizek.myedu.school.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataBootstrap implements CommandLineRunner {

    private final SchoolRepository schoolRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!Arrays.asList(args).contains("--prod")) {
            log.warn("Loading test data..., use --prod to disable");
        }
    }
}
