public class Building {
    private String code;
    private String name;
    private String coordinates;
    private int floorCount;

    // Constructor and initialization
    public Building(String code, String name, String coordinates, int floorCount) {
        this.code = code;
        this.name = name;
        this.coordinates = coordinates;
        this.floorCount = floorCount;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public int getFloorCount() {
        return floorCount;
    }

    // This is for displaying basic building info; can be overridden
    public void displayInfo() {
        System.out.println("Building Code: " + code);
        System.out.println("Name: " + name);
        System.out.println("Coordinates: " + coordinates);
        System.out.println("Floors: " + floorCount);
    }
}
