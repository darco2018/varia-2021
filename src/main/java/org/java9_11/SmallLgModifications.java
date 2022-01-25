package org.java9_11;

import java.io.*;
import java.util.*;

public class SmallLgModifications {

    public static void main(String[] args) throws IOException {
        System.out.println(readData("testowy string"));



        //-------------------- immutable set - The Set returned by this method is JVM internal class:
        // java.util.ImmutableCollections.SetN, which extends public java.util.AbstractSet.
        Set<String> strKeySet = Set.of("key1", "key2", "key3");
        String[] arr = {"key1", "key2", "key3"};
        strKeySet = Set.of(arr);


        //  .copyOf() are factory methods for creating unmodifiable instances from existing collections.
        //Also, Collectors class has some new methods like toUnmodifiableList, toUnmodifiableSet, toUnmodifiableMap.
        Set<String> copySet = Set.copyOf(strKeySet);

        Map<String, Integer> map = Map.of("John", 1, "Betty", 2);
        Map<String, Integer> mapCopy = Map.copyOf(map);


        List<String> list = List.of("car", "bike"); // immutable
        List<String> copyList = List.copyOf(list);
        System.out.println(list == copyList);   // true
        // Because list is already immutable there's no practical need to actually create a copy of the list-instance,
        // therefore list and copy are the same instance

        var list2 = new ArrayList<String>(); // mutable
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);   // false

        // ava.util.Collection interface contains a new default toArray method which takes an IntFunction argument.
        //This makes it easier to create an array of the right type from a collection:
        var sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);


        // we don't need to compile the Java source files with javac explicitly anymore:
        // java HelloWorld.java



    }

    // If the resource is referenced by a final or effectively final variable, a try-with-resources statement
    // can manage a resource without a new variable being declared:
    // a variable is effectively final if it doesn't change after the first assignment,
    static String readData(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);

        try (br) {
            return br.readLine();
        }
    }

    static String anotherTryWithResourcesExample() throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File("testRead.txt"));
        PrintWriter writer = new PrintWriter(new File("testWrite.txt"));
        try (scanner; writer) {
            // omitted
        }

        return null;
    }
}
