package lol.koblizek.myedu.controllers;

import lol.koblizek.myedu.models.school.PublicSchoolListing;
import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.dto.SchoolDto;
import lol.koblizek.myedu.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/public")
public class PublicController {
    private final SchoolService schoolService;

    @Autowired
    public PublicController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/schools")
    public PublicSchoolListing getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return new PublicSchoolListing(schools.size(), schools.stream().map(School::getId).toList());
    }

    @GetMapping("/schools/{id}")
    public SchoolDto getSchoolInfo(@PathVariable String id) {
        return schoolService.getPublicSchoolInfo(UUID.fromString(id));
    }
}
