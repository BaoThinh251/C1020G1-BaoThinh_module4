package dictionary.repository;

import dictionary.model.Dictionary;

import java.util.List;

public interface DictionaryRepository {
    List<Dictionary> findAll();
}
