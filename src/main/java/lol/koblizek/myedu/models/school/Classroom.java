package lol.koblizek.myedu.models.school;

import jakarta.persistence.*;
import lol.koblizek.myedu.models.user.Student;
import lol.koblizek.myedu.models.user.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "classes")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "head_teacher_id")
    private Teacher headTeacher;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "classroom")
    private List<Student> students;
}
