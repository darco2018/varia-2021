package org.design_patterns.simple_factory;

public class PizzaHouse {

    private SimplePizzaFactory factory;

    public PizzaHouse(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public void prepareFreshPizza(){

        // with factory.getInstance("serowa"):
        //  - we avoid new keyword
        //  - we pushed the creation to a separate class, which can now have many clients, not just this one

        // BUT, this can also be implemented as a STATIC method (static factory) - the drawback is: you can't
        // use inheritance nor you can't use the constructor and static methods are mixed with other methods
        // The advantages of a static method are:
        //      - you can have many getInstance methods, each with a different set of args
        //      - and a more verbose method name, easy to understand
        //      - you can have many objects with the same type & number of args eg (String s1, String s2) - with constructor
        //                you cant have the same signatures
        //      - you can return an EXISTING object (eg cached) rather than create a new one
        // Naming conventions of static facotry:
        // Date.from(instant) - conversion
        // EnumSet.of(JACK, QUEEN, KING) - aggregation
        // instance() , getInstance(options)
        // newInstance() - must be NEW obj each time
        // type(), getType(), newType() - when factory is in a different class: List list = Collections.list(enum);


        // Since java a static method can be out in an interface. Before java 8 it was put in -s methods: CollectionS, PileS, etc.
        Pizza pizza = factory.getInstance("serowa");
        // polimorhically calling implementations
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.pack();
        // you can also return this pizza

    }
}
