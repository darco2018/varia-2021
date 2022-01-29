package org.java12_17.sealed_classes;

// sealed, non-sealed or final modifiers expected

/* Every subclass or interface in the permits the list must use exactly one of the following modifiers:

    final (disallows further extension; for subclasses only, since interfaces cannot be final)
    sealed (permits further, limited extension)
    non-sealed (permits unlimited extension again)


    It's important to note that any class that extends a sealed class must itself be declared sealed, non-sealed, or final.
     This ensures the class hierarchy remains finite and known by the compiler.

This finite and exhaustive hierarchy is one of the great benefits of using sealed classes.
*/
public non-sealed class ChildB extends Parent {
}
