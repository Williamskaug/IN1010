class Militarresept extends ReseptHvit {
    public Militarresept(Legemiddel p, Lege _utskrivendeLege, Pasient _pasient, int _reit){
        super(p, _utskrivendeLege, _pasient, _reit);
    }

    //Returnerer prisen, som for militær-resepter er 0.
    public double prisAaBetale(){
        return 0;
    }

    //Returnerer reseptens "farge"
    public String farge(){
        return "hvit";
    }
}