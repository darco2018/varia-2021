package org.design_patterns.factory_method;

import org.design_patterns.factory_method.pizza.AmericanMargharitaPizza;
import org.design_patterns.factory_method.pizza.AmericanSeaFoodPizza;
import org.design_patterns.factory_method.pizza.Product;

public class AmericanFactory extends Pizzeria {

    @Override
    public Product getProductFromSubclassedFactory(String type) {

        if (type.equalsIgnoreCase("Margharita")) {
            return new AmericanMargharitaPizza();
        } else if (type.equalsIgnoreCase("Seafood")) {
            return new AmericanSeaFoodPizza();
        }
        return null;
    }
}
