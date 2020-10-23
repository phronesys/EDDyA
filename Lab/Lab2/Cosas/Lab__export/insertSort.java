import java.util.ArrayList;

public class insertSort 
{
    public insertSort()
    {
    }

    ArrayList<Tripleta> Isort(ArrayList<Tripleta> array) 
    { 
        for (int i = 1; i < array.size(); i++) {
            if(i%10000 == 0)
            {
                System.out.println("Llevo " + i + " valores ordenados.");
            }
            Tripleta key = (Tripleta)array.get(i); 
            int j = i - 1; 
            while (j >= 0 && array.get(j).getDmg() < key.getDmg()) 
            { 
                array.set(j+1,array.get(j));
                j = j - 1; 
            } 
            array.set(j+1,key);
        }
        return array;
    } 
}