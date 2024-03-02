package lol.koblizek.myedu.repositories;

import lol.koblizek.myedu.models.user.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends UserRepository<Student> {
}
