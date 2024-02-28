package lol.koblizek.myedu.subject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "homeworks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "period_id")
    private Period due;

    private String description;
}
