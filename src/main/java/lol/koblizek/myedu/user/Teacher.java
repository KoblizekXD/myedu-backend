package lol.koblizek.myedu.user;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lol.koblizek.myedu.subject.Subject;
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
}
