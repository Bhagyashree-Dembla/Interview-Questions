
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementCount {
    public static List<List<Integer>> getElementCount(List<Integer> input) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(Integer element : input){
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }
        return result;
    }
}
