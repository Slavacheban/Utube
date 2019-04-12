package HW14.factoryMeth;

import HW14.factoryMeth.patterns.Pattern;
import HW14.factoryMeth.patterns.Singleton;

public class SingletonMethod implements AbstractMethod {
    @Override
    public Pattern createPattern() {
        return new Singleton();
    }
}
