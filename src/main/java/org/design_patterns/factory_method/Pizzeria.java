package org.design_patterns.factory_method;

import org.design_patterns.factory_method.pizza.Product;

// Pizzeria doesn't know what Product it is working on
public abstract class Pizzeria {

    public Product doStuffOnProduct(String productType){
        Product product = this.getProductFromSubclassedFactory(productType);
        System.out.println("We are working on " + product);
        System.out.println("We can call product.methods() here");

        return product;
    }

    public abstract Product getProductFromSubclassedFactory(String type);

}
