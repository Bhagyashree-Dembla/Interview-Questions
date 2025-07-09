package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 6. Remove duplicate elements from an array/list of integers
 * 7. Convert a list/array of integers to a list of their squares and print them
 * 8. Find the sum of squares of all the numbers in the array/list.
 * 9. Get the second largest number and second smallest  number in a list/array
 * 10. Get the first number greater than 50 in a list/array
 */
public class StreamInterviewNumbersIntermediate {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,20,12,13,30,40,19,80,13,78);
        int[] nums = new int[] {12,20,12,13,30,40,19,80,13,78};
        //6
        list.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println();
        Arrays.stream(nums)
                .distinct()
                .forEach(System.out::println);
        System.out.println("----------------------------------------");
        //7
        list.stream()
                .map(num -> num * num)
                        .forEach(System.out::println);
        System.out.println();
        Arrays.stream(nums)
                .map(num -> num * num)
                .forEach(System.out::println);
        System.out.println("----------------------------------------");
        //8
        int listSum = list.stream()
                .mapToInt(num -> num * num)
                        .sum();
        System.out.println("list: "+ listSum);
        System.out.println();
        int sum = Arrays.stream(nums)
                .map(num -> num * num)
                .sum();
        System.out.println(sum);
        System.out.println("----------------------------------------");
        //9
        list.stream()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .distinct()
                .skip(1)
                .findFirst().ifPresent(System.out::println);
        list.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst().ifPresent(System.out::println);
        System.out.println();
        Arrays.stream(nums)
                .sorted()
                .distinct()
                .skip(1)
                .findFirst().ifPresent(System.out::println);

        Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .distinct()
                .skip(1)
                .findFirst().ifPresent(System.out::println);
        System.out.println("----------------------------------------");
        //10
        list.stream()
                .sorted()
                .filter(num -> num > 50)
                .findFirst().ifPresent(System.out::println);
        System.out.println();
        Arrays.stream(nums)
                .sorted()
                .filter(num -> num > 50)
                .findFirst().ifPresent(System.out::println);

    }
}
