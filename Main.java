public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 1200.0);
        graph.addEdge("Almaty", "Shymkent", 700.0);
        graph.addEdge("Shymkent", "Astana", 1400.0);
        graph.addEdge("Astana", "Aktobe", 1000.0);
        graph.addEdge("Shymkent", "Aktobe", 1500.0);

        System.out.println("--- Testing BFS Paths (Unweighted Hops) ---");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        Vertex<String> destination = graph.getVertex("Aktobe");
        
        System.out.print("BFS Path from Almaty to Aktobe: ");
        System.out.println(bfs.pathTo(destination));

        System.out.println("\n--- Testing Dijkstra Shortest Paths (Weighted) ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "Almaty");
        
        System.out.print("Dijkstra Path: ");
        System.out.println(dijkstra.pathTo(destination));
        System.out.println("Total distance: " + dijkstra.getDistanceTo(destination) + " km");
    }
}