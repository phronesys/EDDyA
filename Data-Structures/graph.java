/* 
    Implementación clase 16nov 
    Adjacency Matrix
*/
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

    public void addConnection(int x, int y) { 
        matrix[x][y] = 1;
        matrix[y][x] = 1; // this works for undirected graphs
    }
    public void removeConnection(int x, int y) { 
        matrix[x][y] = 0;
        matrix[y][y] = 0;
    }

}

 