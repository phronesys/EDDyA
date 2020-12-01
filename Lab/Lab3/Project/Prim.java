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

        // el primero dentro del team
        team[0] = currentPlayer;
        team_dmg[0] = currentDmg;
        checked[0] = true;

        currentHash.remove(id);
        n_players++; 

        while (n_players < 5) // cada player
        {
            for(int i = 1; i < 5; i++) // 1 2 3 4 hashmaps
            {
                // primero se ubica el current hash
                if(!checked[i] && i <= 2)
                {
                    currentHash = (HashMap<Integer,Integer>)data.get(i);
                }
                else if(!checked[i] && i > 2)
                {
                    currentHash = (HashMap<Integer,Integer>)data.get(i - 1); 
                    // así el hash correspondiente a solo 2 usa el mismo solo de la pos 3
                }


                Integer min = Integer.MAX_VALUE;
                Integer x = 0;

                for(Map.Entry<Integer, Integer> entry : currentHash.entrySet())
                {
                    Integer k = entry.getKey();
                    Integer v = entry.getValue();

                    for(int j = 0; j < 5; j++)
                    {
                        // busca la minima diferencia entre los dmgs
                        if(checked[j] && team_dmg[j] != null && team_dmg[j] > -1 && v != null && Math.abs(team_dmg[j] - v) < min)
                        {
                            min = Math.abs(team_dmg[j] -v);
                            x = k; // este id guarda el min
                        }
                    }
                }
                team[i] = x;
                team_dmg[i] = (Integer)currentHash.get(x);
                checked[i] = true;
                currentHash.remove(x);
                n_players++;
            }
            System.out.println("El equipo es: ");
            for(int k = 0; k < 4; k++)
            {
                System.out.print(team[k] + ", ");
            }
            System.out.print(team[4] + "\n");

            return team; 
        }




        return team;
    }
}
