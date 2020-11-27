/* 
    Implementación clase 16nov 
    Adjacency Matrix and List
*/
import java.util.LinkedList;
import java.util.*;
public class graph {
    public int V; // numero de vertices
    public int[][] matrix;
    
    public graph(int V) {
        this.V = V;
        matrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; i < V; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void addConnection(int x, int y, int w) { 
        matrix[x][y] = w;     
    }
    public void removeConnection(int x, int y) { 
        matrix[x][y] = 0;
    }
    void BFS(int start) {
        boolean visited[] = new boolean[V];
        Queue<Integer> list = new LinkedList<Integer>();

        visited[start] = true;
        list.add(start);

        while(list.size() != 0) {
            int current = list.poll();
            System.out.println(current);

            for(int child = 0; child < V; child++) {
                // si los nodos no han sido visitados
                // y existe una conección
                if(!visited[child] && matrix[current][child] != 0) {
                    list.add(child); // se añaden
                    visited[child] = true;
                }
            }
        }
    }
    // es lo mismo pero con un stack
    // eso es conveniente...
    void DFS(int start) {
        boolean visited[] = new boolean[V];
        Stack<Integer> list = new Stack<>();

        visited[start] = true;
        list.push(start);

        while(list.size() != 0) {
            int current = list.pop();
            System.out.println(current);

            for(int child = 0; child < V; child++) {
                // si los nodos no han sido visitados
                // y existe una conección
                if(!visited[child] && matrix[current][child] != 0) {
                    list.push(child); // se añaden
                    visited[child] = true;
                }
            }
        }
    }
}
class Pair{
    int a,b;
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}
class graphList {
    public int V;
    public LinkedList<Integer> adj[];

    public graphList(int V) {
        this.V = V;

        adj = new LinkedList[V]; // array de listas
        // cada espacio del array será una lista
        // y la cantidad de espacios es la cantidad de vertices del grafo
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();      
    }
    // si se le quiere agregar weight 
    // se necesitaría una clase pair
    public void addConnection(int x, int y, int w) {
        adj[x].add(y); 
        //adj[y].add(x); //undirected graph
    }
    public void removeConnection(int x, int y) {
        int index = 0;
        Iterator<Integer> it = adj[x].listIterator();

        while(it.hasNext()) {
            int current = it.next();

            if(current == y) {
                break;
            }
            index++;
        }
        adj[x].remove(index);
    }
} 