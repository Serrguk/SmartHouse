public class Chandelier extends LightingDevice {
    private static final int LAMP_BRIGHTNESS_STEPS = 2;
    private static final double CONSUMPTION_COEFF = 1.095;

    private final int lampCount;


    public Chandelier(int power, int lampCount) {
        super(power);
        this.lampCount = lampCount;
    }

    @Override
    public void setBrightness(double level) {
        double step = 1.0 / (lampCount * LAMP_BRIGHTNESS_STEPS);
        int stepsCount = (int) Math.round(level / step);
        super.setBrightness(stepsCount * step);
        class Controller {
            public Controller() {
                //connect
            }
            public void reset() {
                //some logic
            }
        }

        if (brightness == 0) {
            Controller controller = new Controller();
            controller.reset();
        }
    }

    @Override
    public double getEnergyConsumption() {
        return power * Math.pow(brightness, CONSUMPTION_COEFF);
    }
}
