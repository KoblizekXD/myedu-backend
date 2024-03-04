package lol.koblizek.myedu.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lol.koblizek.myedu.models.school.Classroom;
import lol.koblizek.myedu.models.school.School;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "students")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}
