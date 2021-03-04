package validation.validate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import validation.validate.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
