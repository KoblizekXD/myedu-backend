package lol.koblizek.myedu.controllers;

import lol.koblizek.myedu.dto.SchoolDto;
import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.services.SchoolService;
import lol.koblizek.myedu.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/school")
public class SchoolController {

    private final SchoolService schoolService;
    private final UserService userService;

    public SchoolController(SchoolService schoolService, UserService userService) {
        this.schoolService = schoolService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<SchoolDto> getSchool(Authentication auth) {
        return ResponseEntity.ok(SchoolDto.from(userService.getUserByEmail(auth.getName()).getSchool()));
    }
}
