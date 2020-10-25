public class tripleta {
    private int id;
    private int dmg;
    private String champ;

    public tripleta(int id, int dmg, String champ){
        this.id = id;
        this.dmg = dmg;
        this.champ = champ;
    }

    public int getId(){ return this.id; }
    public int getDmg(){ return this.dmg; }
    public String getChamp(){ return this.champ; }

    public void setId(int id){ this.id = id; }
    public void setDmg(int dmg){ this.dmg = dmg; }
    public void setChamp(String champ){ this.champ = champ; }
}
