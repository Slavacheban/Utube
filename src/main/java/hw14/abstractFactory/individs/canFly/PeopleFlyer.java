package hw14.abstractFactory.individs.canFly;

public class PeopleFlyer implements FlyAble {
    @Override
    public void fly() {
        System.out.println("I am flying");
    }
}
