package org.design_patterns.simple_factory;

public class SimplePizzaFactory {

    public Pizza getInstance(String pizzaType){

        Pizza pizza = null;

        if(pizzaType.equalsIgnoreCase("serowa")){
            pizza = new SerowaPizza();
        } else {
            pizza = new StandardPizza();
        };

        return pizza;

    }
}
