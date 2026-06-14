import java.util.List;

public class PathResult {
    private List<String> path;
    private int distance;

    public PathResult(List<String> path, int distance) {
        this.path = path;
        this.distance = distance;
    }

    public List<String> getPath() {
        return path;
    }

    public int getDistance() {
        return distance;
    }
}