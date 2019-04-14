package hw14.abstractFactory.factories;

import hw14.abstractFactory.individs.canFly.FlyAble;
import hw14.abstractFactory.individs.canFly.RoboFly;
import hw14.abstractFactory.individs.canRun.RoboRun;
import hw14.abstractFactory.individs.canRun.RunAble;
import hw14.abstractFactory.individs.canWork.RoboWorker;
import hw14.abstractFactory.individs.canWork.WorkAble;

public class RobotFactory implements AbstractFactory {
    @Override
    public FlyAble getFlyer() {
        return new RoboFly();
    }

    @Override
    public RunAble getRunner() {
        return new RoboRun();
    }

    @Override
    public WorkAble getWorker() {
        return new RoboWorker();
    }
}
