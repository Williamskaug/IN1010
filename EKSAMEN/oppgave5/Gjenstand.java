class Gjenstand {
    String navn;
    int verdi;

    public Gjenstand(String _navn, int _verdi){
        navn = _navn;
        verdi = _verdi;
    }

    public int hentVerdi(){
        return verdi;
    }

    public String hentNavn(){
        return navn;
    }
}