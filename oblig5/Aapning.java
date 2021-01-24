class Aapning extends HvitRute {
    public Aapning(int y, int x) {
        super(y, x);
    }

    public char tilTegn(){
        return '.';
    }

    //Bruker denne metoden for å printe ut labyrinten visuelt.
    public String toString(){
        return "A";
    }
    
    //Metode som overskriver gaa()-metoden og sender listen med utveier til labyrintklassen.
    @Override
    public void gaa(String _utveier){
        _utveier += ("("+this.rad +","+ this.kolonne+") - Funnet utvei.");
        Labyrint.leggTilUtvei(_utveier);
    }
}