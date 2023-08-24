package io.itjun.basic.lambda;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * stream has already been operated upon or closed
 */
public class StreamOperatedError {

    public static void main(String[] args) {
//        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
//        Optional<String> result1 = stringStream.findAny();
//        System.out.println(result1.get());
//        Optional<String> result2 = stringStream.findFirst();

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("A", "B", "C", "D");
        Stream<String> items = streamSupplier.get().filter(k -> k.contains("A"));
        Optional<String> result1 = streamSupplier.get().findAny();
        System.out.println(result1.get());
        Optional<String> result2 = streamSupplier.get().findFirst();
        System.out.println(result2.get());
    }

}
