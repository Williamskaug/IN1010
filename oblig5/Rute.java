abstract class Rute implements Comparable<String> {
    protected int rad; //Rad
    protected int kolonne; //Kolonne
    protected Rute over;
    protected Rute under;
    protected Rute venstre;
    protected Rute hoyre;
    protected Boolean merket = false;

    //Oppretter en string av koordinater for hver utvei.
    //String utveier = "";

    //Lenkeliste med utveier som blir returnert.

    //Konstruktør 
    public Rute(int y, int x) {
        rad = y;
        kolonne = x;
    }

    //Bruker en metode merk for å merke ruter som allerede har vært gått gjennom. Dette hindrer gaa()-metoden å gå bakover.
    public void Merk(){
        this.merket = true;
    }

    //Metode som setter nabo-verdiene, fra innlesningsmetoden i Labyrint-klassen.
    public void settNabo(Rute _over, Rute _under, Rute _venstre, Rute _hoyre) {
        over = _over;
        under = _under;
        venstre = _venstre;
        hoyre = _hoyre;
    }

    abstract public char tilTegn();

    //Rekursiv metode som kaller seg selv på neste ledige ruter. Finner utveien.
    public void gaa(String _utveier){
        this.Merk();
        over.gaa(_utveier);
        under.gaa(_utveier);
        hoyre.gaa(_utveier);
        venstre.gaa(_utveier);
    }

    //Funksjon som kaller den første gaa()-metoden og returnerer listen med utveier når rekursjonen er ferdig.
    public void finnUtvei(){
        gaa("");
    }
}  