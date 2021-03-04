package dictionary.service;

import dictionary.model.Dictionary;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    public static Map<Integer, Dictionary> dictionaries = new LinkedHashMap<Integer, Dictionary>();

    static {
        dictionaries.put(1, new Dictionary("hello", "xin chao"));
        dictionaries.put(2, new Dictionary("dog", "con cho"));
        dictionaries.put(3, new Dictionary("cat", "con meo"));
        dictionaries.put(4, new Dictionary("goodnight", "chuc ngu ngon"));
        dictionaries.put(5, new Dictionary("goodbye", "tam biet"));
        dictionaries.put(6, new Dictionary("mouse", "con chuot"));
    }

    @Override
    public String compare(String keyword) {
        String result = null;
        for (int i = 1; i < dictionaries.size() + 1; i++) {
            if (keyword.equalsIgnoreCase(dictionaries.get(i).getEn())) {
                result = dictionaries.get(i).getVi();
                break;
            } else {
                result = "Can't find this word!";
            }
        }
        return result;
    }
}
