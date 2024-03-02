package lol.koblizek.myedu.services;

import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.models.user.Student;
import lol.koblizek.myedu.models.user.Teacher;
import lol.koblizek.myedu.repositories.StudentRepository;
import lol.koblizek.myedu.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Getter
@Setter
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;
    private final UserRepository<Teacher> teacherRepository;

    @Autowired
    public UserService(PasswordEncoder encoder, StudentRepository studentRepository, UserRepository<Teacher> teacherRepository) {
        this.passwordEncoder = encoder;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public boolean userExists(String email, String password) {
        var student = studentRepository.findByEmail(email);
        var teacher = teacherRepository.findByEmail(email);

        if (student.isPresent() && passwordEncoder.matches(password, student.get().getPassword())) {
            return true;
        } else return teacher.isPresent() && passwordEncoder.matches(password, teacher.get().getPassword());
    }
}
