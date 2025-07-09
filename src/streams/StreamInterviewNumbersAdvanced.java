package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 11. Get the sum of numbers of a two dimensional array and list of list of integers
 * 12. Convert an array of integers into a map where the key is the number and the value is its square
 * 13. Partition an array of integers into two groups: even and odd using Streams.
 * 14. Calculate the product of all numbers in the array using reduce
 * 15.implement a parallel stream that computes the sum of squares of numbers in an array.
 */
public class StreamInterviewNumbersAdvanced {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 20, 12, 13, 30, 40, 19, 80, 13, 78);
        int[] nums = new int[]{12, 20, 12, 13, 30, 40, 19, 80, 13, 78};
        List<List<Integer>> twoDimList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        int[][] twoDimArr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        11
        int sumOf2DList = twoDimList.stream()
                .flatMap(Collection::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sumOf2DList);
        int sumOf2D = Arrays.stream(twoDimArr)
                .flatMapToInt(IntStream::of)
                .sum();
        System.out.println(sumOf2D);
        System.out.println("----------------------------------");
        //12
        list.stream()
                .distinct()
                .collect(Collectors.toMap(Function.identity(), num -> num * num))
                .forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();
        Arrays.stream(nums)
                .distinct()
                .boxed()
                .collect(Collectors.toMap(Function.identity(), num -> num * num))
                        .forEach((k,v) -> System.out.println(k + ": " + v));

        System.out.println("------------------------------------------------");
        //13

        Map<Boolean, List<Integer>> evenMap = list.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("Even: " + evenMap.get(true));
        System.out.println("False: " + evenMap.get(false));
        System.out.println();

        Map<Boolean, List<Integer>> primEvenMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.partitioningBy(num -> num%2 == 0));
        System.out.println("Even: " + primEvenMap.get(true));
        System.out.println("Odd: " + primEvenMap.get(false));
        System.out.println("-----------------------------------------");
        //14
        long product = list.stream()
                .mapToLong(Integer::longValue)
                .reduce(1L, (a, b) -> a * b);
        System.out.println(product);
        System.out.println();
        long primProduct = Arrays.stream(nums)
                .boxed()
                .mapToLong(Integer::longValue)
                .reduce(1L, (a, b) -> a * b);
        System.out.println(primProduct);
        System.out.println("-----------------------------------------");
        //15
        int squareSum = list.parallelStream()
                .map(num -> num * num)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(squareSum);
        System.out.println();
        int primSqSum = Arrays.stream(nums).parallel()
                .map(num -> num * num)
                .sum();
        System.out.println(primSqSum);
    }
}
