package lol.koblizek.myedu.dto;

import jakarta.validation.constraints.Email;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link lol.koblizek.myedu.models.user.Student}
 */
@Value
public class StudentDto implements Serializable {
    SchoolDto school;
    String fullName;
    @Email
    String email;
    String password;
}