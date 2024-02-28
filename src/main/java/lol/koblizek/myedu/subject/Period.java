package lol.koblizek.myedu.subject;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "periods")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    // Nth period
    private int period;
    private Date date;
    private String topic;

    @OneToOne
    @JoinColumn(name = "homework_id")
    private Homework homework;
}
