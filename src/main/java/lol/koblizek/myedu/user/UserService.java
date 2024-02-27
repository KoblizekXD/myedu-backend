package lol.koblizek.myedu.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserService {
    private final UserRepository<Student> studentRepository;

    public UserService(UserRepository<Student> studentRepository) {
        this.studentRepository = studentRepository;
    }
}
