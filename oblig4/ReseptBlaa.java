class ReseptBlaa extends Resept {
    int pris; 
    public ReseptBlaa(Legemiddel p, Lege _utskrivendeLege, Pasient _pasient, int _reit){
        super(p, _utskrivendeLege, _pasient, _reit);
    }

    //Returnerer prisen, som tilsvarer 75% av opprinnelig pris.
    public double prisAaBetale(){
        return prep.hentPris()*0.75;
    }

    //Returnerer reseptens "farge"
    public String farge(){
        return "blaa";
    }

    @Override
    public int compareTo(Resept o) {
        return 0;
    }
}
