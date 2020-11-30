import java.util.LinkedList;
import java.util.*;
class graph {
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
}
public class mincost{
    public static void main(String[] args) {
        
    }
}