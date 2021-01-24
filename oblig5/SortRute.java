class SortRute extends Rute{
    public SortRute(int y, int x){
        super(y, x);
    }

    public char tilTegn() {
        return '#';
    }

    //Bruker denne metoden for å printe ut labyrinten visuelt.
    public String toString(){
        return "#";
    }

    @Override
    public void gaa(String _utveier){
        //Tom metode for å avslutte denne gaa()-løkken dersom den går til en sort rute.
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

}