/**
 * Created by Franz Breunig on 29.11.16.
 */
public class ParallelCircuit extends Circuit{
    private Circuit circuits[];


    public ParallelCircuit(Circuit... circuits) {
        this.circuits = circuits;
    }

    public ParallelCircuit(Object... circuits) {
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
        double g = 1;

        for (Circuit circuit: circuits) {
            g += 1/circuit.getResistance();
        }

        return 1/g;
    }

    @Override
    public int getCount() {
        int counter = 1;

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
            b.append(" | ").append(circuit.toSimpleString());
        }
        return "[" + b.substring(3) + "]";
    }
}
