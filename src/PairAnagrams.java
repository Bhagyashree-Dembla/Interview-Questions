import java.util.*;

public class PairAnagrams {
    public static List<List<String>> findAnagramPairs(List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String word : words) {
            char[] chr = word.toCharArray();
            Arrays.sort(chr);
            anagramMap.computeIfAbsent(Arrays.toString(chr), k -> new ArrayList<>()).add(word);
                    }

        for(List<String> group : anagramMap.values()) {
            if(group.size() > 1){
                result.add(group);
            }
        }
        return result;
    }
}
