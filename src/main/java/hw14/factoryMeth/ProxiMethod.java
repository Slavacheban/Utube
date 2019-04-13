package hw14.factoryMeth;

import hw14.factoryMeth.patterns.Pattern;
import hw14.factoryMeth.patterns.ProxyPrivateBank;

public class ProxiMethod implements AbstractMethod {
    @Override
    public Pattern createPattern() {
        return new ProxyPrivateBank();
    }
}
