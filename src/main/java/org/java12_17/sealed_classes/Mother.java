package org.java12_17.sealed_classes;

// The permits  list can be omitted if the subclasses (or interfaces) are located inside the same file:
public sealed class Mother {

    final class Daughter extends Mother {

    }
    final class Son extends Mother {

    }
}
