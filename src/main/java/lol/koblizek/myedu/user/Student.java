package lol.koblizek.myedu.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public final class Student extends User {
}
