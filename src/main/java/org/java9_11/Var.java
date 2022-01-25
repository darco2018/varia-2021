package org.java9_11;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class Var {

    //var name = "Darek"; not a local variable

    /*keyword var which optionally replaces the type information when declaring
    local variables (local means variable declarations inside method bodies).*/
    public static void main(String[] args) {

        var company = "Codete"; // infers String
        var characters = company.toCharArray(); // infers char[]
        var letters = List.of("a", "b", "c");
        for (var l : letters) {
            System.out.print(l + " ");
        }

        Predicate<String> predicate = (@Nullable var a) -> true;

        // So we can say that polymorphic behavior does not work with the var keyword.


        //var foo; // cannot infere type withoput initializer
        // var ints = {0, 1, 2}; // new int[]{0, 1, 2};
        //var appendSpace = a -> a + " "; // Lambda requires an explicit target type

        /*  var nothing = null;
            var lambda = () -> System.out.println("Pity!");
            var method = this::someMethod;*/
    }

    /* doesn't compile
    private var getFoo() {  (var fileList) not possible either
        return "foo";
    }
    */

/*
    var users = new ArrayList<User>(); // type resolved: ArrayList<User>
    users = new LinkedList<>(); // error
    */
}
