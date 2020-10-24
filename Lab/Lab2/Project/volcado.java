import java.io.*;
import java.lang.*;
import java.util.*;

/*
 * Esto no es una copia :v
 * Usé como referencia el codigo otorgado por el profesor Marting Gutierrez(lab a lab)
 * para así construir la misma idea desde la base. :p
 * 
 */

public class volcado {
    public static void volcar() {
        BufferedReader reader;
        BufferedWriter writer;
        //String[] filenames = {"./stats1.csv","./stats2.csv","./participants.csv","./champs.csv"};
        String[] filenames = {"./stats1.csv","./stats2.csv"}; // en ambos quiero 0 y 21
        ArrayList<tripleta> dataset = new ArrayList<tripleta>(); // matriz
        String outfilename = "stats_out.csv";
        try
        {   writer = new BufferedWriter(new FileWriter(outfilename, false));
            // lee los 2 stats por separado
            for(String fn : filenames){
                reader = new BufferedReader(new FileReader(fn));
                String line = reader.readLine();
                boolean uwu = false;
                while(line != null)
                {
                    String[] row1 = line.split(",", -1); 
                    // de cada linea añade lo que hay entre comas a un array de string
                    if(uwu)
                    {   // se omite la primera linea 
                        // se borran las comillas de los valores que necesito
                        tripleta par; 
                        row1[0] = row1[0].replace("\"","");     // id           
                        row1[21] = row1[21].replace("\"","");   // totdmgdealt
                        par = new tripleta(row1[0], row1[21]);
                        dataset.add(par); // añadido el par que se necesita en este caso
                    } 
                    uwu = true;
                    line = reader.readLine();   // sig linea
                }
                for(tripleta x : dataset)
                {
                    writer.write(Integer.toString(x.getId()));
                    writer.write(",");
                    writer.write(Integer.toString(x.getDmg()));
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
