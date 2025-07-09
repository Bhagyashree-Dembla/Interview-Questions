package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 8. Sort the list of strings based on their lengths in ascending/descending order.
 * 9. Find the longest word in the list.
 * 10. Get the list of strings having vowels
 * 11. convert a list of strings into a single string, separated by commas, using streams
 * 12. Write a Java program to create a new list of strings, where each string is reversed from the original list, using Java streams.
 * 13. Write a Java program to remove all strings from the list that are empty or null using streams.
 */
public class StreamInterviewStringsIntermediate {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Bengaluru", "Chennai", "Hyderabad", "Pune", "Noida", "Jaipur", "Bengaluru", "udaipur", "Nagpur", "qwrt", "nmbhj", "");
        //8
        cities.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        cities.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        //9
        Optional<String> longest = cities.stream()
                .max(Comparator.comparing(String::length));
        longest.ifPresent(System.out::println);
        System.out.println("-------------------------------");
        //10
        cities.stream()
                .filter(city -> city.matches(".*[aeiouAEIOU].*"))
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        //11
        String concatCity = cities.stream()
                .collect(Collectors.joining(", "));
        System.out.println(concatCity);
        System.out.println("-------------------------------");
        //12
        List<String> reversedCity = cities.stream()
                .map(city -> String.valueOf(new StringBuilder(city).reverse()))
                .toList();
        System.out.println(reversedCity);
        System.out.println("-------------------------------");
        //13
        cities.stream()
                .filter(city -> city != null && (!city.isEmpty()))
                .forEach(System.out::println);
        System.out.println("-------------------------------");

    }
}
