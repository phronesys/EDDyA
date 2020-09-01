import java.util.ArrayList;

public class stack2 {
    private ArrayList cosa;
    public stack2()
    {
        cosa = new ArrayList();
    }
    public Object pop()
    {
        Object out = contenido.get(contenido.size()-1);
        contenido.remove((contenido.size()-1));
        return out;
    }
    public void push(Object in)
    {
        contenido.add(in);
    }
}