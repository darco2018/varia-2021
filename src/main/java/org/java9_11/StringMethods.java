package org.java9_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class StringMethods {

    public static void main(String[] args) throws IOException {

        //--------- method: List<String> s.lines()   & s.strip()
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip) // like trim() but with finer control
                .toList();

        //assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");

        // ------------s.repeat(int times)
        String str = "=".repeat(10);
        System.out.println(str); //prints ===========


        //--------------- Files.writeString(Path, CharSeq) & Files.readString(path)

        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on JD");
        System.out.println(path); // /tmp/test3551438729359894505.txt
        String s = Files.readString(path);
        System.out.println(s); //This was posted on JD
    }
}
