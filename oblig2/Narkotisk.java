class Narkotisk extends Legemiddel {
    int narkotiskStyrke;

    public Narkotisk(String _navn, double _pris, double _virkestoff, int _narkotiskStyrke){
        super(_navn, _pris, _virkestoff);
        narkotiskStyrke = _narkotiskStyrke;
    }

    //Returnerer styrke
    public int hentNarkotiskStyrke(){
        return narkotiskStyrke;
    }

}