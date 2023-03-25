import Interfaces.ElectricDevice;

import java.util.ArrayList;

public class SmartHouse {
    private final ArrayList<ElectricDevice> devices;

    public SmartHouse() {
        devices = new ArrayList<>();
        initLightingDevices();
    }

    public void switchOffAllDevices() {
        devices.forEach(ElectricDevice::switchOff);
    }

    public double getEnergyConsumption() {
        double sum = 0;
        for (ElectricDevice electricDevice : devices) {
            sum += electricDevice.getEnergyConsumption();
        }
        return sum;
    }

    public void switchOffAllLight() {
        for (ElectricDevice electricDevice : devices) {
            if (electricDevice instanceof LightingDevice) {
                electricDevice.switchOff();
            }
        }
    }

    private void initLightingDevices() {
        devices.add(new Lamp(100));
        devices.add(new Lamp(60));
        devices.add(new Lamp(40));
        devices.add(new Chandelier(100, 4));
        devices.add(new Chandelier(400, 10));
        devices.add(new Chandelier(250, 5));
        devices.add(new Chandelier(120, 3));
    }
}
