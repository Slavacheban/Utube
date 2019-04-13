package hw14.factoryMeth;

import hw14.factoryMeth.patterns.BuilderCompImpl;
import hw14.factoryMeth.patterns.Pattern;

public class BuildMetod implements AbstractMethod {
    @Override
    public Pattern createPattern() {
        return new BuilderCompImpl();
    }
}
