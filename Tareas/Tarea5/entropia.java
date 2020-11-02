import java.util.*;
import java.lang.*;

public class entropia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while(!line.equals("****END_OF_INPUT****"))
        {
            
            int nWords = 0;
            
            while(!line.equals("****END_OF_TEXT****"))
            {
                // contar palabras
                String words = line.replaceAll("[^\\w\\s]", ""); // separa palabras por espacios
                String[] wordsA = words.split("\\s"); // cada word separada por un espacio
                nWords += wordsA.length;
                //System.out.println(words);
                line = scan.nextLine();
            }
            System.out.println();
            System.out.print(nWords + " " + getEntropy(nWords) + " " + getEntropyRel(nWords));
            line = scan.nextLine();
        }
        scan.close();
    }
    public static int getEntropyRel(int n)
    {
        return (int)(getEntropy(n)/ getMaxEntropy());
    }
    public static float getEntropy(int n)
    {
        
        return n;
    }
    public static float getMaxEntropy()
    {
        return 0;
    }
}
