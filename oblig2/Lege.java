class Lege {
    private String navn;

    //Lege-objektets konstruktør tar kun inn navnet til legen.
    public Lege(String navn){
        this.navn = navn;
    }

    //Returnerer legens nanv
    public String hentNavn(){
        return navn;
    } 
}
