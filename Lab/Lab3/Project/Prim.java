import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Prim {
    public Prim()
    {

    }
    // minimum spanning tree
    public void MST(int graph[][], int size)
    {
        int edge = 0;
        boolean ST[] = new boolean[size];
        Arrays.fill(ST, false); // clean
        ST[0] = true;

        System.out.println("PRIM");
        System.out.println("Edge : Weight");
        while(edge < size - 1) 
        {
            int min = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;

            for(int i = 0; i < size; i++)
            {
                // ST[0] es true por ende se parte desde aqui, asi es más facil iterar
                if(ST[i] == true)
                {
                    for (int j = 0; j < size; j++)
                    {
                        if(!ST[j] && graph[i][j] != Integer.MAX_VALUE)
                        {
                            if(graph[i][j] < min)
                            {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " : " + graph[x][y]);
            ST[y] = true;
            edge++;
        }
    }
}
 