package lol.koblizek.myedu.repositories;

import lol.koblizek.myedu.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, UUID> {
    @NonNull
    List<T> findAll();

    List<T> findAllBySchoolId(UUID schoolId);

    Optional<T> findByEmail(String email);

    boolean existsByEmail(String email);
}
