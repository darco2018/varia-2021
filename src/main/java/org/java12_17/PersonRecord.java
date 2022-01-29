package org.java12_17;

public record PersonRecord(String name, int age) {

    public static void main(String[] args) {
        PersonRecord per = new PersonRecord("John", 34);
        per.age();
    }
}