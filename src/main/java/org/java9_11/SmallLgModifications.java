package org.java9_11;

import java.io.*;
import java.util.*;

public class SmallLgModifications {

    public static void main(String[] args) throws IOException {

         //-------------------- immutable set/ map / list
        //  The Set returned by this method is JVM internal class:
        // java.util.ImmutableCollections.SetN, which extends public java.util.AbstractSet.
        Set<String> stringSet = Set.of("key1", "key2", "key3");
        String[] arr = {"key1", "key2", "key3"};
        stringSet = Set.of(arr);

        Map<String, Integer> map = Map.of("John", 1, "Betty", 2); // just key, val, key, val
        List<String> list = List.of("car", "bike"); // immutable

        //--------------  .copyOf() ----------------
        // are factory methods for creating unmodifiable instances from existing collections.
        //Also, Collectors class has some new methods like toUnmodifiableList, toUnmodifiableSet, toUnmodifiableMap.
        Set<String> setCopy = Set.copyOf(stringSet);
        Map<String, Integer> mapCopy = Map.copyOf(map);

        List<String> copyList = List.copyOf(list);
        System.out.println(list == copyList);   // true
        // Because list is already immutable there's no practical need to actually create a copy of the list-instance,
        // therefore list and copy are the same instance


        var list2 = new ArrayList<String>(); // mutable
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);   // false

        //-----------  T[] java.util.Collection.toArray((java.util.function.IntFunction<T[]> generator) -----------
        // contains a new default toArray method which takes an IntFunction argument.
        //This makes it easier to create an array of the right type from a collection:

        var sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);


        //---------------------------- we don't need to compile the Java source files with javac explicitly anymore:
        // java HelloWorld.java

    }




}
