import java.util.*;
public class Prim {
    public Prim(){}
    // esto crea un equipo para un id dado y su hashmap con su id y dmg
    public Integer[] matchmaking(Integer id, ArrayList<HashMap<Integer,Integer>> data)
    {
        int n_players = 0; // para recorrer cada player

        Integer[] team = new Integer[5];
        Integer[] team_dmg = new Integer[5];
        boolean[] checked = new boolean[5];
        Integer currentPlayer = id;
        Integer currentDmg;
        HashMap<Integer,Integer> currentHash; 

        // se rellenan los arrays 
        Arrays.fill(team,Integer.valueOf(-1));
        Arrays.fill(team_dmg,Integer.valueOf(-1));
        Arrays.fill(checked,false);

        currentHash = (HashMap<Integer,Integer>) data.get(0);
        currentDmg = (Integer) currentHash.get(currentPlayer);

        currentHash.remove(id);
        n_players++; 

        while (n_players < 5) // cada player
        {
            for(int i = 1; i < 5; i++)
            {
                if(!checked[i] && i <= 2)
                {
                    currentHash = (HashMap<Integer,Integer>)data.get(i);
                }
            }
        }




        return team;
    }
}
