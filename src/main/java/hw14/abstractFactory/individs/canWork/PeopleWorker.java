package hw14.abstractFactory.individs.canWork;

public class PeopleWorker implements WorkAble {
    @Override
    public void work() {
        System.out.println("I am working in factory");
    }
}
