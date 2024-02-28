package lol.koblizek.myedu.school;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lol.koblizek.myedu.user.Student;
import lol.koblizek.myedu.user.Teacher;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "schools")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToMany(mappedBy = "school")
    private List<Student> students;

    private String name;
    private String address;
    private String domain;

    @Email
    @Column(name = "contact_email")
    private String contactEmail;

    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

    @OneToOne(mappedBy = "school")
    private SchoolPeriodTimings schoolPeriodTimings;
}
