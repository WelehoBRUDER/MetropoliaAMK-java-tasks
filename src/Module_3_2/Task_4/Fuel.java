package Module_3_2.Task_4;

// Fuel is an enum because it simplifies the differences between types.
// Grouping all properties under one label helps with cohesion.
public enum Fuel {
    // These efficiencies are roughly based in reality (after one google search)
    GASOLINE(1, "Gasoline", "l per 100km"),
    DIESEL(1.25, "Diesel", "l per 100km"),
    ELECTRICITY(0.9, "Electricity", "kWh per 100km");

    public final double efficiency;
    public final String label;
    public final String mileageType;

    Fuel(double efficiency, String label, String mileageType) {
        this.efficiency = efficiency;
        this.label = label;
        this.mileageType = mileageType;
    }
}
