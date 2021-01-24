abstract class Resept {
    //Definerer instansvariabler
    private int id;
    private int pasientId;
    private int reit;
    private Lege utskrivendeLege;
    protected Legemiddel prep; 
    private static int teller; 

    //Konstruktør for resept-klassen
    public Resept(Legemiddel p, Lege _utskrivendeLege, int _pasientId, int _reit){
        prep = p;
        utskrivendeLege = _utskrivendeLege;
        pasientId = _pasientId;
        reit = _reit;
        teller++;
        id = teller;
    }

    //Metoder som returnerer instansvariablene
    public int hentId(){
        return id;
    }

    public Legemiddel hentLegemiddel(){
        return prep;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public int hentPasientId(){
        return pasientId;
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


}
