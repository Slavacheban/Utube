package HW14.factoryMeth;

import HW14.factoryMeth.patterns.Builder;
import HW14.factoryMeth.patterns.Pattern;

public class BuildMetod implements AbstractMethod {
    @Override
    public Pattern createPattern() {
        return new Builder();
    }
}
