package org.design_patterns.factory_method;

import org.design_patterns.factory_method.pizza.Product;

// PizzeriaFactory doesn't know what Product it is working on = the factory lets subclasses decide what product will be used
// compared to simple Factory we have more control over the roznorodnosc tworzonych obietow
public abstract class PizzeriaFactory {

    // this class can have all methods to work on a product except the factory method

    public Product doStuffOnProduct(String productType){
        Product product = this.getProductFromSubclassedFactory(productType);
        System.out.println("We are working on " + product);
        System.out.println("We can call product.methods() here");

        return product;
    }

    public abstract Product getProductFromSubclassedFactory(String type);
    // implementing method could actually create THE same product but witha different set of params

}
