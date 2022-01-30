package org.design_patterns.factory_method;

import org.design_patterns.factory_method.pizza.*;

public class ItalianFactory extends Pizzeria {

    @Override
    public Product getProductFromSubclassedFactory(String type) {

        if (type.equalsIgnoreCase("Margharita")) {
            return new ItalianMargharitaPizza();
        } else if (type.equalsIgnoreCase("Seafood")) {
            return new ItalianSeaFoodPizza();
        }
        return null;
    }
}
