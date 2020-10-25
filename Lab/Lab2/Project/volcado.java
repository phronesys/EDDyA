import java.io.*;
import java.lang.*;
import java.util.*;

/*
 * 
 * Usé como referencia el codigo otorgado por el profesor Marting Gutierrez(lab a lab)
 * para así construir la misma idea desde la base. e.e
 * 
 */

public class volcado {
    public static void volcar() {
        BufferedReader reader;
        BufferedWriter writer;
        String outfile = "out.csv";
        
        //String[] files = {"./stats3.csv"};
        String[] files = {"./stats1.csv","./stats2.csv"};
        String[] files2 = {"./participants.csv","./champs.csv"};
        ArrayList<tripleta> dataset = new ArrayList<tripleta>(); // matriz
        HashMap<Integer,String> champs = new HashMap<Integer,String>();
        HashMap<Integer,Integer> participants = new HashMap<Integer,Integer>();
        try
        {   
            writer = new BufferedWriter(new FileWriter(outfile, false)); 
            
            String line;
            Boolean uwu = false;
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
            // una vez se tienen ambos hashmaps sabiendo sus respectivas keys (id's)
            // se puede añadir el nombre del champion usado a la tripleta en O(1)
            // tal que:     idjugador -> idchampion (participants.csv)
            //          ->  idchampion -> champion (champs.csv)

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
                //quickSortAL.quickSort(dataset, 0, dataset.size()-1);  // ranking del menor dmg al mayor e.e
                //heapSortAL.sort(dataset);                 // working
                //insertionSort.insertionSortDec(dataset);  // working
                for(tripleta x : dataset)
                {
                    writer.write(Integer.toString(x.getId()));
                    writer.write(",");
                    writer.write(Integer.toString(x.getDmg()));
                    writer.write(",");
                    writer.write(x.getChamp());
                    writer.write("\n");
                } 
                reader.close();
                
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}
