package lol.koblizek.myedu.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository<T extends User> extends CrudRepository<T, UUID> {
}
