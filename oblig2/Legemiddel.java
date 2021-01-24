abstract class Legemiddel {
    protected int ID;
    protected String navn;
    protected double pris;
    protected double virkestoff;
    protected static int teller;


    //Konstruktør som tilegner variabel-verdier til variablene.
    public Legemiddel(String _navn, double _pris, double _virkestoff){
        navn = _navn;
        pris = _pris;
        virkestoff = _virkestoff;
        ID = teller;
        teller++;
    }

    //Metoder for å hente ut variablene til legemidlene.
    public int hentId(){
        return ID;
    }

    public String hentNavn(){
        return navn;
    }

    public double hentPris(){
        return pris;
    }

    public double hentVirkestoff(){
        return virkestoff;
    }

    //Metode for å sette inn ny pris.
    public void settNyPris(double _pris){
        pris = _pris;
    }
    
}