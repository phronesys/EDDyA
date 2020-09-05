import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> parsed = new ArrayList<ArrayList<String>>();
        String csvString = "./matches.csv";
        parser(csvString, parsed);
        // write in a .csv
        writer(parsed);
        print(parsed);
    }
    static void print(ArrayList<ArrayList<String>> parsed){
        // printing what is inside 2d arraylist
        for(int i = 0; i < parsed.size(); i++){
            for (int j = 0; j < parsed.get(i).size(); j++){
                System.out.print(parsed.get(i).get(j));
            }
            System.out.println();
        }
    }
    static void writer(ArrayList<ArrayList<String>> parsed){
        int i = 0;
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("output.csv", false));
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
