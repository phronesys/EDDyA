// compila, pero hace Memory Heap, no llega al millón de lineas
// ArrayList x Objects 
import java.util.*;
import java.io.*;


class test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList bans = readCSV();

        for (int i = 0; i < bans.size(); i++){
            System.out.println(bans.toString());
        }
    }
    public static ArrayList readCSV() throws FileNotFoundException, IOException {
        ArrayList test = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("teambans.csv"));

        String line = reader.readLine();

        while((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
            String matchid = fields[0];
            String teamid = fields[1];
            String championid = fields[2];
            String banturn = fields[3];
            // esto debería cambiarse por un ArrayList
            Testing league = new Testing(matchid, teamid, championid, banturn); 
            test.add(league);
        }
        reader.close();
        return test;
    }
    // fix this ._.
   /*  public static void print(ArrayList lolban) {
        for (Testing lol: lolban) {
            System.out.println(lol.toString());
        }
        // Type mismatch: cannot convert from element type Object to test.Testing
    }   */
    
    private static class Testing {
        private String mi;
        private String ti;
        private String ci;
        private String bt;
        public Testing(String matchid, String teamid, String championid, String banturn) {
            this.mi = matchid;
            this.ti = teamid;
            this.ci = championid;
            this.bt = banturn; 
        }
        public String match() { return mi; }
        public String team() { return ti; }
        public String champion() { return ci; }
        public String banturn() { return bt; }
 
        public String toString() {
            return "matchid = " + mi + ", teamid = " + ti 
            + ", championid = " + ci + ", banturn = " + bt;
        } 
    }
}
