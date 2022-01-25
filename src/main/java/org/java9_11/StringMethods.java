package org.java9_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class StringMethods {

    public static void main(String[] args) throws IOException {
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip) // like trim() but with finer control
                .collect(Collectors.toList());

        //assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");


        String str = "=".repeat(2);
        System.out.println(str); //prints ==

        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on JD");
        System.out.println(path);
        String s = Files.readString(path);
        System.out.println(s); //This was posted on JD
    }
}
