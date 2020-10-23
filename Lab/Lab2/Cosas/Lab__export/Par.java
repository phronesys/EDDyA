public class Par {

    private int id;
    private int dmg;

    public Par(String i, String d)
    {
        this.id = Integer.parseInt(i);
        this.dmg = Integer.parseInt(d);
    }

    public int getId()
    {
        return this.id;
    }
    
    public int getDmg()
    {
        return this.dmg;
    }

    public void setId(String i)
    {
        this.id = Integer.parseInt(i);
    }

    public void setChampId(String d)
    {
        this.dmg = Integer.parseInt(d);
    }
}
