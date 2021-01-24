import java.util.ArrayList;
import java.util.Random;

public class VeivalgSted extends Sted {
    ArrayList<VeivalgSted> steder = VeivalgTerreng.steder2; 
    VeivalgSted veivalg;
    int rand;

    public VeivalgSted(String beskrivelse) {
        super(beskrivelse);
    }


    public VeivalgSted nesteSted(int valg){
        Random tilfeldig = new Random();

        if(valg == 1){
            rand = tilfeldig.nextInt(steder.size()-1)+1;
            veivalg = steder.get(rand);
        }
        else if(valg == 2){
            rand = tilfeldig.nextInt(steder.size()-1)+1;
            veivalg = steder.get(rand);
        }
        else if(valg == 3){
            rand = tilfeldig.nextInt(steder.size()-1)+1;
            veivalg = steder.get(rand);
        }

        try {
            steder.remove(rand);
        }
        catch(Exception a){}
        return veivalg;
    }   

    public int hentLengde(){         
        return steder.size();     
    } 
}