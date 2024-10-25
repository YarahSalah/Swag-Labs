package enums;

public enum SortBy
{
    A_Z(0, "A to Z", "name"),
    Z_A(1, "Z to A", "-name"),
    LOW_TO_HIGH(2, "Price (low to high))", "lohi"),
    HIGH_TO_LOW(3,"Price (high to low)","hilo");

    private final int index;
    private final String name;
    private final String value;

    SortBy(final int index, final String name, final String value)
    {
        this.index = index;
        this.name = name;
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public int getIndex()
    {
        return index;
    }

    public String getName()
    {
        return name;
    }
}
