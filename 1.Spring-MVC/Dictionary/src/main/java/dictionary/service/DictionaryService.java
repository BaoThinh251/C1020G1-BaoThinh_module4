package dictionary.service;

import dictionary.model.Dictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryService {
    Map<Integer, Dictionary> findAll();
}
