import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Franz Breunig on 29.11.16.
 */
public class SerialCircuit extends Circuit{
    private Circuit circuits[];


    public SerialCircuit(Circuit... circuits) {
        this.circuits = circuits;
    }

    public SerialCircuit(Object... circuits) {
        this.circuits = new Circuit[circuits.length];

        for (int i=0; i<circuits.length; i++) {
            this.circuits[i]
                    = circuits[i] instanceof Number
            ? new Resistor(((Number)circuits[i]).doubleValue())
            : (Circuit) circuits[i];
        }
    }

    @Override
    public double getResistance() {
        double s = 0;

        for (Circuit circuit: circuits) {
            s += circuit.getResistance();
        }

        return s;
    }

    @Override
    public int getCount() {
        //return Arrays.stream(circuits).mapToInt(circuit -> circuit.getCount()).sum();
        int counter = 0;

        for (Circuit circuit: circuits) {
            counter += circuit.getCount();
        }

        return counter;
    }

    @Override
    public String toSimpleString() {
        if (circuits.length == 0) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();

        for (Circuit circuit: circuits) {
            b.append(" + ").append(circuit.toSimpleString());
        }
        return "(" + b.substring(3) + ")";
    }
}
