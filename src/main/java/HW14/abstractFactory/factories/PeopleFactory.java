package HW14.abstractFactory.factories;

import HW14.abstractFactory.individs.canFly.FlyAble;
import HW14.abstractFactory.individs.canRun.PeopleRunner;
import HW14.abstractFactory.individs.canRun.RunAble;
import HW14.abstractFactory.individs.canWork.PeopleWorker;
import HW14.abstractFactory.individs.canWork.WorkAble;

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
