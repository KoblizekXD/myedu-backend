package lol.koblizek.myedu.models.user;

import jakarta.persistence.*;
import lol.koblizek.myedu.models.school.School;
import lol.koblizek.myedu.models.school.Subject;
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
