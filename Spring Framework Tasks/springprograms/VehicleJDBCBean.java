package springprograms;

public class VehicleJDBCBean {
	private int id;
    private String model;
    private String color;
    private int year;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Vehicle [ID=" + id + ", Model=" + model + ", Color=" + color + ", Year=" + year + "]";

}

}
