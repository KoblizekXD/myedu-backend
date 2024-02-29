package lol.koblizek.myedu.user.student;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lol.koblizek.myedu.classroom.Classroom;
import lol.koblizek.myedu.school.School;
import lol.koblizek.myedu.user.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
