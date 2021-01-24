abstract class Rute implements Comparable<Rute> {
    protected int rad; //Rad
    protected int kolonne; //Kolonne
    protected Rute over;
    protected Rute under;
    protected Rute venstre;
    protected Rute hoyre;
    protected Boolean merket = false;

    //Konstruktør 
    public Rute(int y, int x) {
        rad = y;
        kolonne = x;
    }

    //Bruker en metode merk for å merke ruter som allerede har vært gått gjennom. Dette hindrer gaa()-metoden å gå bakover.
    public void merk(){
        this.merket = true;
    }

    public int hentRad(){
        return rad;
    }

    public int hentKolonne(){
        return kolonne;
    }


    //Metode som returnerer en liste med ruter vi kan gå videre i.
    public Lenkeliste<Rute> hentMuligeRuter(){    
        Lenkeliste<Rute> ruter = new Lenkeliste<Rute>();
        if(over != null){
            if(over.merket == false && over.erHvit() == true) {
                ruter.leggTil(over);
            }
        }
        if(under != null){
            if(under.merket == false && under.erHvit() == true) {
                ruter.leggTil(under);
            }
        }
        if(hoyre != null){
            if(hoyre.merket == false && hoyre.erHvit() == true) {
                ruter.leggTil(hoyre);
            }
        }
        if(venstre != null){
            if(venstre.merket == false && venstre.erHvit() == true) {
                ruter.leggTil(venstre);
            }
        }
        return ruter;
    }

    
    //Metode som setter nabo-verdiene, fra innlesningsmetoden i Labyrint-klassen.
    public void settNabo(Rute _over, Rute _under, Rute _venstre, Rute _hoyre) {
        over = _over;
        under = _under;
        venstre = _venstre;
        hoyre = _hoyre;
    }
    
    abstract boolean erHvit();
    abstract String type();
    abstract boolean erAapen();
    abstract public char tilTegn();
}  