import java.util.*;

public class MetroGraph {

    private HashMap<String, HashMap<String, Edge>> graph;

    public MetroGraph() {
        graph = new HashMap<>();
    }

    public void addStation(String station) {
        graph.putIfAbsent(station, new HashMap<>());
    }

    public void addEdge(String source,
                        String destination,
                        int distance,
                        String line) {

        addStation(source);
        addStation(destination);

        graph.get(source).put(destination,
                new Edge(distance, line));

        graph.get(destination).put(source,
                new Edge(distance, line));
    }

    public PathResult findShortestPath(String source,
                                       String destination) {

        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, String> previous = new HashMap<>();

        PriorityQueue<String> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(distance::get));

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

            for (Map.Entry<String, Edge> neighbour :
                    graph.get(current).entrySet()) {

                String nextStation = neighbour.getKey();

                int edgeDistance =
                        neighbour.getValue().getDistance();

                int newDistance =
                        distance.get(current) + edgeDistance;

                if (newDistance < distance.get(nextStation)) {

                    distance.put(nextStation, newDistance);

                    previous.put(nextStation, current);

                    pq.add(nextStation);
                }
            }
        }

        if (distance.get(destination)
                == Integer.MAX_VALUE) {

            return new PathResult(
                    new ArrayList<>(),
                    Integer.MAX_VALUE
            );
        }

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

    public String getLine(String source,
                          String destination) {

        if (graph.containsKey(source)
                && graph.get(source)
                         .containsKey(destination)) {

            return graph.get(source)
                    .get(destination)
                    .getLine();
        }

        return "Unknown";
    }

    public HashMap<String,
            HashMap<String, Edge>> getGraph() {

        return graph;
    }
}