package product_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management.model.Product;
import product_management.repository.ProductRepository;
import product_management.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepos;

    @Override
    public List<Product> findAll() {
        return productRepos.findAll();
    }

    @Override
    public void create(Product product) {
        productRepos.create(product);
    }

    @Override
    public void updateById(Integer id, Product product) {
        productRepos.updateById(id, product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepos.deleteById(id);
    }

    @Override
    public Product showDetailInfo(Integer id) {
        return productRepos.showDetailInfo(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepos.findById(id);
    }

    @Override
    public int getIdProduct() {
        return findAll().size() + 1;
    }
}