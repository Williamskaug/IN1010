class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{
    
    //Metode som legger til nye verdier x i listen, sortert etter størrelse.
    @Override
    public void leggTil(T x) {
        Node a = start;
        Node ny = new Node(x);

        //Legger til ny verdi i første posisjon dersom listen er tom.
        if (lengde == 0) {
            super.leggTil(0, x);
            return;
        }

        //For-løkke som travasjerer gjennom listen og legger til verdien før noden som har mindre eller lik verdi.
        for (int i = 0; i < lengde; i++) {
            a = a.neste;
            if(ny.compareTo(a) <= 0) {
                super.leggTil(i,x);
                break;
            }
        }

        //Tester om den nye verdien er høyere enn a.
        if (ny.compareTo(a) > 0 )
            super.leggTil(lengde,x);
            return;
    }

    //Metode som fjerner det siste elementet(også største i denne listen)
    public T fjern(){
        return fjern(lengde-1);
    }

    //Bruker @override fordi det ikke skal gå å legge til i en bestemt posisjon, da dette ville ødelagt rekkefølgen.
    @Override
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException();
    }

    @Override
    public void sett(int pos, T x){
        throw new UnsupportedOperationException();
    }
}