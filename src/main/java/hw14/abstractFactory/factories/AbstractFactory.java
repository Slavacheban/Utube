package hw14.abstractFactory.factories;

import hw14.abstractFactory.individs.canFly.FlyAble;
import hw14.abstractFactory.individs.canRun.RunAble;
import hw14.abstractFactory.individs.canWork.WorkAble;

public interface AbstractFactory {
    FlyAble getFlyer();
    RunAble getRunner();
    WorkAble getWorker();
}
