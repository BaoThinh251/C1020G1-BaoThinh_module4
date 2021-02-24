package dictionary.service;

import dictionary.model.Dictionary;
import dictionary.repository.DictionaryRepository;
import dictionary.repository.DictionaryRepositoryImpl;

import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService {
    DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
    @Override
    public Map<Integer, Dictionary> findAll() {
        return dictionaryRepository.findAll();
    }
}
