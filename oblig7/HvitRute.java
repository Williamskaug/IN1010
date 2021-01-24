class HvitRute extends Rute {  
    public HvitRute(int y, int x) {
        super(y, x);
    }

    public char tilTegn() {
        return '.';
    }

    //Bruker denne metoden for å printe ut labyrinten visuelt.
    public String toString(){
        return ".";
    }

    public String type(){
        return "H";
    }

    public boolean erAapen(){
        return false;
    }

    public boolean erHvit(){
        return true;
    }

    @Override
    public int compareTo(Rute o) {
        // TODO Auto-generated method stub
        return 0;
    }


}