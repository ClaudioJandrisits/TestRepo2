import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valli on 23.12.2016.
 */
public class SerialCircuitTest {

    @Test
    public void testSerialCircuits() {
        assertEquals("(10 Ω) = 10 Ω (Anzahl der Widerstände:  1)", new SerialCircuit(new Resistor(10)).toString());
        assertEquals("(15 Ω + 17 Ω + 2 Ω) = 34 Ω (Anzahl der Widerstände:  3)", new SerialCircuit(new Resistor(15), new Resistor(17), new Resistor(2)).toString());
    }

    @Test
    public void testToString(){
        assertEquals("(10 Ω + 20 Ω) = 30 Ω (Anzahl der Widerstände:  2)", new SerialCircuit(new Resistor(10), new Resistor(20)).toString());
        assertEquals("(15 Ω + 17 Ω) = 32 Ω (Anzahl der Widerstände:  2)", new SerialCircuit(new Resistor(15), new Resistor(17)).toString());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        Resistor r1 = new Resistor(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnotherException() {
        Resistor r1 = new Resistor(-91274378);
    }

}