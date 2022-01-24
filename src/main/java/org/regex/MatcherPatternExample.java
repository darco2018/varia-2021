import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CreateMatcherExample {

    public static void main(String[] args) {

        String text    =
                "This is the text to be searched " +
                "for occurrences of the http:// pattern.";
        
        Pattern pattern = Pattern.compile("This is the", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        

        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("matches   = " + matcher.matches());
        
        pattern = Pattern.compile(".*http://.*");

        System.out.println("matches   = " + matcher.matches());
        
        
        pattern = Pattern.compile("is");
        Matcher matcher2 = pattern.matcher(text);

        int count = 0;
        while(matcher2.find()) {
            count++;
            int start = matcher2.start();
            int end = matcher2.end();
            String newSubstring = text.substring(start, end);
            System.out.println("found: " + count + " : " + 
                   newSubstring +  ":" + start + "," + end);
        }
        
        // By calling reset() the matching will start from the beginning of the text again.
        // reset(CharSequence) makes the Matcher search with CharSequence passed as parameter, instead
        // of the CharSequence the Matcher was originally created with.
        
        text    =
                  "John writes about this, and John Doe writes about that," +
                          " and John Wayne writes about everything."
                ;


        // ? means "match as few characters as possible". It stops at the first space; without ? the matching would stop at the last space, before the word "everything"
        // The group with number 0 is always the whole regular expression (group(1) + group(2) + next groups...
        //To get access to a group marked by parentheses you should start with group numbers 1.
        // both groups must be matched here
        pattern = Pattern.compile("(John) (.+?) ");
        Matcher matcher3 = pattern.matcher(text);

        while(matcher3.find()) {
            System.out.println("found: " + matcher3.group(0) + " |||| " +  
            matcher3.group(1) + " " + matcher3.group(2));
        }

// more: http://tutorials.jenkov.com/java-regex/matcher.html

       
    }
}
