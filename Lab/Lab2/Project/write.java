import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class write {
    
    public static void export(ArrayList<tripleta> dataset){
        BufferedWriter writer;
        String outfile = "out.csv";

        try{
            writer = new BufferedWriter(new FileWriter(outfile, false));
            for(tripleta x : dataset)
                {
                    writer.write(Integer.toString(x.getId()));
                    writer.write(",");
                    writer.write(Integer.toString(x.getDmg()));
                    writer.write(",");
                    writer.write(x.getChamp());
                    writer.write("\n");
                }
            writer.close();
        }catch(IOException e){e.printStackTrace();}
    }
    public static void exportPQHS(priorityQHeapSort dataset){
        BufferedWriter writer;
        String outfile = "out.csv";

        try{
            writer = new BufferedWriter(new FileWriter(outfile, false));
            while(!dataset.isEmpty())
                {
                    tripleta x = dataset.dequeue();
                    writer.write(Integer.toString(x.getId()));
                    writer.write(",");
                    writer.write(Integer.toString(x.getDmg()));
                    writer.write(",");
                    writer.write(x.getChamp());
                    writer.write("\n");
                }
            writer.close();
        }catch(IOException e){e.printStackTrace();}
    }
    
    public static void printerPQHS(priorityQHeapSort dataset){
        while(!dataset.isEmpty())
        {
            tripleta temp = dataset.dequeue();
            System.out.println(temp.getId() + "," + temp.getDmg() + "," +temp.getChamp());
        } 
    }
    public static void printerNormal(ArrayList<tripleta> dataset){
        for(tripleta temp: dataset)
        {
            System.out.println(temp.getId() + "," + temp.getDmg() + "," +temp.getChamp());
        }
    }
    // print PQ
    // export PQ
}
