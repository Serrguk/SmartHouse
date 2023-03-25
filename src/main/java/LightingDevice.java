import Interfaces.ElectricDevice;

public abstract class LightingDevice implements ElectricDevice, Comparable <LightingDevice>{
    public static final double MAX_BRIGHTNESS = 1D;
    public static final double MIN_BRIGHTNESS = 0D;

    protected final int power;
    protected double brightness;


    @Override
    public boolean isSwitchedOn() {
        return brightness > 0;
    }

    @Override
    public void switchOn() {
        brightness = MAX_BRIGHTNESS;
    }

    @Override
    public void switchOff() {
        brightness = MIN_BRIGHTNESS;
    }

    public LightingDevice(int power) {
        this.power = power;
    }

    public void setBrightness(double level) {
        if (level < MIN_BRIGHTNESS) {
            brightness = MIN_BRIGHTNESS;
        } else brightness = Math.min(level, MAX_BRIGHTNESS);
    }

    public double getBrightness() {
        return brightness;
    }

    public int getPower() {
        return power;
    }

    public void changeBrightness(double rate) {
        double changed = brightness + brightness * rate;
        setBrightness(changed);
    }

    @Override
    public int compareTo(LightingDevice o) {
        return Integer.compare(power, ((LightingDevice) o).power);
    }

    @Override
    public String toString() {
        return getClass().getName() + " with power " + power;
    }
}

