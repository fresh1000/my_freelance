
import java.util.*;

public class Letters implements IFrequency {

    @Override
    public Map<String, Integer> tokens(String text) {
        Map<String, Integer> answer = new TreeMap<>();
        for (int i=0; i<text.length(); ++i)
        {
            String c = text.substring(i, i+1).toUpperCase();
            if (answer.containsKey(c)) {
                answer.put(c, answer.get(c) + 1);
            } else {
                answer.put(c, 1);
            }
        }
        return answer;
    }
}
