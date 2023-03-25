import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Lamp> lamps = new ArrayList<>();
        lamps.add(new Lamp(100));
        lamps.add(new Lamp(120));
        lamps.add(new Lamp(50));
        lamps.add(new Lamp(30));
        lamps.add(new Lamp(20));

        Collections.sort(lamps);

        for (Lamp lamp : lamps) {
            System.out.println(lamp);
        }

        Lamp lamp = new Lamp(100);
        lamp.setType(Lamp.Type.LUMINESCENT);

        TreeSet<LightingDevice> lightingDevices = new TreeSet<>(new Comparator<LightingDevice>() {
            @Override
            public int compare(LightingDevice o1, LightingDevice o2) {
                return Integer.compare(o1.getPower(), o2.getPower());
            }
        });

        LightingDevice device = new LightingDevice(400) {
            @Override
            public double getEnergyConsumption() {
                return power * brightness;
            }
        };
    }
}
