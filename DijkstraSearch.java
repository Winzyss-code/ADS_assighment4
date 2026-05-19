import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo; 
    private final PriorityQueue<VertexNode<V>> pq;

    public DijkstraSearch(WeightedGraph<V> graph, V sourceData) {
        super(graph.getVertex(sourceData));
        this.distTo = new HashMap<>();
        this.pq = new PriorityQueue<>(Comparator.comparingDouble(node -> node.distance));
        
        if (this.source != null) {
            dijkstra(graph);
        }
    }

    private void dijkstra(WeightedGraph<V> graph) {
        for (Vertex<V> vertex : graph.getVertices().values()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);

        pq.add(new VertexNode<>(source, 0.0));

        while (!pq.isEmpty()) {
            VertexNode<V> current = pq.poll();
            Vertex<V> u = current.vertex;

            if (current.distance > distTo.get(u)) continue;

            for (Map.Entry<Vertex<V>, Double> entry : u.getAdjacentVertices().entrySet()) {
                Vertex<V> v = entry.getKey();
                double weight = entry.getValue();

                if (distTo.get(u) + weight < distTo.get(v)) {
                    distTo.put(v, distTo.get(u) + weight);
                    edgeTo.put(v, u);
                    pq.add(new VertexNode<>(v, distTo.get(v)));
                }
            }
        }
    }

    public double getDistanceTo(Vertex<V> target) {
        return distTo.getOrDefault(target, Double.POSITIVE_INFINITY);
    }

    private static class VertexNode<V> {
        Vertex<V> vertex;
        double distance;

        VertexNode(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}