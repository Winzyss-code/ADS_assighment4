import java.util.*;

public abstract class Search<V> {
    protected final Vertex<V> source;
    protected final Map<Vertex<V>, Vertex<V>> edgeTo; 
    public Search(Vertex<V> source) {
        this.source = source;
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> target) {
        return edgeTo.containsKey(target) || target.equals(source);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> target) {
        if (!hasPathTo(target)) return null;
        
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = target; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        return path;
    }
}