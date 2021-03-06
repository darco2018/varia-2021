package org.java12_17;

public class TextBlocks {

    public static void main(String[] args) {
        /* multi-line strings that contain double quotes, without having to use \n or \" escape sequences:
         * A text block is opened by three double quotes """ followed by a line break, and closed by three double-quotes
         * */

        String block = """
                Multi-line text
                 with indentation
                  and "double quotes"!
                   """;

        System.out.println(block); // gets printed exactly as it is

        block = """
                      Multi-line text
                    with indentation
                     and "double quotes"!
                """; // these mark where spaces start

        System.out.println(block);


        // Line breaks inside text blocks can be escaped:
        String block3 = """
                No \
                line \
                breaks \
                at \
                all \
                please\
                      """;

        System.out.println(block3); // No line breaks at all please
        System.out.println("\n");

        String block4 = """
                No final line break
                at the end of this string, please""";
        System.out.println(block4);
        System.out.println("\n");

        // ---------------- String::formatted ----------------------
        // Inserting variables into a text block can be done as usual with the static method String::format,
        // or with the new instance method String::formatted, which is a little shorter to write:
        String block5 = """
                %s marks the spot.
                """.formatted("X");
        System.out.println(block5);


        // \ to indicate a new line character is not introduced
        String multiline = """
                A quick brown fox jumps over a lazy dog; \
                the lazy dog howls loudly.""";

        System.out.println(multiline); // A quick brown fox jumps over a lazy dog; the lazy dog howls loudly.


    }

    private void jsonUse() {
        String JSON_STRING_OLD
                = "{\r\n" + "\"name\" : \"Baeldung\",\r\n" + "\"website\" : \"https://www.%s.com/\"\r\n" + "}";

        String TEXT_BLOCK_JSON = """
                {
                    "name" : "Baeldung",
                    "website" : "https://www.%s.com/"
                }
                """;
    }


}
