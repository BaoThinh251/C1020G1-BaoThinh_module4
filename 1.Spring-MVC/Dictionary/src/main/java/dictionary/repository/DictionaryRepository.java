package dictionary.repository;

import dictionary.model.Dictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryRepository {
    Map<Integer, Dictionary> findAll();
}
