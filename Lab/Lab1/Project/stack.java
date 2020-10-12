import java.util.ArrayList;
public class stack {
    private ArrayList items;

    public stack()
    {
        items = new ArrayList();
    }

    public Object pop()
    {
        Object out = null;
        if(!isEmpty()){
            out = items.get((items.size() - 1));
            items.remove((items.size() - 1));
        }
        return out;
    }

    public void push(Object in) 
    {
        items.add(in);
    }
    
    public Boolean isEmpty()
    {
        return (items.size() == 0);
    }
}
