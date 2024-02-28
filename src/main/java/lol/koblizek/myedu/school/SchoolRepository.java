package lol.koblizek.myedu.school;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SchoolRepository extends CrudRepository<School, UUID> {
    @NotNull List<School> findAll();
}
