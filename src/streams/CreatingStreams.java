package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void show() {
//        int[] arr = {1,2,3,4,9,5};
//        Arrays.stream(arr).filter(odd -> odd % 2 != 0).forEach(System.out::println);
//
//        var stream = Stream.generate(() -> Math.random());
//
//        stream
//                .limit(3)
//                .forEach(System.out::println);
        Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);
    }


}
