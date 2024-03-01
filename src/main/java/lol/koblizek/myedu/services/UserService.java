package lol.koblizek.myedu.services;

import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.models.user.Student;
import lol.koblizek.myedu.repositories.StudentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Getter
@Setter
public class UserService {
    private final StudentRepository studentRepository;

    public UserService(StudentRepository studentRepository) {
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