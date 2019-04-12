package HW14.abstractFactory.factories;

import HW14.abstractFactory.individs.canFly.FlyAble;
import HW14.abstractFactory.individs.canRun.RunAble;
import HW14.abstractFactory.individs.canWork.WorkAble;

public interface AbstractFactory {
    FlyAble getFlyer();
    RunAble getRunner();
    WorkAble getWorker();
}
