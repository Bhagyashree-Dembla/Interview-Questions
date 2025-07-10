package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 14. Given a list of strings, group a list of strings by the first letter of each string using streams
 * 15. Given a list of strings, group a list of strings by the length of the string
 * 16. Given a list of strings, create a map where the key is the last letter of the string, and the value is a list of strings that ends with that letter using streams
 * 17. Given a list of strings, group the list of strings with vowels and no vowels into two lists
 * 18. Given a list of strings print only the string elements excluding the digits using streams.
 * 19. Given a list of strings find the first element having the length as 10 if not handle exceptions
 * 20. Reverse the list of strings using streams api
 */
public class StreamInterviewStringsAdvanced {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Bengaluru8", "Chenn2ai", "Hyde1rabad", "P4une", "No7ida", "Jai6pur", "Ben8galuru", "udaipur", "Nagpu9r", "qwrt", "nmbhj", "");
        //14
        cities.stream()
                .filter(city -> city !=null && !(city.isEmpty()))
                .collect(Collectors.groupingBy(city -> city.toUpperCase().charAt(0)))
                        .forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("--------------------------------------------");
        //15
        cities.stream()
                .collect(Collectors.groupingBy(String::length))
                .forEach((k,v) -> System.out.println(k + ": " + v));
        System.out.println("--------------------------------------------");
        //16
        cities.stream()
                .filter(city -> city != null && !(city.isEmpty()))
                .collect(Collectors.groupingBy(city -> city.charAt(city.length() - 1)))
                .forEach((k,v) -> System.out.println(k + ": " + v));
        System.out.println("--------------------------------------------");
        //17
         Map<Boolean, List<String>> vowelMap = cities.stream()
                         .collect(Collectors
                                 .partitioningBy(city -> city
                                         .toLowerCase()
                                         .matches(".*[aeiou].*")));
        System.out.println("With Vowel: " + vowelMap.get(true));
        System.out.println("Without Vowel: " + vowelMap.get(false));
        System.out.println("--------------------------------------------");
        //18
        cities.stream()
                .map(city -> city.replaceAll("[1-9]",""))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------");
        //19
        String lenTenCity = cities.stream()
                .filter(city -> city.length() == 10)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("custom exception"));
        System.out.println(lenTenCity);
        System.out.println("---------------------------------------------");
        //20
        IntStream.range(0, cities.size())
                .mapToObj(i -> cities.get(cities.size() - 1 - i))
                .forEach(System.out::println);
        System.out.println("--------------------------------");
        String input = "aabcdbdecest";
        Map<Character, Long> freqMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        int index = IntStream.range(0, input.length())
                .filter(i -> freqMap.get(input.charAt(i)) == 1)
                .findFirst()
                .orElse(-1);
        System.out.println(index);

    }
}
