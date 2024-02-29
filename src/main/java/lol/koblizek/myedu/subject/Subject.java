package lol.koblizek.myedu.subject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lol.koblizek.myedu.user.teacher.Teacher;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "teacher_id")
    private Teacher teacher;

    @Column(nullable = false)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<Period> periods;
}
