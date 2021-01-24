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

    //Metode som overskriver gaa()-metoden, kaller på naboruter.
    @Override
    public void gaa(String _utveier){
        try {
            this.Merk();
            _utveier += ("("+this.rad +","+ this.kolonne+") -> ");

                if(over.merket == false) {
                    over.gaa(_utveier);
                }
                if(under.merket == false){
                    under.gaa(_utveier);
                }
                if(hoyre.merket == false){
                    hoyre.gaa(_utveier);
                }
                if(venstre.merket == false){
                    venstre.gaa(_utveier);
                }

        } catch(Exception e) {
            System.out.println("Exception");
        }
        
    }

    @Override
    public int compareTo(String o) {
        // TODO Auto-generated method stub
        return 0;
    }

}