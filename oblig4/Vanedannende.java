class Vanedannende extends Legemiddel {
    int vanedannendeStyrke;

    public Vanedannende(String _navn, double _pris, double _virkestoff, int _vanedannendeStyrke){
        super(_navn, _pris, _virkestoff);
        vanedannendeStyrke = _vanedannendeStyrke;
    }

    //Returnerer styrken
    public int hentVanedannendeStyrke(){
        return vanedannendeStyrke;
    }

    @Override
    public String toString() {
        return super.toString() + " vanedannende styrke: " + vanedannendeStyrke + " ";
    }   

    @Override
    public int compareTo(Legemiddel o) {
        return 0;
    }


}
