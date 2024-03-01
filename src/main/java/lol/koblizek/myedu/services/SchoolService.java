package lol.koblizek.myedu.services;

import lol.koblizek.myedu.dto.SchoolDto;
import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public SchoolDto getSchoolInfo(UUID id) {
        var optionalSchool = schoolRepository.findById(id);

        return optionalSchool.map(SchoolDto::from).orElse(null);
    }
}
