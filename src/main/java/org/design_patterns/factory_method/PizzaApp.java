package org.design_patterns.factory_method;

import org.design_patterns.factory_method.pizza.Product;


/* When to Use Factory Method Design Pattern
the Factory Method design pattern is used to create objects related to a single family.
the Abstract Factory Design Pattern is used to create families of related or dependent objects.

- When the implementation of an interface or an abstract class (here: Product.class) is expected to change frequently
- When the current implementation cannot comfortably accommodate new change
When the initialization process is relatively simple, and the constructor only requires a handful of parameters*/
public class PizzaApp {

    public static void main(String[] args) {
        Pizzeria pizzeria = new AmericanFactory(); // we specify our choice to a subgroup of products (only American)
        Product product = pizzeria.doStuffOnProduct("Margharita"); // we further specify our choice to a prodcut from this subgroup
        // actually, I guess it doesn't have to return a product = enough if
    }


}
