package lol.koblizek.myedu.user.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @NonNull
    List<Student> findAll();

    List<Student> findAllBySchoolId(UUID schoolId);
}
