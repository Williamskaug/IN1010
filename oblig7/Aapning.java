class Aapning extends HvitRute {
    public Aapning(int y, int x) {
        super(y, x);
    }

    public char tilTegn() {
        return '.';
    }

    public String type(){
        return "A";
    }
    
    public boolean erAapen(){
        return true;
    }

    //Bruker denne metoden for å printe ut labyrinten visuelt.
    public String toString(){
        return "A";
    }

}