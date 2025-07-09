package streams;

import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void show() {
        List<Movies> movies = List.of(
                new Movies("a", 10, Genre.ACTION),
                new Movies("b", 15, Genre.COMEDY),
                new Movies("c", 20, Genre.COMEDY),
                new Movies("ch", 25, Genre.COMEDY),
                new Movies("d", 30, Genre.DOCUMENTARY)
        );

        movies.stream()
                .filter(m -> m.getLikes() >= 15)
                .filter(m -> m.getGenre() == Genre.COMEDY)
                .map(Movies::getMovie)
                .sorted()
                .limit(3)
                .skip(1)
//                .peek(m -> System.out.println("skip: " + m))
//                .filter(m -> m.startsWith("c"))
                .forEach(System.out::println);

//var result = movies.stream()
//        .collect(Collectors.groupingBy(Movies::getGenre, Collectors.mapping(
//                Movies::getMovie, Collectors.joining(", ")
//        )));
//        movies.stream()
//                .filter(movie -> movie.getLikes() > 10)
//                .collect(Collectors.toMap(Movies::getMovie, Movies::getLikes))
//                .forEach((k,v) -> System.out.println(k + ":" + v));
        ;
//         movies.stream().map(Movies::getMovie).toList().forEach(System.out::println);
//        Stream.of(List.of(1,2,3), List.of(4,5,6))
//                .peek(t -> System.out.println("Stream: " + t))
//                .flatMap(Collection::stream)
//                .peek(m -> System.out.println("flattened: " + m))
//                .forEach(System.out::println);
//        boolean result = movies.stream().noneMatch(m -> m.getLikes() > 10);
//        Movies result = movies.stream().min(Comparator.comparing(Movies::getLikes)).get();
//        System.out.println(result.getMovie());
//        int sum = movies.stream()
//                .map(Movies::getLikes)
//                .reduce(Integer::sum)
//                .orElse(0);
//        System.out.println(sum);
//        IntSummaryStatistics result = movies.stream()
//                .collect(Collectors.summarizingInt(Movies::getLikes));
//        System.out.println(result);
//        String result = movies.stream()
//                .map(Movies::getMovie)
//                .collect(Collectors.joining(", "));
//        System.out.println(result);
    }
}
