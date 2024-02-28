package lol.koblizek.myedu.global;

import jdk.dynalink.linker.LinkerServices;
import lol.koblizek.myedu.school.School;
import lol.koblizek.myedu.school.SchoolService;
import lol.koblizek.myedu.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(path = "/api/v1/public")
public class PublicController {
    private final UserService userService;
    private final SchoolService schoolService;

    @Autowired
    public PublicController(UserService userService, SchoolService schoolService) {
        this.userService = userService;
        this.schoolService = schoolService;
    }

    @GetMapping
    public PublicSchoolListing getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return new PublicSchoolListing(schools.size(), schools.stream().map(s -> s.getId()).toList());
    }
}
