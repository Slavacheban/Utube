package HW14.abstractFactory.factories;

import HW14.abstractFactory.individs.canFly.FlyAble;
import HW14.abstractFactory.individs.canFly.RoboFly;
import HW14.abstractFactory.individs.canRun.RoboRun;
import HW14.abstractFactory.individs.canRun.RunAble;
import HW14.abstractFactory.individs.canWork.RoboWorker;
import HW14.abstractFactory.individs.canWork.WorkAble;

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
