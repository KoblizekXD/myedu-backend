package lol.koblizek.myedu.user.teacher;

import jakarta.persistence.*;
import lol.koblizek.myedu.school.School;
import lol.koblizek.myedu.subject.Subject;
import lol.koblizek.myedu.user.User;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher extends User {

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
