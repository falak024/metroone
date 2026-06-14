import java.util.*;

public class MetroGraph {

    private HashMap<String, HashMap<String, Integer>> graph;
    private HashMap<String, String> stationLine = new HashMap<>();

public void setStationLine(String station, String line) {
    stationLine.put(station, line);
}

public String getStationLine(String station) {
    return stationLine.getOrDefault(station, "Unknown");
}
    public MetroGraph() {
        graph = new HashMap<>();
    }

    // Add station
    public void addStation(String station) {
        graph.putIfAbsent(station, new HashMap<>());
    }

    // Add connection between stations
    public void addEdge(String source, String destination, int distance) {
        graph.get(source).put(destination, distance);
        graph.get(destination).put(source, distance);
    }
    public PathResult findShortestPath(String source, String destination) {

    HashMap<String, Integer> distance = new HashMap<>();
    HashMap<String, String> previous = new HashMap<>();
    PriorityQueue<String> pq = new PriorityQueue<>(
            Comparator.comparingInt(distance::get)
    );

    // Initialize distances
    for (String station : graph.keySet()) {
        distance.put(station, Integer.MAX_VALUE);
    }

    distance.put(source, 0);
    pq.add(source);

    while (!pq.isEmpty()) {

        String current = pq.poll();

        if (current.equals(destination)) {
            break;
        }

        for (Map.Entry<String, Integer> neighbour :
                graph.get(current).entrySet()) {

            String nextStation = neighbour.getKey();
            int edgeDistance = neighbour.getValue();

            int newDistance =
                    distance.get(current) + edgeDistance;

            if (newDistance < distance.get(nextStation)) {

                distance.put(nextStation, newDistance);

                previous.put(nextStation, current);

                pq.add(nextStation);
            }
        }
    }

    // Build path
    List<String> path = new ArrayList<>();

    String current = destination;

    while (current != null) {
        path.add(0, current);
        current = previous.get(current);
    }

    return new PathResult(
            path,
            distance.get(destination)
    );
}
    public HashMap<String, HashMap<String, Integer>> getGraph() {
        return graph;
    }
}