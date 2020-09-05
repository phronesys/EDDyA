import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String matches = "./matches.csv",
               champs = "./champs.csv",
               participants = "./participants.csv",
               stats1 = "./stats1.csv",
               stats2 = "./stats2.csv",
               teambans = "./teambans.csv",
               teamstats = "./teamstats.csv";
        String match = "matchesOut.csv";
        String champ = "champsOut.csv";
        String parti = "participantsOut.csv";
        String stat1 = "stats1Out.csv";
        String stat2 = "stats2Out.csv";
        String tmban = "teambansOut.csv";
        String tstat = "teamstatsOut.csv";
        
        /* ArrayList<ArrayList<String>> parsed1 = new ArrayList<ArrayList<String>>();
        parser(matches, parsed1);
        writer(match, parsed1);
        ArrayList<ArrayList<String>> parsed2 = new ArrayList<ArrayList<String>>();
        parser(champs, parsed2);
        writer(champ, parsed2);
        ArrayList<ArrayList<String>> parsed3 = new ArrayList<ArrayList<String>>();
        parser(participants, parsed3);
        writer(parti, parsed3); */
        /* ArrayList<ArrayList<String>> parsed4 = new ArrayList<ArrayList<String>>();
        parser(stats1, parsed4);
        writer(stat1, parsed4);  */
        ArrayList<ArrayList<String>> parsed5 = new ArrayList<ArrayList<String>>();
        parser(stats2, parsed5);
        //writer(stat2, parsed5);  
        /* ArrayList<ArrayList<String>> parsed6 = new ArrayList<ArrayList<String>>();
        parser(teambans, parsed6);
        writer(tmban, parsed6);
        ArrayList<ArrayList<String>> parsed7 = new ArrayList<ArrayList<String>>();
        parser(teamstats, parsed7);
        writer(tstat, parsed7); */

    }
    static void print(ArrayList<ArrayList<String>> parsed){
        for(int i = 0; i < parsed.size(); i++){
            for (int j = 0; j < parsed.get(i).size(); j++){
                System.out.print(parsed.get(i).get(j));
            }
            System.out.println();
        }
    }
    static void writer(String name, ArrayList<ArrayList<String>> parsed){
        int i = 0;
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(name, false));
            // cada arraylist de la matriz
            for(ArrayList items : parsed) 
            {
                // cada string en el arraylist
                // el -1 es para que el ultimo se añada sin una "," extra
                for(i = 0; i < items.size() - 1; i++){
                    writer.write(items.get(i).toString());
                    writer.write(",");
                }
                writer.write(items.get(i).toString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
    static void parser(String fileLocation, ArrayList<ArrayList<String>> parsed){
        BufferedReader reader;
        try {
            // inicializamos reader con el string correspondiente al archivo
            reader = new BufferedReader(new FileReader(fileLocation));
            String line;
            while(( line = reader.readLine()) != null) {
                // items separados por comas
                String[] splited;
                System.out.println(line);
                splited = line.split(",", -1);
                ArrayList<String> lines = new ArrayList<String>();
                for(int i = 0; i < splited.length; i++){
                    lines.add(splited[i]);
                }
                parsed.add(lines);
                //line = reader.readLine();
            }
            reader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
    
    // todavía no la usaré
    static ArrayList<String> cutQuotes(String[] items, int size){
        ArrayList<String> lines = new ArrayList<String>();
        for(int i = 0; i < size; i++){
            lines.add(items[i].substring(1,items[i].length()-1));
        }
        return lines;
    }
}
