package org.java12_17.sealed_classes;

// A sealed class explicitly lists the permitted direct subclasses.
// Other classes must not extend from this class.
// Likewise, a sealed interface explicitly lists the permitted direct subinterfaces and implementing classes:
public sealed class Parent permits ChildA, ChildB {

    // The classes or interfaces in the permits the list must be located in the same package
    // (or in the same module if the parent is in a named module).

    public static void main(String[] args) {
        /*A significant benefit of sealed classes is that they allow for exhaustive pattern matching checking without
        the need for a CATCH for all non-covered cases. For example, using our defined classes, we can have logic
        to cover all possible subclasses of Parent:*/

        Parent j = new ChildA(); // some Parent instance

        if (j instanceof ChildA a) {
            // do logic
        } else if (j instanceof ChildB b) {
            // do logic
        }
        // We don't need an else block as the sealed classes only allow the two possible subtypes of Monkey and Snake.
    }
}
