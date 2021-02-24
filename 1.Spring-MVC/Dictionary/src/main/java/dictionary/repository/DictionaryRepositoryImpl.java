package dictionary.repository;

import dictionary.model.Dictionary;

import java.util.*;

public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static Map<Integer, Dictionary> dictionaries = new LinkedHashMap<Integer, Dictionary>();

    static {
        dictionaries.put(1, new Dictionary("hello", "xin chao"));
        dictionaries.put(2, new Dictionary("dog", "con cho"));
        dictionaries.put(3, new Dictionary("cat", "con meo"));
        dictionaries.put(4, new Dictionary("goodnight", "chuc ngu ngon"));
        dictionaries.put(5, new Dictionary("goodbye", "tam biet"));
        dictionaries.put(6, new Dictionary("mouse", "con chuot"));
    }

    @Override
    public Map<Integer, Dictionary> findAll() {
        return dictionaries;
    }
}
