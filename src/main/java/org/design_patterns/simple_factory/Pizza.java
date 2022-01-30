package org.design_patterns.simple_factory;

public interface Pizza {

    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void pack();
}
