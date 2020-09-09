import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;


// import javafx.util.Pair; no sirve por que es de java 7, ni en java 8 se puede usar XD


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
        /* ArrayList<ArrayList<String>> parsed1 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed2 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed3 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed4 = new ArrayList<ArrayList<String>>();
        //ArrayList<ArrayList<String>> parsed5 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> parsed7 = new ArrayList<ArrayList<String>>();
         */
        ArrayList<ArrayList<String>> parsed6 = new ArrayList<ArrayList<String>>();
        parser(teambans, parsed6);
        // Descomentar uno a uno para evitar problemas de heap
        /* parser(matches, parsed1);
        parser(champs, parsed2);
        parser(participants, parsed3);
        parser(stats1, parsed4);
        //parser(stats2, parsed5); Not working
        //parser(teambans, parsed6);
        parser(teamstats, parsed7);

        writer(match, parsed1);
        writer(champ, parsed2);
        writer(parti, parsed3); 
        writer(stat1, parsed4);
        //writer(stat2, parsed5);  Not Working
        writer(tmban, parsed6);
        writer(tstat, parsed7);  */ 
        // stats2.csv genera el siguiente error
        // Exception in thread "main" java.lang.IllegalArgumentException: 0 > -7

        
        int currentmatchid = 0;
        //esto recorre cada linea del csv
        System.out.println("Entrando a la parte de los queues");
        queue ordenado = new queue();
        //queue desordenado = new queue();
        ArrayList<List<Integer>> pares = new ArrayList<List<Integer>>();
        

        for(int i = 1; i < parsed6.size(); i++){
            String matchidAnterior = parsed6.get(i-1).get(0);
            String matchid = parsed6.get(i).get(0);
            String banturn = parsed6.get(i).get(3);
            String champion = parsed6.get(i).get(2);
            
            matchid = noQuotes(matchid);
            banturn = noQuotes(banturn);
            champion = noQuotes(champion);
            
            int imatchid = Integer.parseInt(matchid);
            int ibanturn = Integer.parseInt(banturn);
            int ichampion = Integer.parseInt(champion);
            
            List<Integer> pair = Arrays.asList(ibanturn, ichampion);
            
            // esto pasa cada vez que cambia matchid
            // es decir, entra una vez al if por matchid
            if(currentmatchid != imatchid){
                // cuando se tiene un nuevo matchid
                // los pares desordenados del arraylist
                // son añadidos al queue en orden
                if(!ordenado.isEmpty()){
                    //System.out.println("plus ultra uwu");
                    // esto se ejecuta cuando cambia al siguiente matchid y
                    // cuando ya está el primer champid en el queue
                    
                    ordena_addQueue(pares, ordenado);
                    queue copiaOrdenada = new queue(ordenado);
                    stack ordenadoReverse = reverseWithStack(copiaOrdenada);
                    writerStack("outStack.csv", ordenadoReverse, matchidAnterior);
                    writerQueue("outQueue.csv", ordenado, matchidAnterior);
                    //ahora se escribe el queue ordenado en el archivo
                    // cada queue ordenado corresponde a una linea a escribir en el csv

                }

                ordenado = new queue();   
                currentmatchid = imatchid;
                // se añade primer champid a la cola para que 
                // la siguiente iteración ordenado tenga algo y se ejecute el if
                ordenado.enqueue(pair.get(1));
            } else {
                // mientras el matchid no cambie
                // se añaden pares de la segunda linea en adelante,
                // a un ArrayList de pares
                // esto pq despues el primer banturn hay que ordenarlos
                pares.add(pair);
            }
            
            
        }  
        
    } 
    static void writerStack(String out, stack linea, String matchid)
    {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(out, true));
            if(flag == true) writer.newLine();
            writer.write(matchid);
            writer.write(":");
            while(!linea.isEmpty())
            {
                writer.write(Integer.toString((Integer)linea.pop()));
                if(!linea.isEmpty())
                    writer.write(",");
            }
            flag = true;
            writer.close();
        }catch (IOException err) {
            err.printStackTrace();
        }
    }
    static stack reverseWithStack(queue copiaOrdenada){
        stack reversed = new stack();
        while(!copiaOrdenada.isEmpty()) 
        {
            reversed.push(copiaOrdenada.front());
            copiaOrdenada.dequeue();
        }
        return reversed;
    }
    static void writerQueue(String out, queue linea, String matchid){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(out, true));
            if(flag == true) writer.newLine();
            writer.write(matchid);
            writer.write(":");
            while(!linea.isEmpty()){
                writer.write(Integer.toString((Integer)linea.front()));
                linea.dequeue();
                if(!linea.isEmpty()) 
                    writer.write(",");
            }
            flag = true;
            writer.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
    static void ordena_addQueue(ArrayList<List<Integer>> desorden, queue ordenado){
        
        ArrayList<Integer> orden = new ArrayList<Integer>();
        int index = 0;
        int buscado = 2;
        while(!desorden.isEmpty()){
            if(buscado == desorden.get(index).get(0))
            {
                orden.add(desorden.get(index).get(1));
                desorden.remove(index);
                index = 0;
                buscado++;
            } else {
                index++;
            }
            if(index > desorden.size()-1){
                buscado++;
                index = 0;
            }
        }

        for(int i : orden){
            ordenado.enqueue(i);
        }
        orden.clear();
        desorden.clear();
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
   
    static String noQuotes(String item){
        return item.substring(1, item.length() - 1);
    }
    public static boolean flag = false;
    public static boolean flag2 = false;
}
