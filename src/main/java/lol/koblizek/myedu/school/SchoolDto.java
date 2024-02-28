package lol.koblizek.myedu.school;

import jakarta.validation.constraints.Email;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link School}
 */
@EqualsAndHashCode(callSuper = true)
public record SchoolDto(UUID id, String name, String domain, @Email String contactEmail) implements Serializable {

    public static SchoolDto from(School school) {
        return new SchoolDto(school.getId(), school.getName(), school.getDomain(), school.getContactEmail());
    }
}