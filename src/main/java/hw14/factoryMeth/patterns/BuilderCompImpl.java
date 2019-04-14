package hw14.factoryMeth.patterns;

public class BuilderCompImpl extends BuilderComp implements Pattern {
    @Override
    public void buildSystemBlock() {
        comp.setSystemBlock("Everest");
    }

    @Override
    public void buildDisplay() {
        comp.setDisplay("CRT");
    }

    @Override
    public void buildManipulators() {
        comp.setManipulators("mouse + keyboard");
    }
}
