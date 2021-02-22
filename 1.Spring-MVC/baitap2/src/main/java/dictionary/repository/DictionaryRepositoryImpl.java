package dictionary.repository;

import dictionary.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static List<Dictionary> dictionaries = new ArrayList<>();

    static {
        dictionaries.add(new Dictionary("hello", "xin chao"));
        dictionaries.add(new Dictionary("dog", "con cho"));
        dictionaries.add(new Dictionary("cat", "con meo"));
        dictionaries.add(new Dictionary("goodnight", "chuc ngu ngon"));
        dictionaries.add(new Dictionary("goodbye", "tam biet"));
        dictionaries.add(new Dictionary("mouse", "con chuot"));
    }

    @Override
    public List<Dictionary> findAll() {
        return dictionaries;
    }
}
