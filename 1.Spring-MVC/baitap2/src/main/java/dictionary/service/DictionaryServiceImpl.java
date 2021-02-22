package dictionary.service;

import dictionary.model.Dictionary;
import dictionary.repository.DictionaryRepository;
import dictionary.repository.DictionaryRepositoryImpl;

import java.util.List;

public class DictionaryServiceImpl implements DictionaryService {
    DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
    @Override
    public List<Dictionary> findAll() {
        return dictionaryRepository.findAll();
    }
}
