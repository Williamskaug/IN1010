import java.util.Scanner;

public class Terminal implements Brukergrensesnitt {
    Scanner scan;
    int svar;

    public Terminal(Scanner _scan){
        scan = _scan;
    }

    @Override
    public void giStatus(String status) {
        System.out.println(status);
    }

    //Metode som tar inn spørsmål og svaralternativer, og returnerer brukerens svar.
    @Override
    public int beOmKommando(String spoersmaal, String[] alternativer) {
        System.out.println(spoersmaal);

        for(int i = 0; i<alternativer.length;i++){
            System.out.println("\n"+alternativer[i]);
        }

        String[] valg = scan.nextLine().split(" ",0);
        try {
            svar = Integer.parseInt(valg[0]);
        } catch(Exception e){
            System.out.println("Du skrev inn en ugyldig verdi.");
            beOmKommando(spoersmaal, alternativer);
        }

        return svar;
    }
}