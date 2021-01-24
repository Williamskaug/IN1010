class SortRute extends Rute{
    public SortRute(int y, int x){
        super(y, x);
        this.merk();
    }

    public char tilTegn() {
        return '#';
    }

    public String type(){
        return "S";
    }

    //Bruker denne metoden for å printe ut labyrinten visuelt.
    public String toString(){
        return "#";
    }

    public boolean erAapen(){
        return false;
    }

    public boolean erHvit(){
        return false;
    }
    
    @Override
    public int compareTo(Rute o) {
        // TODO Auto-generated method stub
        return 0;
    }

}