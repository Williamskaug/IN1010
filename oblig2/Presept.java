class Presept extends ReseptHvit {
    public Presept(Legemiddel p, Lege _utskrivendeLege, int _pasientId){
        super(p, _utskrivendeLege, _pasientId, 3);
    }

    //Returnerer prisen til prevansjonsresepter. Trekker fra 108 kroner. Den returnerte prisen blir ikke under 0. 
    public double prisAaBetale(){
        double nyPris = prep.hentPris()-108;
        if(nyPris < 0){
            nyPris = 0;
        }
        return nyPris;
    }

    //Returnerer reseptens "farge"
    public String farge(){
        return "hvit";
    }
}