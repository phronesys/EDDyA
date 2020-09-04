import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> parsed = new ArrayList<ArrayList<String>>();
        String csvString = "./csv/ConComillas/matches.csv";
        parser(csvString, parsed);
        //System.out.println(parsed);
        parsed.get(0).set(0, "first");
        for(int i = 0; i < parsed.size(); i++){
            for (int j = 0; j < parsed.get(i).size(); j++){
                System.out.print(parsed.get(i).get(j));
            }
            System.out.println();
        }
    }
    static void parser(String fileLocation, ArrayList<ArrayList<String>> parsed){
        BufferedReader reader;
        try {
            // inicializamos reader con el string correspondiente al archivo
            reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();
            while(line != null) {
                // items separados por comas
                String[] splited;
                splited = line.split(",", -1);
                ArrayList<String> lines = new ArrayList<String>();
                for(int i = 0; i < splited.length; i++){
                    lines.add(splited[i]);
                }
                parsed.add(lines);
                line = reader.readLine();
            }
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
