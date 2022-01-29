package org.java12_17;

public class PatternMatchingInstanceOf {

    public static void main(String[] args) {
        /* Pattern matching for instanceof eliminates boilerplate code for performing casts after type comparisons:*/

        // the scope of the new variable s is intuitively limited to the if branch. To be precise, the variable is
        // in scope where the pattern is guaranteed to have matched,
        Object o = "string disguised as object";
        if (o instanceof String s) {
            System.out.println(s.toUpperCase());
        }

        // old version
        if (o instanceof String ) {
            System.out.println( ((String)o).toUpperCase());
        }

        if (o instanceof String s && !s.isEmpty()) {
            System.out.println(s.toUpperCase());
        }

        if (!(o instanceof String s)) {
            throw new RuntimeException("expecting string");
        }
        // s is in scope here!  Remove Exception and compile error appears
        System.out.println(s.toUpperCase());
    }
}
