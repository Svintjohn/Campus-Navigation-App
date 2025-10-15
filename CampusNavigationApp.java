import java.util.Scanner;

public class CampusNavigationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Holy Angel University Campus Navigation App ===");

        System.out.print("Enter your name(Last name, First Name): ");
        String userName = scanner.nextLine();

        System.out.print("Enter your role (Student / Faculty / Visitor): ");
        String userRole = scanner.nextLine();

        User user = new User(userName, userRole);
        user.displayUser();

        // Building dataset
        BuildingInfo[] buildings = {
            new BuildingInfo("PDC", "Plaza De Corazon Building (Red Bldg.)", "14.9690,120.6810", "Human Resource & Dormitory", 7, "From main gate, walk straight ahead and turn right after St. Martha Hall."),
            new BuildingInfo("SMT", "St. Martha Hall Building", "14.9685,120.6805", "Admissions Office & Testing Center", 6, "From main gate, walk straight and it's on your left beside the Red Building."),
            new BuildingInfo("SFJ", "San Francisco De Javier Building", "14.9686,120.6809", "President's Office / University Library", 4, "From St. Martha Hall, continue forward and turn left at the next pathway."),
            new BuildingInfo("STL", "St. Therese of Lisieux Building", "14.9687,120.6813", "Hospitality & Tourism Management", 2, "From the chapel, go straight and the building is beside Yellow Food Court."),
            new BuildingInfo("YFC", "Yellow Food Court", "14.9680,120.6808", "Food Court / Cafeteria", 1, "From St. Martha Hall, walk straight and follow the smell of food - it's on the left."),
            new BuildingInfo("SGH", "St. Gabriel Hall Building", "14.9678,120.6806", "Faculty & Classrooms", 2, "From the Red Building, go straight and it's beside St. Raphael Hall."),
            new BuildingInfo("SRH", "St. Raphael Hall Building", "14.9679,120.6805", "Lecture Rooms / Student Lounge", 2, "From St. Gabriel Hall, walk a few steps left."),
            new BuildingInfo("SMH", "St. Michael Hall Building", "14.9680,120.6804", "Accounting Department", 2, "From the library, turn right and walk 50 meters."),
            new BuildingInfo("GGN", "Geronim G. Nepomuceno Building", "14.9689,120.6814", "Principal's Office / High School Library", 10, "From the main gate, go straight, turn right at the plaza."),
            new BuildingInfo("PGN", "Peter G. Nepomuceno Building", "14.9690,120.6816", "Scholarship & Business Dean's Office", 9, "Located beside the Red Building."),
            new BuildingInfo("DJDN", "Don Juan D. Nepomuceno Building (Main)", "14.9691,120.6818", "Registrar / Finance / CKS Office", 2, "From plaza, go straight and turn right after the library."),
            new BuildingInfo("APS", "Archbishop Pedro Santos Building", "14.9692,120.6820", "General Education", 3, "From chapel, go straight until you reach the next junction."),
            new BuildingInfo("MGN", "Mamerto G. Nepomuceno Building", "14.9693,120.6822", "Nursing & Medical Sciences", 5, "From the main gate, go straight, then left after St. Joseph Hall."),
            new BuildingInfo("CHG", "Chapel of the Holy Guardian Angel", "14.9694,120.6823", "Chapel", 1, "Center of the campus - you can't miss it."),
            new BuildingInfo("SJN", "Sister Josefina Nepomuceno Formation Center", "14.9695,120.6825", "Formation & Retreat Center", 2, "Behind the chapel, straight ahead past MGN."),
            new BuildingInfo("SJH", "St. Joseph Hall Building", "14.9696,120.6827", "Education, Arts, & Computing Dean's Office", 8, "Next to the chapel on your right."),
            new BuildingInfo("SH", "Sacred Heart Building", "14.9697,120.6829", "Engineering & Architecture Dean's Office", 2, "Across from St. Joseph Hall."),
            new BuildingInfo("CC", "Covered Court", "14.9698,120.6830", "Sports & Events", 1, "At the far end near the gymnasium."),
            new BuildingInfo("IHG", "Immaculate Heart Gymnasium", "14.9699,120.6832", "Physical Education / Events", 2, "Past the covered court, straight ahead."),
            new BuildingInfo("IHGA", "Immaculate Heart Gymnasium Annex", "14.9700,120.6833", "Gym Annex / PE Offices", 1, "Right beside the main gymnasium.")
        };

        System.out.println("\nType a building code or name to search, or 'exit' to quit.");

        // Handle user input and search
        while (true) {
            System.out.print("\nSearch: ");
            String query = scanner.nextLine().trim();

            if (query.equalsIgnoreCase("exit") || query.isEmpty()) {
                System.out.println("\nThank you for using the Campus Navigation App!");
                System.out.println("Goodbye, " + user.getName() + "!");
                break;
            }

            // Try catch for any unexpected errors during search
            try {
                BuildingInfo found = BuildingInfo.findBuilding(buildings, query);
                if (found != null) {
                    found.displayInfo();
                } else {
                    System.out.println("Building not found. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while searching: " + e.getMessage());
            }

            // Ask if the user wants to search again
            String back;
            while (true) {
                System.out.print("\nDo you want to search again? (yes/no): ");
                back = scanner.nextLine().trim().toLowerCase();

                if (back.equals("yes") || back.equals("no")) {
                    break; 
                } else {
                    System.out.println("? Invalid input! Please type 'yes' or 'no'.");
                }
            }

            if (back.equals("no")) {
                System.out.println("\nThank you for using the Campus Navigation App!");
                System.out.println("Goodbye, " + user.getName() + "!");
                break;
            }
        }

        scanner.close();
    }
}
