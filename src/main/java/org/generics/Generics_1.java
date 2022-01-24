package org.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class Generics_1 {

    public static void run_1(){
        System.out.println("------- double[] arr will not be promoted to Double[] ---------------");
        Double[] doubleArr = { 4.5, 6.7, 9.2}; //autoboxing
        printArray(doubleArr);
        double[] doubleArrExpectAutoboxing = { 4.5, 6.7, 9.2}; // will not work: refence type will not be autoboxed
        //printArray(doubleArrExpectAutoboxing);
    }
    private static <T> void printArray(T[] arr){
        for(T element : arr){
            System.out.println(element);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////

    public static void run_2(){
        System.out.println("------- upper-bound <T extends class,interface> ---------------");

        String str = "Bob";
        StringBuilder sb = new StringBuilder(" is ");
        StringBuffer sbuff = new StringBuffer("ok");

        printOnlyCharSequence(str);
        printOnlyCharSequence(sb);
        printOnlyCharSequence(sbuff);

        Integer num = 567;
        //printOnlyCharSequence(num); will NOT be printed
    }

    // EXAMPLE OF multiple bounds. Note &  instead of a comma!!!
    private static <T extends CharSequence & Comparable<T>> void printOnlyCharSequence(T text){
        IntStream stream = text.codePoints();
               stream.forEach(System.out::println);
        //System.out.println("abc".compareTo(text)); not compile: required T.compareTo(T);

    }

    ///////////////// WILDCARDS ///////////////////////////////////////////////////////////////////////
    /*?
    1. as a type parameter can only be used in methods. eg: printAll(MyList<? extends Serializable>)
    I cannot define classes with ? as type parameter.
    2. A wildcard (?) isn't a formal type parameter, but rather  a type argument.
    3. printAll(MyList<? extends Serializable>)
      printAll will compile only if it is passed a MyList with some generic type that is
      or implements Serializable.
      In this case it would accept a MyList<Serializable>, MyList<Integer>
    4. printAll(MyList<? super MyClass>
      it would accept MyList<MyClass>, e.g. MyList<MyParentClass>, or MyList<Object>.
      Can be useful when you want to accept a type that is compatible with T (so that T is-a that type)

    * */

    List<? extends Comparable> list2 = new ArrayList<String>();


    /////////////////////// WILDCARD WITH UPPER & LOWER BOUND/////////////////////////////////////////////////////////

    public static void run_3(){
        validateOverString(new ArrayList<Object>());//OK
        validateOverString(new ArrayList<CharSequence>());//OK
        validateOverString(new ArrayList<Comparable>());//OK - String implements it
        validateOverString(new ArrayList<Serializable>());//OK - String implements it
        // validateOverString(new ArrayList<Integer>());//compile-time Error Integer is not highr in hierarchy
        //validateOverString(new ArrayList<Runnable>()); // compile time error: Required type: Collection <? super String>
        //-----------------------------------------
        validateUnderString(new ArrayList<String>()); //OK
        // validateUnderString(new ArrayList<Object>());// compile-time Error
        // no class extends String

    }
    /* Upper-bound  (? extends Field) =  Field or subclass of Field.
       Lower-bound  (? super Field) = Field or superclass of Field.*/
    public static void validateOverString(Collection<? super String> collection){
        //Wild card with Lower bound -> string or SUPER-CLASS of String
    }

    public static void validateUnderString(Collection<? extends String> collection){
        //Wild card with Upper bound -> string or SUB-CLASS of String
    }

    /////////////////////// WILDCARD vs T - part 1/////////////////////////////////////////////////////////
    /*
    Both of following two method signatures are equivalent to each other.
    1. public static void validateTillStringType(Collection<?> collection){ }
    2. public static <T> void validateTillStringType(Collection<T> collection){ }

    Note that
    - T is upper-bound
    - with T you can declare return type & use it as a variable in the method body
    * */

    /////////////////////// WILDCARD vs T - part 2/////////////////////////////////////////////////////////

/* Suppose we have a method to copy elements at a destination from a given source.
In this case we need to make sure
that the source elements are compatible with destination elements

public static <T> void copy(List<T> dest, List<? extends T> src) { }
eg dest List<Number> , so src can be List<Integer> List<Double> List<Long>

If we want to avoid the wildcard, we can declare one more type variable for second argument
and apply bound in declaration place:

public static <T,V extends T> void copy(List<T> dest, List<V> src) { }
                 T is upper-bound

*/


}
