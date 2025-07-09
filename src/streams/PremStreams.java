package streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class PremStreams {

    public static void main(String[] args) {
//        double avg = Arrays.stream(new int[]{1, 2, 3, 4, 5})
//                .average().getAsDouble();
//        System.out.println(avg);
        IntStream.rangeClosed(100, 200)
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }
}
