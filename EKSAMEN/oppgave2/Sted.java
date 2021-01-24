public class Sted {
    String beskrivelse;
    Skattkiste kiste;
    Boolean ledig = true;
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
    
    public Boolean erLedig(){
        return ledig;
    }

    public void leggTilNesteSted(Sted neste){
        nesteSted = neste;
    }

    public Sted gaaTilNesteSted(){
        return nesteSted;
    }
}