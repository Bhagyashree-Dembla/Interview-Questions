package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1. Get the even/odd numbers from an array of numbers and list of numbers
 * 2. Get the even/odd numbers between a range
 * 3. Sort a list of integers in descending/ascending order
 * 4. Calculate the sum and average of numbers in an array and list of numbers
 * 5. Find the maximum/minimum number in an array/list of numbers
 */
public class StreamInterviewNumbersBasic {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,20,30,40,19,80,13,78);
        int[] nums = new int[] {12,20,30,40,19,80,13,78};

//        1
        list.stream()
                .filter(num -> num%2==0)
                .forEach(System.out::println);
        System.out.println();
        Arrays.stream(nums)
                .filter(num -> num%2==0)
                .forEach(System.out::println);
        System.out.println("----------------------------------------");
        //2
        IntStream.rangeClosed(10,100)
                .filter(num -> num % 2 == 0 )
                .forEach(System.out::println);
        System.out.println("----------------------------------------");
        //3
        list.stream()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .forEach(System.out::println);
        System.out.println();
        Arrays.stream(nums)
//                .boxed()
                .mapToObj(Integer::valueOf)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
        //4
         int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
        OptionalDouble opt = Arrays.stream(nums)
                .average();
        opt.ifPresent(System.out::println);
        System.out.println();
        int listSum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(listSum);
        OptionalDouble listAvg = list.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        listAvg.ifPresent(System.out::println);
        System.out.println("----------------------------------------");
        //5
        OptionalInt minValue = Arrays.stream(nums)
                .min();
        minValue.ifPresent(System.out::println);

        OptionalInt maxValue = Arrays.stream(nums)
                .max();
        maxValue.ifPresent(System.out::println);

        System.out.println();

        list.stream()
                .mapToInt(Integer::intValue)
                .min().ifPresent(System.out::println);
        list.stream()
                .mapToInt(Integer::intValue)
                .max().ifPresent(System.out::println);
    }
}
