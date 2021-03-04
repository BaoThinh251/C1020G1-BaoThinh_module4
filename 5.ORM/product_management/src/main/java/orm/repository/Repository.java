package orm.repository;


import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    void save(T model);

    T findById(Long id);

    void delete(Long id);
}
