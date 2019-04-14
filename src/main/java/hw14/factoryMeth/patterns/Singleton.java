package hw14.factoryMeth.patterns;

public class Singleton implements Pattern {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
