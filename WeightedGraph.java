import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private final Map<V, Vertex<V>> vertices;
    private final boolean undirected;

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean undirected) {
        this.vertices = new HashMap<>();
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        addVertex(source);
        addVertex(dest);

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        sourceVertex.addAdjacentVertex(destVertex, weight);
        if (undirected) {
            destVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}