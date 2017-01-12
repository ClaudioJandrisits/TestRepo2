/**
 * Created by Franz Breunig on 29.11.16.
 */
public class Resistor extends Circuit {
    private double value;

    public Resistor(double value) {
        setValue(value);
    }

    protected void setValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("Widerstand < 0 ist nicht erlaubt (%g)", value));
        }
        this.value = value;
    }

    @Override
    public double getResistance() {
        return value;
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public String toSimpleString() {
        return toOhmString(value);
    }
}
