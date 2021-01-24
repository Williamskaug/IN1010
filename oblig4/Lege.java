class Lege implements Comparable<Lege> {
    protected String navn;
    static SortertLenkeliste sortertLegeliste = new SortertLenkeliste();
    private Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();
    //Lege-objektets konstruktør tar kun inn navnet til legen.
    public Lege(String navn){
        this.navn = navn;
    }

    //Returnerer legens nanv
    public String hentNavn(){
        return navn;
    }

    @Override
    public String toString() {
        return navn + " ";
    }

    public void sorterLege(){
        sortertLegeliste.leggTil(navn);
    }        

    public SortertLenkeliste hentLegeliste(){
        return sortertLegeliste;
    }

    public int compareTo(Lege navn){
        return 0;
    }
    public Lenkeliste<Resept> hentReseptliste(){
        return utskrevedeResepter;
    }
    
    public ReseptHvit skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if(legemiddel instanceof Narkotisk){
            if(this instanceof Spesialist){
                ReseptHvit nyResept = new ReseptHvit(legemiddel, this, pasient, reit);
                utskrevedeResepter.leggTil(nyResept);
                pasient.leggTil(nyResept);
                return nyResept;
            }else{
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else{ 
            ReseptHvit nyResept = new ReseptHvit(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(nyResept);
            pasient.leggTil(nyResept);
            return nyResept;
        }  
    }

    public Militarresept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            if(this instanceof Spesialist){
                Militarresept nyResept = new Militarresept(legemiddel, this, pasient, reit);
                utskrevedeResepter.leggTil(nyResept);
                pasient.leggTil(nyResept);
                return nyResept;
            }else{
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else{ 
            Militarresept nyResept = new Militarresept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(nyResept);
            pasient.leggTil(nyResept);
            return nyResept;
        }  
    }

    public Presept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            if(this instanceof Spesialist){
                Presept nyResept = new Presept(legemiddel, this, pasient);
                utskrevedeResepter.leggTil(nyResept);
                pasient.leggTil(nyResept);
                return nyResept;
            }else{
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else{ 
            Presept nyResept = new Presept(legemiddel, this, pasient);
            utskrevedeResepter.leggTil(nyResept);
            pasient.leggTil(nyResept);
            return nyResept;
        }  

    }

    public ReseptBlaa skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            if(this instanceof Spesialist){
                ReseptBlaa nyResept = new ReseptBlaa(legemiddel, this, pasient, reit);
                utskrevedeResepter.leggTil(nyResept);
                pasient.leggTil(nyResept);
                return nyResept;
            }else{
                throw new UlovligUtskrift(this, legemiddel);
            }
        }
        else{ 
            ReseptBlaa nyResept = new ReseptBlaa(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(nyResept);
            pasient.leggTil(nyResept);
            return nyResept;
        }  
    }

}