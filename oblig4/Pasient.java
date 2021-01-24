class Pasient implements Comparable<Pasient> {
    protected String fodselsnr;
    protected String navn;
    protected int id;
    protected static int teller = 0;

    protected Stabel<Resept> reseptListe = new Stabel<Resept>();


    public Pasient(String _fodselsnr, String _navn){
        fodselsnr = _fodselsnr;
        navn = _navn;

        id = teller;
        teller++;
    }

    public Stabel hentReseptliste(){
        return reseptListe;
    }
    //Legger til en resept i listen.
    public void leggTil(Resept x){
        reseptListe.leggPaa(x);
    }

    //Skriver ut hele reseptlisten.
    public void hentUt(){
        int a = 0;
        while(a < reseptListe.stoerrelse()){
            System.out.println(reseptListe.taAv());
        }
    }

    //La til denne for å kunne finne pasienten i TestLegesystem.
    public int hentId(){
        return id;
    }


    @Override
    public String toString() {
        return "PasientFodselnr: " + fodselsnr  + ", pasientens navn: " + navn + " " + "id: " + id;
    }

    public String printResept() {
        String result = "";
        for (int i = 0; i < reseptListe.stoerrelse(); i++) {
            result += i + ": " + reseptListe.hent(i).toString();
            result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(Pasient o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
