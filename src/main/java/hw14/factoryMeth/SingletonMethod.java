package hw14.factoryMeth;

import hw14.factoryMeth.patterns.Pattern;

public class SingletonMethod implements AbstractMethod {
    @Override
    public Pattern createPattern() {
        return new Singleton();
    }
}
