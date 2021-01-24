public class Sted {
    String beskrivelse;
    Skattkiste kiste;
    Sted nesteSted;

    public Sted(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }

    public void plasserSkatt(){
        kiste = new Skattkiste();
    }

    public Skattkiste hentKiste(){
        return kiste; 
    }

    public String hentBeskrivelse(){
        return beskrivelse;
    }

    public void leggTilNesteSted(Sted neste){
        nesteSted = neste;
    }

    public Sted gaaTilNesteSted(){
        return nesteSted;
    }
}