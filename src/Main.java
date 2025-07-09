import streams.CreatingStreams;
import streams.StreamsDemo;

import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        String input = "ccaapp";
//        int index = getUniqueElement(input);
//        System.out.println(index);
//        List<String> words = Arrays.asList("cat", "act", "bat", "rat", "abt");
//        List<List<String>> result = PairAnagrams.findAnagramPairs(words);
//        System.out.println(result);
//        List<Integer> input = Arrays.asList(1,1,2,1,3,6,4,5,6,6);
//        List<List<Integer>> result = ElementCount.getElementCount(input);
//        System.out.println(result);
//        List<String> input = Arrays.asList("flower", "flow", "flavin", "abccba");
//        String prefix = LongestSequencePrefix.findLongestSequencePrefix(input);
//        System.out.println("Prefix: " + prefix);
//        ComparableImplementation ci = new ComparableImplementation(25, "simon");
//        ComparableImplementation ci2 = new ComparableImplementation(28, "Mathew");

//        boolean isequal = ci.equals(ci2);
//        int findHash = ci.hashCode();
//        System.out.println(ci.toString());
//        System.out.println(isequal + " hash " + findHash);
//        System.out.println("CompareTo: " + ci2.compareTo(ci));

//        System.out.println(SixCharPalindrome.findSixCharPalindrome(input));
//        CreatingStreams.show();
        StreamsDemo.show();
    }

    private static int getUniqueElement(String input) {
        char[] inputArray = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            map.put(inputArray[i], map.getOrDefault(inputArray[i], 0) + 1);
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (map.get(inputArray[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

}

