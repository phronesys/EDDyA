/* 
    ref:
        https://www.softwaretestinghelp.com/java-graph-tutorial/
        https://www.baeldung.com/java-graphs
*/
import java.util.*;

// class to store aristas (edges) of the eighted graph
class Arista {
    int src, dest, weight;
    Arista(int desde, int hacia, int peso){
        this.src = desde;
        this.dest = hacia;
        this.weight = peso;
    }
}
class Graph {
    static class NodeGraph {
        int value, weight; 
        NodeGraph(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
    List<List<NodeGraph>> adj_list = new ArrayList<>();

    public Graph(List<Arista> aristas){
        // memory alocation 
        for (int i = 0; i < aristas.size(); i++)
            adj_list.add(i, new ArrayList<>());
        
        // esto añade las uniones del grafo
        for (Arista a: aristas)
        {
            adj_list.get(a.src)
        }
        
    }
}

 // main
public class graph {
    public static void main(String[] args) {
        
    }
}

