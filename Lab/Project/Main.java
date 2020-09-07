import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        String matches = "./matches.csv",
                champs = "./champs.csv",
                participants = "./participants.csv",
                stats1 = "./stats1.csv",
                //stats2 = "./stats2.csv",
                teambans = "./teambans.csv",
                teamstats = "./teamstats.csv",
                match = "outMatches.csv",
                champ = "outChamps.csv",
                parti = "outParticipants.csv",
                stat1 = "outStats1.csv",
                //stat2 = "outStats2.csv",
                tmban = "outTeambans.csv",
                tstat = "outTeamstats.csv";

        System.out.println("parsing every file");
        ArrayList<ArrayList<String>> parsed1 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed2 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed3 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed4 = new ArrayList<ArrayList<String>>();
        //ArrayList<ArrayList<String>> parsed5 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed6 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed7 = new ArrayList<ArrayList<String>>();

        parser(teambans, parsed6);
        /* parser(matches, parsed1);
        parser(champs, parsed2);
        parser(participants, parsed3);
        parser(stats1, parsed4);
        //parser(stats2, parsed5); 
        parser(teambans, parsed6);
        parser(teamstats, parsed7);

        writer(match, parsed1);
        writer(champ, parsed2);
        writer(parti, parsed3); 
        writer(stat1, parsed4);
        //writer(stat2, parsed5);  
        writer(tmban, parsed6);
        writer(tstat, parsed7);  */
        // stats2.csv genera el siguiente error
        // Exception in thread "main" java.lang.IllegalArgumentException: 0 > -7
        for(int i = 0; i < parsed6.size(); i++){
            System.out.println(parsed6.get(i).get(3));
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
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                ArrayList<String> lines = new ArrayList<String>();
                while(tokenizer.hasMoreTokens()) {
                    lines.add(tokenizer.nextToken());
                }
                parsed.add(lines);
            }
            reader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
    static void parser2(String fileLocation, ArrayList<ArrayList<String>> parsed){
        BufferedReader reader;
        try {
            // inicializamos reader con el string correspondiente al archivo
            reader = new BufferedReader(new FileReader(fileLocation));
            String line;
            while(( line = reader.readLine()) != null) {
                // items separados por comas
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                ArrayList<String> lines = new ArrayList<String>();
                while(tokenizer.hasMoreTokens()) {
                    lines.add(tokenizer.nextToken());
                }
                parsed.add(lines);
            }
            reader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
