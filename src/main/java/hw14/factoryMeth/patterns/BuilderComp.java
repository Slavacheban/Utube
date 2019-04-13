package hw14.factoryMeth.patterns;

public abstract class BuilderComp {
    protected Comp comp;

    public Comp getComp() {
        return comp;
    }

    public void createComp() {
        comp = new Comp();
    }

    public abstract void buildSystemBlock();
    public abstract void buildDisplay();
    public abstract void buildManipulators();
}
