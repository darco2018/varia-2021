package org.java9_11;

public interface InterfaceWithPrivateMethods {

    private static String staticPrivate() {
        return "static private";
    }

    // -----------------------------------------

    // Interfaces can have private methods, which can be used to split lengthy default methods:
    private String instancePrivate() {
        return "instance private";
    }

    default void check() {
        String result = staticPrivate();
        InterfaceWithPrivateMethods anonymClassInstance = new InterfaceWithPrivateMethods() {
            // anonymous class
        };
        result = anonymClassInstance.instancePrivate();
    }
}
