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

}