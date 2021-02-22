package dictionary.service;

import dictionary.model.Dictionary;

import java.util.List;

public interface DictionaryService {
    List<Dictionary> findAll();
}
