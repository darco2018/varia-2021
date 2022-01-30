package org.design_patterns;

/* When to Use Singleton Design Pattern
- For resources that are expensive to create (like database connection objects)
- It's good practice to keep all loggers as Singletons which increases performance
- Classes which provide access to configuration settings for the application
- Classes that contain resources that are accessed in shared mode
*/
public class Singleton {

    private static Singleton singleton; // note: its static

    private Singleton() {
    }

    // synchronized can slow down app even 100 times
    public static synchronized Singleton getInstance() { // note: its static
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton; // return the existing instance, not NULL!!!
    }

}

// thread-safe
class DoubleLockingSingleton {

    private static DoubleLockingSingleton singleton; // note: its static

    private DoubleLockingSingleton() {
    }

    public static  DoubleLockingSingleton getInstance() {
        if (singleton == null) { // 1st lock
            synchronized(DoubleLockingSingleton.class){ // synchronized(......class) {  // code here }
                if (singleton == null) { // 2nd lock
                    singleton = new DoubleLockingSingleton();
                }
            }
        }

        return singleton; // return the existing instance, not NULL!!!
    }
}

class EagerSingleton {

    //eager initialization (done by JVM) removes need for synchronized
    private static EagerSingleton singleton_2 = new EagerSingleton();

    public static EagerSingleton getInstance_2() {
        return singleton_2;
    }
}

/* Here, we've created a static inner class that holds the instance of the Singleton class.
It creates the instance only when someone calls the getInstance() method and not when the outer class is loaded.

This is a widely used approach for a Singleton class as
it doesn’t require synchronization,
is thread safe,
enforces lazy initialization
and has comparatively less boilerplate.*/
class BaeldungSingleton  {
    private BaeldungSingleton() {}

    private static class SingletonHolder {
        public static final BaeldungSingleton instance = new BaeldungSingleton();
    }

    public static BaeldungSingleton getInstance() {
        return SingletonHolder.instance;
    }
}

