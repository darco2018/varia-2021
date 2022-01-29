package org.java12_17;

public class StringMethods {

    public static void main(String[] args) {
        String text = "Hello Baeldung!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-2);
        System.out.println(text);

        //---------- transform - It accepts a single argument function as a parameter that will be applied to the string.

        String s = "Baeldung";
        String transformed = s.transform(value ->
                new StringBuilder(value).reverse().toString()
        );
        System.out.println(transformed); // gnudleaB
    }
}
