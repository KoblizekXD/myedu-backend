package lol.koblizek.myedu.user;

import lol.koblizek.myedu.HatefulReply;
import lol.koblizek.myedu.school.School;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Getter
@Setter
public class UserService {
    private final UserRepository studentRepository;

    public UserService(UserRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsBySchool(UUID id) {
        return studentRepository.findAllBySchoolId(id);
    }

    public List<Student> getStudentsBySchool(School school) {
        return studentRepository.findAllBySchoolId(school.getId());
    }
}
