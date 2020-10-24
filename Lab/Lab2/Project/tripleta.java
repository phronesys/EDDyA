public class tripleta {
    private int id;
    private int dmg;

    public tripleta(String id, String dmg){
        this.id = Integer.parseInt(id);
        this.dmg = Integer.parseInt(dmg);
    }

    public int getId(){ return this.id; }
    public int getDmg(){ return this.dmg; }

    public void setId(String id){ this.id = Integer.parseInt(id); }
    public void setDmg(String dmg){ this.dmg = Integer.parseInt(dmg); }
}
