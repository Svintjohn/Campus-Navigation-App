public class BuildingInfo extends Building {
    private String description;
    private String directions; 

    // Constructor
    public BuildingInfo(String code, String name, String coordinates, String description, int floorCount, String directions) {
        super(code, name, coordinates, floorCount);
        this.description = description;
        this.directions = directions;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public String getDirections() {
        return directions;
    }

    // specific display method for BuildingInfo
    @Override
    public void displayInfo() {
        System.out.println("\nBuilding Code: " + getCode());
        System.out.println("Name: " + getName());
        System.out.println("Coordinates: " + getCoordinates());
        System.out.println("Description: " + description);
        System.out.println("Floors: " + getFloorCount());
        System.out.println("Directions: " + directions);
    }

    // Static method to find a building by code or name
    public static BuildingInfo findBuilding(BuildingInfo[] buildings, String query) {
        for (BuildingInfo b : buildings) { // search logic
            if (b.getCode().equalsIgnoreCase(query) || b.getName().toLowerCase().contains(query.toLowerCase())) {
                return b;
            }
        }
        return null; 
    }
}
