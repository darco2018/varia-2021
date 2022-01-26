package org.java9_11;

import java.io.*;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) throws IOException {

        System.out.println(readData("testowy string"));
    }

    // If the resource is referenced by a final or effectively final variable, a try-with-resources statement
    // can manage a resource without a new variable being declared:
    // a variable is effectively final if it doesn't change after the first assignment,

    static String readData(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString); //declared BEFORE try()

        try (br) {
            return br.readLine();
        }
    }

    static String anotherTryWithResourcesExample() throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File("testRead.txt"));
        PrintWriter writer = new PrintWriter(new File("testWrite.txt"));
        try (scanner; writer) { // (colon to separate resources)
            // omitted
        }

        return null;
    }
}
