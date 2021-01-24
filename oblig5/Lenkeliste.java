import java.util.Iterator;

class Lenkeliste<T extends Comparable<T>> implements Liste<T>{
    protected int lengde;
    protected Node start, slutt;

    //Oppretter nodeklassen inne i Lenkelisten, blir kun brukt gjennom Lenkeliste-klassen.
    public class Node {
        public T verdi;
        public Node neste;
        public Node forrige;

        public Node(T verdi){
            this.verdi = verdi;
        }

        public int compareTo(Node andre){
            return verdi.compareTo(andre.verdi);
        }
    }

    //Kontruktør
    public Lenkeliste(){
        lengde = 0;
        start = new Node(null);
        slutt = new Node(null);
        start.neste = slutt;
        slutt.forrige = start;
    }

    //Funksjon som legger til, uten å overskrive.
    public void leggTil(int pos, T x){
        if (pos > lengde || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }
        Node ny = new Node(x);
        Node foran = start;

        for (int i = 0; i<pos; i++){
            foran = foran.neste;
        }

        ny.neste = foran.neste;
        ny.neste.forrige = ny;
        ny.forrige = foran;
        foran.neste = ny;
        lengde++;
    }


    //Metode som legger til en node på slutten av lenkelisten
    public void leggTil(T x){
        Node ny = new Node(x);
        ny.forrige = slutt.forrige;
        ny.forrige.neste = ny;
        ny.neste = slutt;
        slutt.forrige = ny;

        lengde ++;
    }


    //Metode som legger til en ny node, og overskriver noden i den gitte posisjonen.
    public void sett(int pos, T x){
        Node ny = new Node(x);
        Node temp = start.neste;
        if (pos >= 0 && pos < lengde){
            for (int i = 0; i < pos; i++){
                temp = temp.neste;
            }
            temp.verdi = ny.verdi;
        }else{
            throw new UgyldigListeIndeks(pos);
        }
    }

    //Funksjon som returnerer verdien til en gitt nodes posisjon.
    public T hent(int pos){
        if(pos<lengde && pos>=0){
            Node a = start;
            for (int i=0;i<=pos;i++){
                a = a.neste;
            }
            return a.verdi;
        } else {
            throw new UgyldigListeIndeks(pos);
        }
    }


    //Funksjon som fjerner en node fra en gitt posisjon og returnerer nodens verdi.
    public T fjern(int pos){
        Node a = start;
        Node fjernet;
        if(pos<lengde && pos>=0){
            for (int i=0; i < pos; i++){
                a  = a.neste;
            }
            lengde--;
            fjernet = a.neste;
            a.neste = fjernet.neste;
            a.neste.forrige = a.neste.forrige.forrige;
        }else

        {
            throw new UgyldigListeIndeks(pos);
        }
        return fjernet.verdi;
    }


    //Funksjon som fjerner den første noden i lenkelisten og returnerer dens verdi.
    public T fjern(){
        Node fjernet;
        if(lengde>0){
            Node a = start;
            fjernet = a.neste;
            a.neste = a.neste.neste;
            a.neste.forrige = a.neste.forrige.forrige;
            lengde--;
        }
        else{
            throw new UgyldigListeIndeks(-1);
        }
        return fjernet.verdi;
    }

    //Funksjon som returnerer lengden til lenkelisten
    public int stoerrelse(){
        return lengde;
    }

    class LenkelisteIterator implements Iterator<T>{
        Node her = start;

        public boolean hasNext(){
            return her != slutt.forrige;
        }

        public T next(){
            her = her.neste;
            return her.verdi;
        }

    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}
