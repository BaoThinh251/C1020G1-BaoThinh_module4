package validation.validate.service;

import org.springframework.data.jpa.repository.JpaRepository;
import validation.validate.model.User;

public interface UserService{
    void save(User user);
}
