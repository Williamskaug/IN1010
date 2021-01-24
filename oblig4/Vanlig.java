class Vanlig extends Legemiddel {
    public Vanlig(String _navn, double _pris, double _virkestoff){
        super(_navn, _pris, _virkestoff);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int compareTo(Legemiddel o) {
        return 0;
    }
}