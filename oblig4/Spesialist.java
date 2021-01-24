class Spesialist extends Lege implements GodkjenningsFritak{
    private int kontrollID;

    //Spesialist-objektet tar både inn spesialistens navn og deres kontrollID.
    public Spesialist(String navn, int kontrollID){
        super(navn);
        this.kontrollID = kontrollID;
    }

    //Kaller på implement-klassen GodkjenningsFritak.
    @Override
    public int hentKontrollID(){
        return kontrollID;
    }

    @Override
    public String toString() {
        return super.toString() + ", kontrollID: " + kontrollID + " ";
    }

}
