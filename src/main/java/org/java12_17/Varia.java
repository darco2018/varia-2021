package org.java12_17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Varia {

    public static void main(String[] args) {

        //--------- toList();
        // The aim is to reduce the boilerplate with some commonly used Stream collectors,
        // such as Collectors.toList and Collectors.toSet:
        List<String> integersAsString = Arrays.asList("1", "2", "3");
        List<Integer> ints = integersAsString.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> intsEquivalent = integersAsString.stream().map(Integer::parseInt)
                .toList();


        // NLP improvements
        int[] arr = null;
        arr[0] = 1; //INFO: Cannot store to int array because "arr" is null

        /* Previously Exception in thread "main" java.lang.NullPointerException
            at com.baeldung.MyClass.main(MyClass.java:27)*/
    }
}
