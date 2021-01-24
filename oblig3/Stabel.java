class Stabel<T  extends Comparable<T>> extends Lenkeliste<T>{
    //Kaller på funksjonen leggTil() fra klassen Lenkeliste. 
    public void leggPaa (T x){
        leggTil(x);
    }

    //Fjerner det siste elementet ved å  kalle på funksjonen fjern(pos) fra Lenkeliste og setter inn den siste posisjonen i listen. 
    public T taAv(){
        return fjern(lengde-1);
    }
}