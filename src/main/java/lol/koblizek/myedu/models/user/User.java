package lol.koblizek.myedu.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lol.koblizek.myedu.models.school.School;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;
}