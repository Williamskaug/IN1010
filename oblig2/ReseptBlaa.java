class ReseptBlaa extends Resept {
    int pris; 
    public ReseptBlaa(Legemiddel p, Lege _utskrivendeLege, int _pasientId, int _reit){
        super(p, _utskrivendeLege, _pasientId, _reit);
    }

    //Returnerer prisen, som tilsvarer 75% av opprinnelig pris.
    public double prisAaBetale(){
        return prep.hentPris()*0.75;
    }

    //Returnerer reseptens "farge"
    public String farge(){
        return "blaa";
    }
}
