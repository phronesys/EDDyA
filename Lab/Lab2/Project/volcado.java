import java.io.*;
import java.lang.*;
import java.util.*;

/*
 * Esto no es una copia :v
 * Usé como referencia el codigo otorgado por el profesor (lab a lab)
 * para así construir la misma idea desde la base. :p
 * 
 */

public class volcado {
    public static void main(String[] args) {
        BufferedReader reader;
        BufferedWriter writer;
        //String[] filenames = {"./stats1.csv","./stats2.csv","./participants.csv","./champs.csv"};
        String[] filenames = {"./stats1.csv","./stats2.csv"}; // en ambos quiero 0 y 21
        ArrayList<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>(); // matriz
        String outfilename = "stats_out.csv";
        try
        {   
            // lee los 2 stats por separado
            for(String fn : filenames){
                reader = new BufferedReader(new FileReader(fn));
                writer = new BufferedWriter(new FileWriter(outfilename, false));
                String line = reader.readLine();
                boolean uwu = false;
                while(line != null)
                {
                    ArrayList<String> parsing1 = new ArrayList<String>();
                    String[] row1 = line.split(",", -1); 
                    // de cada linea añade lo que hay entre comas a un array de string
                    if(uwu){ // se omite la primera linea 
                        // se borran las comillas de los valores que necesito
                        row1[0] = row1[0].replace("\"","");     // id           
                        row1[21] = row1[21].replace("\"","");   // totdmgdealt
                        parsing1.add(row1[0]);
                        parsing1.add(row1[21]);
                        dataset.add(parsing1); // añadido el par que se necesita en este caso
                    } 
                    uwu = true;
                    line = reader.readLine();   // sig linea
                }
                for(ArrayList x : dataset)
                {
                    writer.write(x.get(0).toString());
                    writer.write(",");
                    writer.write(x.get(1).toString());
                    writer.write("\n");
                }
                reader.close();
                writer.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
