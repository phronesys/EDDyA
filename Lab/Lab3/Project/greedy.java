import java.util.*;

public class greedy {
    public greedy(){}
    public ArrayList<Integer> bracket(HashMap<Integer,Integer> teams)
    {   
        ArrayList<Integer> out = new ArrayList<Integer>();
        ArrayList<Map.Entry<Integer,Integer>> sHash = new ArrayList<Map.Entry<Integer, Integer>>(teams.entrySet());
        
        // se ordena la lista según el dmg
        Collections.sort(sHash,
            new Comparator<Map.Entry<Integer,Integer>>(){
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2)
                {
                    return e1.getValue().compareTo(e2.getValue());
                }   
            }
        );
        Iterator<Map.Entry<Integer, Integer>> it = sHash.iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer, Integer> pair1 = it.next();
            if(it.hasNext())
            {
                Map.Entry<Integer, Integer> pair2 = it.next();
                out.add(pair1.getKey());
                out.add(pair2.getKey());
            } else {
                out.add(pair1.getKey());
            }
        }
        return out; // retorna los teamsid ordenados de menor a mayor dmg
    }
}
