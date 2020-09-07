import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class App {
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
        writer(tstat, parsed7);  
        // stats2.csv genera el siguiente error
        // Exception in thread "main" java.lang.IllegalArgumentException: 0 > -7

        */

        //Pair<Integer, String> pair = new Pair<>();
        // Objetivo:
        //  añadir pares a un queue, 6 pares (champid y banturn)

        queue current_matchid = new queue();
        //esto recorre cada linea del csv
        System.out.println("Entrando a la parte de los queues");
        for(int i = 1; i < parsed6.size(); i++){
            
            String matchid = parsed6.get(i).get(0);
            String banturn = parsed6.get(i).get(3);
            String champion = parsed6.get(i).get(2);
            int imatchid = Integer.parseInt(noQuotes(matchid));
            int ibanturn = Integer.parseInt(noQuotes(banturn));
            int ichampion = Integer.parseInt(noQuotes(champion));
            int[] ban_champ = new int[2];
            ban_champ[0] = ibanturn;
            ban_champ[1] = ichampion;


            // reinicia el queue pasando los items ordenados a un stack?
            if(matchid != parsed6.get(i-1).get(0)){
                while(!current_matchid.isEmpty()){
                    // lanzar items ordenados a un archivo lol
                    current_matchid.dequeue();
                }
                current_matchid.enqueue(imatchid);
            } else {
                 
                current_matchid.enqueue(ban_champ);
            } 
            current_matchid.printQueue();
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
                for(i = 1; i < items.size() - 1; i++){
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
    static void parserUsingSplit(String fileLocation, ArrayList<ArrayList<String>> parsed){
        BufferedReader reader;
        try {
            // inicializamos reader con el string correspondiente al archivo
            reader = new BufferedReader(new FileReader(fileLocation));
            String line;
            while(( line = reader.readLine()) != null) {
                // items separados por comas
                String splited[] = line.split(",", -1);
                ArrayList<String> lines = new ArrayList<String>();
                for(int i = 0; i < splited.length; i++){
                    lines.add(splited[i]);
                }
                parsed.add(lines);
            }
            reader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
    static String noQuotes(String item){
        return item.substring(1, item.length() - 1);
    }
}
