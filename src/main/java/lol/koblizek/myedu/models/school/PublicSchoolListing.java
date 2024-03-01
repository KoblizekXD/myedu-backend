package lol.koblizek.myedu.models.school;

import java.util.List;
import java.util.UUID;

public record PublicSchoolListing(int entries, List<UUID> schools) {
}
