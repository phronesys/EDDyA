import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {
    public static void main(String[] args) {
        String matches = "./matches.csv",
                champs = "./champs.csv",
                participants = "./participants.csv",
                stats1 = "./stats1.csv",
                stats2 = "./stats2.csv",
                teambans = "./teambans.csv",
                teamstats = "./teamstats.csv",
                match = "outMatches.csv",
                champ = "outChamps.csv",
                parti = "outParticipants.csv",
                stat1 = "outStats1.csv",
                stat2 = "outStats2.csv",
                tmban = "outTeambans.csv",
                tstat = "outTeamstats.csv";
        System.out.println("parsing every file");
        ArrayList<ArrayList<String>> parsed1 = new ArrayList<ArrayList<String>>();
        parser(matches, parsed1);
        writer(match, parsed1);
        System.out.println("parsed 1");
        ArrayList<ArrayList<String>> parsed2 = new ArrayList<ArrayList<String>>();
        parser(champs, parsed2);
        writer(champ, parsed2);
        System.out.println("parsed 2");
        ArrayList<ArrayList<String>> parsed3 = new ArrayList<ArrayList<String>>();
        parser(participants, parsed3);
        writer(parti, parsed3); 
        System.out.println("parsed 3");
        ArrayList<ArrayList<String>> parsed4 = new ArrayList<ArrayList<String>>();
        parser(stats1, parsed4);
        writer(stat1, parsed4);
        System.out.println("parsed 4");
        ArrayList<ArrayList<String>> parsed5 = new ArrayList<ArrayList<String>>();
        parser(stats2, parsed5);
        writer(stat2, parsed5);  
        System.out.println("parsed 5");
        ArrayList<ArrayList<String>> parsed6 = new ArrayList<ArrayList<String>>();
        parser(teambans, parsed6);
        writer(tmban, parsed6);
        System.out.println("parsed 6");
        ArrayList<ArrayList<String>> parsed7 = new ArrayList<ArrayList<String>>();
        parser(teamstats, parsed7);
        writer(tstat, parsed7); 
        System.out.println("parsed 7");
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
