import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Labyrint implements Comparable<String>{
    static Rute[][] RuteArr;
    static int kolonner;
    static int rader;

    ReentrantLock lockThread = new ReentrantLock();
    Condition done = lockThread.newCondition(); 

    public static Lenkeliste<String> utskrift;

    //Konstruktøren er privat, så labyrinter kan kun opprettes fra denne klassen.
    private Labyrint(Rute[][] _RuteArr, int _kolonner, int _rader){
        RuteArr = _RuteArr;
        kolonner = _kolonner;
        rader = _rader;
    }

    //Metode for å finne utveien fra en bestemt koordinat i labyrinten.
    public Lenkeliste<String> finnUtveiFra(int startKolonne, int startRad){
        utskrift = new Lenkeliste<String>();
        
        if(RuteArr[startKolonne][startRad].tilTegn() == '.'){
            Runnable runner = new Runner(RuteArr[startKolonne][startRad], lockThread, done);

            try {
                lockThread.lock();
                new Thread(runner).start();
                done.await();
            } 
            catch (InterruptedException i) {
                System.out.print(i);
            } 
            finally {
                lockThread.unlock();
            }

            avMerkAlle();
            Runner.teller.set(1);
            return utskrift;
        }

        else{
            System.out.println("Du maa starte i en gyldig rute.");
            return utskrift;
        }

    }

    public static void leggTilUtvei(String x){
        utskrift.leggTil(x);
    }

    public void avMerkAlle(){
        for(int a = 0; a < rader; a++){
            for(int b = 0; b < kolonner; b++){
                RuteArr[a][b].merket = false;
            }
        }

    };

    //Metode som leser inn labyrinten fra en fil og setter naboene til rutene.
    public static Labyrint lesFraFil(File fil) throws FileNotFoundException{
            int rad = 0;
            int kolonne = 0;

            try {
                //Oppretter filscanner.
                Scanner sc = new Scanner(fil);
    
                String[] linje = sc.nextLine().split(" ",0);
                rad = Integer.parseInt(linje[0]);
                kolonne = Integer.parseInt(linje[1]);
                RuteArr = new Rute[rad][kolonne];
    
    
                //Leser inn og oppretter Rute-objekter
                Rute ny;
                for(int a = 0; a < rad; a++){
                    linje = sc.nextLine().split("",0);
                    for(int b = 0; b < kolonne; b++){
                        if(linje[b].equals(".")){
                            if(a == 0 || b == 0 || a == rad-1 || b == kolonne-1){
                                ny = new Aapning(a, b);
                            }
                            else {
                                ny = new HvitRute(a, b);
                            }
                        }
                        else{
                            ny = new SortRute(a, b);
                        }
                        RuteArr[a][b] = ny;
                    }
                }

                //Avslutter scanner-funksjonen
                sc.close();
    
                //Finner naboer
                for(int a = 0; a < rad; a++){
                    for(int b = 0; b < kolonne; b++){
                        Rute over;
                        Rute under;
                        Rute venstre;
                        Rute hoyre;
    
                        //Over
                        if(a==0){
                            over = null;
                        }else{
                            over = RuteArr[a-1][b];
                        }
    
                        //Under
                        if(a == rad-1){
                            under = null;
                        }else{
                            under = RuteArr[a+1][b];
                        }
    
                        //Venstre
                        if(b==0){
                            venstre = null;
                        }else{
                            venstre = RuteArr[a][b-1];
                        }
    
                        //Høyre
                        if(b == kolonne-1){
                            hoyre = null;
                        }else{
                            hoyre = RuteArr[a][b+1];
                        }
    
                        //Kaller på settNabo-metoden i Rute-klassen.
                        RuteArr[a][b].settNabo(over, under, venstre, hoyre);
                    
                    }
                }
    
                //Printer ut labyrinten
                for(int a = 0; a < rad; a++){
                    for(int b = 0; b < kolonne; b++){
                        System.out.print(RuteArr[a][b]);
                    }
                    System.out.print("\n");
                }
    
            } catch (FileNotFoundException e) {
                //TODO: handle exception
            }
            Labyrint nyLab = new Labyrint(RuteArr, kolonne, rad);
            return nyLab;
    }

    @Override
    public int compareTo(String o) {
        // TODO Auto-generated method stub
        return 0;
    }
}