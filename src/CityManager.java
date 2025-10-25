public class CityManager {
    private Graph cityGraph;

    public CityManager() {
        cityGraph = new Graph();
    }

    public void addLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location name cannot be empty");
        }
        if (cityGraph.locationExists(location)) {
            throw new IllegalArgumentException("Location already exists: " + location);
        }
        cityGraph.addLocation(location);
    }

    public void removeLocation(String location) {
        if (!cityGraph.locationExists(location)) {
            throw new IllegalArgumentException("Location does not exist: " + location);
        }
        cityGraph.removeLocation(location);
    }

    public void addRoad(String from, String to, int distance) {
        if (!cityGraph.locationExists(from) || !cityGraph.locationExists(to)) {
            throw new IllegalArgumentException("One or both locations do not exist");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }
        cityGraph.addRoad(from, to, distance);
    }

    public void removeRoad(String from, String to) {
        if (!cityGraph.roadExists(from, to)) {
            throw new IllegalArgumentException("Road does not exist between " + from + " and " + to);
        }
        cityGraph.removeRoad(from, to);
    }

    public void displayConnections() {
        cityGraph.displayConnections();
    }

    public void BFS(String startLocation) {
        cityGraph.BFS(startLocation);
    }

    public boolean locationExists(String location) {
        return cityGraph.locationExists(location);
    }
}