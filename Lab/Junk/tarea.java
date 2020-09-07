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
            reader = new BufferedReader(new FileReader("./csv/ConComillas/matches.csv"));
            String line = reader.readLine();

            while(line != null)
            {
                // splited es un array de string que tomará cada item
                // que se encuentre separado con comas
                String [] splited;
                splited = line.split(",", -1);
                ArrayList<String> lines = new ArrayList<String>();

                // DRY 
                for(int i = 0; i < splited.length; i++){
                    lines.add(splited[i].substring(1, splited[i].length() -1));
                }
                // Acá se crea un nuevo string sin las comillas iniciales 
                // myString.substring(inicio, final)
                /* 
                String matchid = splited[0].substring(1, splited[0].length() -1);
                String teamid = splited[1].substring(1, splited[1].length() -1);
                String champid = splited[2].substring(1, splited[2].length() -1);
                String banturn = splited[3].substring(1, splited[3].length() -1);

                // Se puede añadir automaticamente al ArrayList
                // lines.add(splited[0].substring(1, splited[0].length() -1));
                // lines.add(splited[1].substring(1, ...
                

                // Este bucle imprime los items sin comillas usando cada string
                 for(int i = 0; i < splited.length; i++) {
                    System.out.println(matchid + "," + teamid +","+ champid +","+ banturn);
                }
                */

                // Esto imprime el ArrayList<String>
                int cont = 0;
                String fila = "";
                for(String part: lines) {
                    if(cont == 3) {
                        fila += part;
                        System.out.println(fila);

                        cont = 0;
                        fila = "";
                    }
                    //System.out.print(part);
                    
                    fila += part;
                    fila += ",";
                    cont++;
                }

                line = reader.readLine();
            }

        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}

