package cairomonorail;
public enum DegreeClassEnum {
    FirstClass(0.5),
    Business(0.25),
    Economy(0.0);

    private final double value;

    DegreeClassEnum(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
