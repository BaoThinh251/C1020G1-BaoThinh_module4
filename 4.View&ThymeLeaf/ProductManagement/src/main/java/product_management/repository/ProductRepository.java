package product_management.repository;

import product_management.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void create(Product product);

    void updateById(Integer id, Product product);

    void deleteById(Integer id);

    Product showDetailInfo(Integer id);

    Product findById(Integer id);
}