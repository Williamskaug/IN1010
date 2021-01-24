import java.io.File;
import java.io.IOException;

public class OpprettFil {
    public static void fil(){
        try{
            File nyFil = new File("utskrift.txt");

            if (nyFil.createNewFile()) {
                System.out.println("Fil opprettet: " + nyFil.getName());
            } else {
                System.out.println("Fil finnes allerede.");
        }
        }

        catch(IOException e){
            System.out.println("Feil i opprettning av fil");
        }
    }

}
