package org.java9_11;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalsStreams {

    public static void main(String[] args) {

        //---------------------------- java.util.Optional.stream() gives us an easy way to you use
        // the power of Streams on Optional elements:
        List<Optional<String>> listOfOptionals = new ArrayList<>();
        listOfOptionals.add(Optional.of("fly"));
        listOfOptionals.add(Optional.of("bee"));
        List<String> filteredList = listOfOptionals.stream()
                .flatMap(Optional::stream) // replaces each element Optional -> String  (If a value is present, returns a sequential Stream
                // containing only that value, otherwise returns an empty Stream.)
                .collect(Collectors.toList());
        System.out.println(filteredList); // [fly, bee]


        // new methods: Optional.ifPresentOrElse(Consumer, Runnable)

        Optional.of("foo").orElseThrow();     // foo If a value is present, returns the value, otherwise throws NoSuchElementException.
        Optional.of("foo").stream().count();  // 1
        Optional.ofNullable(null)
                .or(() -> Optional.of("fallback"))
                .get();                           // fallback


        System.out.println(Stream.ofNullable(null)
                .count());// 0


        System.out.println(Stream.of(1, 2, 3, 2, 1, 6, -2)
                .dropWhile(n -> n < 3) // start dropping and when dropping ends do not resume dropping
                .collect(Collectors.toList())); ;  // [3, 2, 1, 6, -2]

        System.out.println( Stream.of( 1, 2, 3, 2, 1, 8)
                .takeWhile(n -> n < 3) // start taking but when it ends do not resume
                .collect(Collectors.toList())); // [1, 2]

        System.out.println( Stream.of(9, 1, 2, 3, 2, 1, 8)
                .takeWhile(n -> n < 3)
                .collect(Collectors.toList())); // []


// A static not method has been added to the Predicate interface. We can use it to negate an
// existing predicate, much like the negate method.
        // not(isBlank) reads more naturally than isBlank.negate(), the big advantage is that
        // we can also use not with method references, like not(String:isBlank).
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        //assertThat(withoutBlanks).containsExactly("Java", "Kotlin");


        // Support for using the local variable syntax (var keyword) in lambda parameters was added in Java 11.
        //We can make use of this feature to apply modifiers to our local variables, like defining a type annotation.
        // But why is this needed when we can just skip the type in the lambda?
        //If you need to apply an annotation just as @Nullable, you cannot do that without defining the type.
        List<String> sampleList2 = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList2.stream()
                .map((@NonNull var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        //assertThat(resultString).isEqualTo("JAVA, KOTLIN");
        /*(var s1, s2) -> s1 + s2 //no skipping allowed
            (var s1, String y) -> s1 + y //no mixing allowed
            var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
            */

    }
}
