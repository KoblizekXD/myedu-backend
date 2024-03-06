package lol.koblizek.myedu.dto;

import jakarta.validation.constraints.Email;
import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.models.school.SchoolPeriodTimings;
import lombok.Builder;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link School}
 */
@Builder
public record SchoolDto(String name, String domain, @Email String contactEmail, SchoolPeriodTimings timings,
                        String address) implements Serializable {

    public static SchoolDto from(School school) {
        return new SchoolDto(school.getName(), school.getDomain(), school.getContactEmail(), school.getSchoolPeriodTimings(), school.getAddress());
    }
}