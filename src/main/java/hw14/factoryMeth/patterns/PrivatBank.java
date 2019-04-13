package hw14.factoryMeth.patterns;

public class PrivatBank implements Bank {
    @Override
    public void setMoney(double money) {
        System.out.println("added " + money + " monay");
    }

    @Override
    public void gatMoney(double money) {
        System.out.println("minused " + money + " money");
    }
}
