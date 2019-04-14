package hw14.abstractFactory.factories;

import hw14.abstractFactory.individs.canFly.FlyAble;
import hw14.abstractFactory.individs.canRun.PeopleRunner;
import hw14.abstractFactory.individs.canRun.RunAble;
import hw14.abstractFactory.individs.canWork.PeopleWorker;
import hw14.abstractFactory.individs.canWork.WorkAble;

public class PeopleFactory implements AbstractFactory {
    @Override
    public FlyAble getFlyer() {
        return null;
    }

    @Override
    public RunAble getRunner() {
        return new PeopleRunner();
    }

    @Override
    public WorkAble getWorker() {
        return new PeopleWorker();
    }
}
