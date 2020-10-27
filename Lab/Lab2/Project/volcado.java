import java.io.*;
import java.util.*;

/*
 * 
 * Usé como referencia el codigo otorgado por el profesor Marting Gutierrez(lab a lab)
 * para así construir la misma idea desde la base. e.e
 * 
 */

public class volcado 
{
    public static String[] files = {"./stats1.csv","./stats2.csv"};
    public static String[] files2 = {"./participants.csv","./champs.csv"};
    public static String[] files3 = {"./stats3.csv"};
    public static Boolean uwu = false;
    public static String line;
    public static HashMap<Integer,String> champs = new HashMap<Integer,String>();
    public static HashMap<Integer,Integer> participants = new HashMap<Integer,Integer>();

    // este algoritmo simplemente devuelve el dataset en un ArrayList
    // para luego ser ordenado en App.java
    public static ArrayList<tripleta> volcarNormal(int x) {
        BufferedReader reader;   
        ArrayList<tripleta> dataset = new ArrayList<tripleta>();   
        hashmaps();
        try
        {    
            if(x == 1){
                files = files3;
            }
            // stats
            for(String fn : files)
            {
                reader = new BufferedReader(new FileReader(fn));
                line = reader.readLine();
                uwu = false;

                while(line != null)
                {
                    String[] row = line.split(",", -1); 
                    String champ;
                    int playerId, championId, dmg;
      
                    if(uwu)
                    {   
                        row[0] = row[0].replace("\"","");     // id           
                        row[21] = row[21].replace("\"","");   // totdmgdealt

                        playerId = Integer.parseInt(row[0]);
                        championId = participants.get(playerId);
                        champ = champs.get(championId);
                        dmg = Integer.parseInt(row[21]);

                        tripleta tri = new tripleta(playerId, dmg, champ);
                        dataset.add(tri);         
                    } 
                    uwu = true;
                    line = reader.readLine();   // sig linea
                }
                reader.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return dataset;
    }
    // esta función lo añade ordenado usando heapsort
    // como este algoritmo es malísimo y corre a O(n^2logN)
    // será ejecutado usando stats3.csv para así demostrar que funciona
    // retorna un objeto que debe ser manipulado como un queue (dequeue, enqueue)
    public static priorityQHeapSort volcarPQ(int x)
    {
        BufferedReader reader;
        priorityQHeapSort dataset2 = new priorityQHeapSort(); // esto es O(N^2logN)!!
        hashmaps();
        try
        {   
            for(String fn : files3)
            {
                reader = new BufferedReader(new FileReader(fn));
                line = reader.readLine();
                uwu = false;

                while(line != null)
                {
                    String[] row = line.split(",", -1); 
                    String champ;
                    int playerId, championId, dmg;

                    
                    if(uwu)
                    {   
                        row[0] = row[0].replace("\"","");     // id           
                        row[21] = row[21].replace("\"","");   // totdmgdealt

                        playerId = Integer.parseInt(row[0]);
                        championId = participants.get(playerId);
                        champ = champs.get(championId);
                        dmg = Integer.parseInt(row[21]);

                        tripleta tri = new tripleta(playerId, dmg, champ);
                        dataset2.enqueue(tri); 
                    } 
                    uwu = true;
                    line = reader.readLine();   // sig linea
                }
                reader.close();           
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return dataset2;
    }
    
    public static priorityQueue priorityQ(int x){
        BufferedReader reader;
        priorityQueue temp = new priorityQueue();
        hashmaps();
        try
        {   
            for(String fn : files)
            {
                reader = new BufferedReader(new FileReader(fn));
                line = reader.readLine();
                uwu = false;

                while(line != null)
                {
                    String[] row = line.split(",", -1); 
                    String champ;
                    int playerId, championId, dmg;

                    if(uwu)
                    {   
                        row[0] = row[0].replace("\"","");     // id           
                        row[21] = row[21].replace("\"","");   // totdmgdealt

                        playerId = Integer.parseInt(row[0]);
                        championId = participants.get(playerId);
                        champ = champs.get(championId);
                        dmg = Integer.parseInt(row[21]);

                        tripleta tri = new tripleta(playerId, dmg, champ);
                        temp.add(tri); 
                    } 
                    uwu = true;
                    line = reader.readLine();   // sig linea
                }
                reader.close();           
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return temp;
    }
    // cuando se ejecuta una función de volcado se rellenan los 
    // hashmaps con los datos necesarios
    public static void hashmaps()
    {
        try{
            BufferedReader reader;
            // part y champs
            for(String fn2: files2)
            {
                reader = new BufferedReader(new FileReader(fn2));
                uwu = false;
                line = reader.readLine();
                while(line != null)
                {
                    String[] row;
                    row = line.split(",",-1);

                    if(uwu)
                    {
                        if(fn2.compareTo("./champs.csv") == 0)
                        {
                            row[0] = row[0].replace("\"","");
                            row[1] = row[1].replace("\"","");
                            champs.put(Integer.parseInt(row[1]), row[0]); // key: champid 
                        }
                        else // participants.csv 
                        {
                            row[0] = row[0].replace("\"","");
                            row[3] = row[3].replace("\"","");
                            participants.put(Integer.parseInt(row[0]), Integer.parseInt(row[3]));   
                        }
                    }
                    uwu = true;
                    line = reader.readLine();
                }
                reader.close();
            }
        } catch(IOException e){ e.printStackTrace(); }
        // una vez se tienen ambos hashmaps sabiendo sus respectivas keys (id's)
        // se puede añadir el nombre del champion usado a la tripleta en O(1)
        // tal que:     idjugador -> idchampion (participants.csv)
        //          ->  idchampion -> champion (champs.csv)
    }
}
