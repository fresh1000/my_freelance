
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pairs implements IFrequency {
    @Override
    public Map<String, Integer> tokens(String text) {
        Map<String, Integer> answer = new TreeMap<>();

        for (int i=0; i<text.length()-1; ++i)
        {
            String c = text.substring(i, i+2).toUpperCase();
            if (answer.containsKey(c)) {
                answer.put(c, answer.get(c) + 1);
            } else {
                answer.put(c, 1);
            }
        }
        return answer;
    }
}
