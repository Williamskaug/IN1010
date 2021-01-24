class ReseptHvit extends Resept{
    public ReseptHvit(Legemiddel p, Lege _utskrivendeLege, Pasient _pasient, int _reit){
        super(p, _utskrivendeLege, _pasient, _reit);
    }

    //Returnerer reseptens "farge"
    public String farge(){
        return "hvit";
    }

    //Returnerer prisen
    public double prisAaBetale(){
        return prep.hentPris();
    }

    @Override
    public int compareTo(Resept o) {
        // TODO Auto-generated method stub
        return 0;
    }

}   
