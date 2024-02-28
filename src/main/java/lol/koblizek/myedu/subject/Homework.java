package lol.koblizek.myedu.subject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "homeworks")
@Getter
@Setter
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "period_id")
    private Period due;

    private String description;
}
