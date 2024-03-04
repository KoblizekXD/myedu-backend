package lol.koblizek.myedu.repositories;

import lol.koblizek.myedu.models.school.School;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SchoolRepository extends CrudRepository<School, UUID> {
    @NotNull List<School> findAll();

    @Override
    <S extends School> @NotNull S save(@NotNull S entity);
}
