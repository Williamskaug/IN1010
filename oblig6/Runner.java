import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

class Runner implements Runnable {
    ReentrantLock lockThread;
    Condition done; 
    Rute currentRute;
    String utvei;
    static AtomicInteger teller = new AtomicInteger(1);


    public Runner(Rute ruteRef, ReentrantLock _lockThread, Condition _done){
        currentRute = ruteRef;
        lockThread = _lockThread;
        done = _done;
        utvei = "";
    }

    //En ekstra konstruktør for å få med utveien for hovedtråden i de nye trådene.
    public Runner(Rute ruteRef, ReentrantLock _lockThread, Condition _done, String _utvei){
        currentRute = ruteRef;
        lockThread = _lockThread;
        done = _done;
        utvei = _utvei;
    }


    @Override
    public void run(){
        Lenkeliste<Rute> muligeRuter = currentRute.hentMuligeRuter();

        //Kjører frem til tråden er på en åpning eller en blindvei.
        while(currentRute.erAapen() == false && muligeRuter.stoerrelse() >= 1){
            currentRute.merk();
            utvei += "("+currentRute.hentKolonne() +","+ currentRute.hentRad()+") -> "; 
            currentRute = muligeRuter.fjern();

            //Oppretter nye tråder dersom det er flere enn en vei å gå.
            for(int i = 0; i < muligeRuter.stoerrelse(); i++){
                teller.incrementAndGet();
                new Thread(new Runner(muligeRuter.hent(i), lockThread, done, utvei)).start();
            }
            muligeRuter = currentRute.hentMuligeRuter();
        }

        //Dersom tråden har kommet til en utvei, legges utveien til i listen.
        if(currentRute.erAapen()){
            utvei += "("+currentRute.hentKolonne() +","+ currentRute.hentRad()+") - Funnet utvei.";
            Labyrint.leggTilUtvei(utvei);
        }

        //Antall tråder reduseres med en.
        int antall = teller.decrementAndGet();

        //Kjører dersom det er null tråder igjen, altså alle er ferdige.
        if(antall == 0){
            try {
                lockThread.lock();
                done.signalAll();
            }
            finally {
                lockThread.unlock();
            }
        }

    }

}