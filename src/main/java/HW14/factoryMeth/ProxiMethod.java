package HW14.factoryMeth;

import HW14.factoryMeth.patterns.Pattern;
import HW14.factoryMeth.patterns.Proxy;

public class ProxiMethod implements AbstractMethod {
    @Override
    public Pattern createPattern() {
        return new Proxy();
    }
}
