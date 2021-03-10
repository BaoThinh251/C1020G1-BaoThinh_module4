package session_cookie.cookie.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import session_cookie.cookie.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
