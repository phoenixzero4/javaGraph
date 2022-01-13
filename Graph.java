import java.util.List;

public interface Graph<V> {

	public int getSize(); // number of vertices

	public java.util.List<V> getVertices(); // return vertices

	public V getVertex(int index); // return object for given index

	public int getIndex(V v);

	public List<Integer> getNeighbors(int index); // return neighbors

	public int getDegree(int v); // return degree

	public void printEdges();

	public void clear();

	public boolean addVertex(V vertex);

	public boolean addEdge(int u, int v);

	public AbstractGraph<V>.Tree dfs(int v);

	public AbstractGraph<V>.Tree bfs(int v);

}
