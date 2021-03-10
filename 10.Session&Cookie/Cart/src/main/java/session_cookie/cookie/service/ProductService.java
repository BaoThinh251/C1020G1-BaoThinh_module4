package session_cookie.cookie.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import session_cookie.cookie.model.Product;

public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);

    Product findById(int id);

    void save(Product product);

    void deleteOne(Product product);

    void deleteAll();
}
