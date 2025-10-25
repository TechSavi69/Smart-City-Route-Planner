
import java.util.*;
// My Graph//
public class Graph {
    // Map to store locations as vertices and their adjacency lists with distances
    private Map<String, Map<String, Integer>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    public boolean addLocation(String location) {
        if (adj.containsKey(location))
            return false;
        adj.put(location, new HashMap<>());
        return true;
    }

    public boolean removeLocation(String location) {
        if (!adj.containsKey(location))
            return false;
        adj.remove(location);
        for (Map<String, Integer> m : adj.values()) {
            m.remove(location);
        }
        return true;
    }

    // addRoad with distance
    public boolean addRoad(String from, String to, int distance) {
        if (!adj.containsKey(from) || !adj.containsKey(to))
            return false;
        adj.get(from).put(to, distance);
        adj.get(to).put(from, distance); // undirected
        return true;
    }

    public boolean removeRoad(String from, String to) {
        if (!adj.containsKey(from) || !adj.containsKey(to))
            return false;
        adj.get(from).remove(to);
        adj.get(to).remove(from);
        return true;
    }

    public void displayConnections() {
        System.out.println("--- Connections between Locations ---");
        for (String u : adj.keySet()) {
            System.out.println(u + " -> " + adj.get(u));
        }
    }

    public Set<String> getAllLocations() {
        return adj.keySet();
    }

    public List<String> getNeighbors(String location) {
        if (!adj.containsKey(location))
            return new LinkedList<>();
        return new ArrayList<>(adj.get(location).keySet());
    }

    // Compatibility methods expected by CityManager
    public boolean locationExists(String location) {
        return adj.containsKey(location);
    }

    public boolean roadExists(String from, String to) {
        if (!adj.containsKey(from))
            return false;
        return adj.get(from).containsKey(to);
    }

    // BFS traversal printing visited nodes
    public void BFS(String startLocation) {
        if (!adj.containsKey(startLocation)) {
            System.out.println("Start location does not exist: " + startLocation);
            return;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(startLocation);
        visited.add(startLocation);
        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            String u = q.poll();
            System.out.print(u + " ");
            for (String v : adj.get(u).keySet()) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    q.add(v);
                }
            }
        }
        System.out.println();
    }

    // For completeness provide hasLocation alias
    public boolean hasLocation(String location) {
        return locationExists(location);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addLocation("A");
        g.addLocation("B");
        g.addRoad("A", "B", 5);
        g.displayConnections();
        g.BFS("A");
    }
}