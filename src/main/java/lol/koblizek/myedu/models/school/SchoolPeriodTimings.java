package lol.koblizek.myedu.models.school;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "school_period_timings")
public class SchoolPeriodTimings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ElementCollection
    private final List<String> periodTimings;

    private final LocalTime time;
    private final int lessonLength;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "school_period_timings_school")
    private School school;

    public SchoolPeriodTimings() {
        this.time = LocalTime.of(8, 0);
        this.lessonLength = 45;
        this.periodTimings = new ArrayList<>();
    }

    public SchoolPeriodTimings(LocalTime start, int lessonLength) {
        this.time = start;
        this.lessonLength = lessonLength;
        this.periodTimings = new ArrayList<>();
    }

    public static SchoolPeriodTimings builder(LocalTime start, int lessonLength) {
        return new SchoolPeriodTimings(start, lessonLength);
    }

    public SchoolPeriodTimings lesson() {
        periodTimings.add("lesson");
        return this;
    }

    public SchoolPeriodTimings pause(int length) {
        periodTimings.add("break@" + length);
        return this;
    }
}
