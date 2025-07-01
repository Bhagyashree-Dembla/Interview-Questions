import java.util.List;

public class LongestSequencePrefix {
    public static String findLongestSequencePrefix(List<String> input) {
        if(input == null || input.isEmpty()){
            return "";
        }
        String prefix = input.get(0);

        for(int i = 1; i < input.size(); i++){
            while(!input.get(i).startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()){
                    return "";
                }
            }

        }

        return prefix;
    }
}
