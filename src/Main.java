import java.util.Scanner;

public class Main {
    private static CityManager cityManager = new CityManager();
    private static LocationTree locationTree = new LocationTree();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations (using tree)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addLocation();
                        break;
                    case 2:
                        removeLocation();
                        break;
                    case 3:
                        addRoad();
                        break;
                    case 4:
                        removeRoad();
                        break;
                    case 5:
                        displayConnections();
                        break;
                    case 6:
                        displayLocationsTree();
                        break;
                    case 7:
                        System.out.println("Exiting... Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter 1-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addLocation() {
        System.out.print("Enter location name: ");
        String location = scanner.nextLine().trim();

        if (location.isEmpty()) {
            System.out.println("Location name cannot be empty!");
            return;
        }

        cityManager.addLocation(location);
        locationTree.insert(location);
    }

    private static void removeLocation() {
        System.out.print("Enter location name to remove: ");
        String location = scanner.nextLine().trim();
        cityManager.removeLocation(location);
        locationTree.remove(location); // Also remove from the location tree
    }

    private static void addRoad() {
        System.out.print("Enter first location: ");
        String from = scanner.nextLine().trim();
        System.out.print("Enter second location: ");
        String to = scanner.nextLine().trim();
        System.out.print("Enter distance (km): ");

        try {
            int distance = Integer.parseInt(scanner.nextLine());
            cityManager.addRoad(from, to, distance);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for distance!");
        }
    }

    private static void removeRoad() {
        System.out.print("Enter first location: ");
        String from = scanner.nextLine().trim();
        System.out.print("Enter second location: ");
        String to = scanner.nextLine().trim();
        cityManager.removeRoad(from, to);
    }

    private static void displayConnections() {
        System.out.println("\n--- All Connections ---");
        cityManager.displayConnections();
    }

    private static void displayLocationsTree() {
        locationTree.displayLocations();
    }
}
