import java.util.*;
import java.lang.*;


public class Prim 
{
    public Prim()
    {
    }

    public Integer[] calcTeam(Integer id, ArrayList<HashMap<Integer,Integer>> data)
    {
        int n_players = 0;
        Integer team[] = new Integer[5];
        Integer team_dmg[] = new Integer[5];
        boolean checked[] = new boolean[5];
        Integer currentPlayer = id;
        Integer currentDamage;
        HashMap<Integer,Integer> currentHashMap;

        Arrays.fill(team,Integer.valueOf(-1));
        Arrays.fill(team_dmg,Integer.valueOf(-1));
        Arrays.fill(checked,false);
        
        currentHashMap = (HashMap<Integer,Integer>)data.get(0);
        currentDamage = (Integer)currentHashMap.get(currentPlayer);

        team[0] = currentPlayer;
        team_dmg[0] = currentDamage;
        checked[0] = true;

        currentHashMap.remove(id);
        n_players++;

        while (n_players < 5) 
        {
            for(int i = 1; i < 5; i++)
            {
                if(!checked[i] && i <= 2)
                {
                    currentHashMap = (HashMap<Integer,Integer>)data.get(i);
                }
                else if(!checked[i] && i > 2)
                {
                    currentHashMap = (HashMap<Integer,Integer>)data.get(i-1);
                }

                Integer min = Integer.MAX_VALUE;
                Integer x = 0;

                for(Map.Entry<Integer, Integer> entry : currentHashMap.entrySet()) 
                {
                    Integer k = entry.getKey();
                    Integer v = entry.getValue();
                
                    for(int j = 0; j < 5; j++)
                    {
                        if(checked[j] && team_dmg[j] != null && team_dmg[j] > -1 && v != null && Math.abs(team_dmg[j] - v) < min)
                        {
                            min = Math.abs(team_dmg[j] - v);
                            x = k;
                        }
                    }
                }

                team[i] = x;
                team_dmg[i] = (Integer)currentHashMap.get(x);
                checked[i] = true;
                currentHashMap.remove(x);
                n_players++;
            }
        }
        System.out.print("The team is: ");
        for(int l = 0; l < 4; l++)
        {
            System.out.print(team[l] + ", ");
        }
        System.out.print(team[4] + "\n");

        return team;
    }

    /*public void MST(int graph[][], int size)
    {
        int edge = 0;
        boolean ST[] = new boolean[size];
        Arrays.fill(ST,false);
        ST[0] = true;

        System.out.println("PRIM");
        System.out.println("Edge : Weight");

        while (edge < size - 1) 
        {
            int min = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;

            for (int i = 0; i < size; i++) 
            {
                if (ST[i] == true) 
                {
                    for (int j = 0; j < size; j++) 
                    {
                        if (!ST[j] && graph[i][j] != Integer.MAX_VALUE) 
                        {
                            if (graph[i][j] < min) 
                            {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + graph[x][y]);
            ST[y] = true;
            edge++;
        }
    }*/
}