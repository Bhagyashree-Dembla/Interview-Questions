package streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1. Convert a list of strings to uppercase, sort them and print.
 * 2. Get the list of strings where length of each element is >5 and get the count.
 * 3. Remove duplicates from a list.
 * 4. Get the list of strings having a particular word.
 * 5. Remove strings that starts with a specific word from a list using streams.
 * 6. first element in a list that starts with a particular letter
 * 7. Get the length of each name in a list
 */
public class StreamInterviewStringsBasic {

    public static void main(String[] args) {
        String[] cities = {"Bengaluru", "Chennai", "Hyderabad", "Pune", "Noida", "Jaipur", "Bengaluru", "udaipur", "Nagpur"};
        //1
        Arrays.stream(cities)
                .map(city -> city.toUpperCase())
                .sorted()
                .forEach(System.out::println);
        System.out.println("------------------------------------");
        //2
        long countOfCities = Arrays.stream(cities)
                .filter(city -> city.length() > 5)
                .count();
        System.out.println(countOfCities);
        System.out.println("------------------------------------");
        //3
        Arrays.stream(cities)
                .distinct()
                .forEach(System.out::println);
        System.out.println("------------------------------------");
        //4
        Arrays.stream(cities)
                .filter(city -> city.contains("pur"))
                .forEach(System.out::println);
        System.out.println("------------------------------------");
        //5
        Arrays.stream(cities)
                .filter(city -> !city.startsWith("Ben"))
                .forEach(System.out::println);
        System.out.println("------------------------------------");
        //6
        String noida = Arrays.stream(cities)
                .filter(city -> city.startsWith("N"))
                        .findFirst().orElseThrow();
        System.out.println(noida);
        System.out.println("------------------------------------");
        //7
        Arrays.stream(cities)
                .distinct()
                .collect(Collectors.toMap(Function.identity(),String::length))
                .forEach((k,v) -> System.out.println(k + ": " + v));
        System.out.println("------------------------------------");

    }
}
