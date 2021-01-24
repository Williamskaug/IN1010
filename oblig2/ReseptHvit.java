class ReseptHvit extends Resept{
    public ReseptHvit(Legemiddel p, Lege _utskrivendeLege, int _pasientId, int _reit){
        super(p, _utskrivendeLege, _pasientId, _reit);
    }

    //Returnerer reseptens "farge"
    public String farge(){
        return "hvit";
    }

    //Returnerer prisen
    public double prisAaBetale(){
        return prep.hentPris();
    }

}   
