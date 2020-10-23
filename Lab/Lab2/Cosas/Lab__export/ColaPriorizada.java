import java.util.ArrayList;

public class ColaPriorizada 
{
    private ArrayList contenido;

    public ColaPriorizada()
    {
        contenido = new ArrayList();
    }

    public Object dequeue()
    {
        Object out = null;
        if(!isEmpty())
        {  
            out = contenido.get(0);
            contenido.remove(0);
        }
        return out;
    }

    public void enqueue(Object in)
    {
        contenido.add(in);
        int i = contenido.size()-1;
        Tripleta key = (Tripleta)contenido.get(i);
        int j = i - 1;
        while (j >= 0 && contenido.get(j).getDmg() < key.getDmg()) 
        { 
            contenido.set(j+1,contenido.get(j));
            j = j - 1; 
        } 
        contenido.set(j+1,key);
    }

    public Boolean isEmpty()
    {
        return (contenido.size() == 0);
    }
    
}