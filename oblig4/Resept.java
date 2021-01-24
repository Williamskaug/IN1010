abstract class Resept implements Comparable<Resept> {
    //Definerer instansvariabler
    private int id;
    private Pasient pasient;
    private int reit;
    private Lege utskrivendeLege;
    protected Legemiddel prep;
    private static int teller = 0;

    //Konstruktør for resept-klassen
    public Resept(Legemiddel p, Lege _utskrivendeLege, Pasient _pasient, int _reit){
        prep = p;
        utskrivendeLege = _utskrivendeLege;
        pasient = _pasient;
        reit = _reit;
        teller++;
        id = teller;
    }


    //Metoder som returnerer instansvariablene
    public int hentId(){
        return id;
    }

    public Pasient hentPasient(){
        return pasient;
    }

    public Legemiddel hentLegemiddel(){
        return prep;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    //Litt usikker på om vi kan kalle id på denne måten. !!!!!
    public int hentPasientId(){
        return pasient.id;
    }

    public int hentReit(){
        return reit;
    }

    //Når denne funksjonen kalles vil den trekke fra 1 fra reit, dersom det er flere reit igjen. Deretter vil den returnere true/false, avhengig om det var flere igjen.
    public boolean bruk(){
        if(reit > 0){
            reit = reit - 1;
            return true;
        }
        else {
            return false;
        }
    }


    public abstract String farge();
    public abstract double prisAaBetale();

    public String toString() {
        return prep + ",resept id: " + id + " , pasient: " + pasient +
        ", utskrevet av lege: " + utskrivendeLege + ", antall resepter igjen: " + reit;
    }

}
