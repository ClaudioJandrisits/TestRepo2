/**
 * Created by Franz Breunig on 29.11.16.
 */
public abstract class Circuit {
    public abstract double getResistance();
    public abstract int getCount();

    public abstract String toSimpleString();

    @Override
    public String toString() {
        return String.format("%s = %s (Anzahl der Widerstände: % d)",
                toSimpleString(), toOhmString(getResistance()), getCount());
    }

    public static String toOhmString(double value) {
        if (value == 0)                                      return "0 \u2126";
        if (1000000000 * ((int)value / 1000000000) == value) return String.format("%d M\u2126", (int)value/1000000000);
        if (1000000    * ((int)value / 1000000)     == value) return String.format("%d M\u2126", (int)value/1000000);
        if (1000       * ((int)value / 1000)       == value) return String.format("%d k\u2126", (int)value/1000);
        if ((int)value                             == value) return String.format("%d \u2126",  (int)value);

        return String.format("%g \u2126", value);
    }
}
