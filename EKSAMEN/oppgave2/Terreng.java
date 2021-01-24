import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Terreng{
    ArrayList<Sted> steder = new ArrayList<Sted>();

    // Leser fil og lager en liste med steder inkl. beskrivelse av stedet.
    public Terreng(){
        try{
            File fil = new File("steder.txt");
            Scanner inn = new Scanner(fil);
            while (inn.hasNextLine()){
                String beskrivelse = inn.nextLine();
                Sted nyttSted = new Sted(beskrivelse);
                nyttSted.plasserSkatt();
                steder.add(nyttSted);
            }
            inn.close();
            for(int i = 0; i<steder.size();i++){
                if(i+1<steder.size()){
                    steder.get(i).leggTilNesteSted(steder.get(i+1));
                }
                else {
                    steder.get(i).leggTilNesteSted(null);
                }
            }   
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen");
        }

    }
    // Henter ut start fra sted nummer 0 i listen over steder.
    public Sted hentStart(){
        return steder.get(0);
    }
}