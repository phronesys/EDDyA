import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class tarea {

    public static void main(String[] args) {
        BufferedReader reader;
        // Se inicializa Array de Array
        ArrayList<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();

        // Se usa try - catch en caso de errores
        try {
            // reader
            reader = new BufferedReader(new FileReader("teambans.csv"));
            String line = reader.readLine();

            while(line != null)
            {
                //System.out.println(line);
                String [] splited;
                splited = line.split(",", -1);
                String matchid = splited[0].substring(1, splited[0].length() -1);
                String teamid = splited[1].substring(1, splited[1].length() -1);
                String champid = splited[2].substring(1, splited[2].length() -1);
                String banturn = splited[3].substring(1, splited[3].length() -1);

                for(int i = 0; i < splited.length; i++) {
                    System.out.println(matchid + "," + teamid +","+ champid +","+ banturn);
                }

                line = reader.readLine();
            }

        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}

// myString = myString.substring(1, myString.length()-1);