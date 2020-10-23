public class Tripleta {

    private int id;
    private int dmg;
    private String hero;

    public Tripleta(String i, String d, String h)
    {
        this.id = Integer.parseInt(i);
        this.dmg = Integer.parseInt(d);
        this.hero = h;
    }

    public int getId()
    {
        return this.id;
    }
    
    public int getDmg()
    {
        return this.dmg;
    }

    public String getHero()
    {
        return this.hero;
    }

    public void setId(String i)
    {
        this.id = Integer.parseInt(i);
    }

    public void setDmg(String d)
    {
        this.dmg = Integer.parseInt(d);
    }

    public void setHero(String h)
    {
        this.hero = h;
    }
}
