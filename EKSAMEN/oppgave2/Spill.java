import java.util.Scanner;

public class Spill {
    public static void main(String[] args){
        Terreng terreng = new Terreng();    
        Scanner spiller = new Scanner(System.in);
        Terminal term = new Terminal(spiller);
        Robot bot = new Robot();
    
        //Endre term til bot for å kjøre roboten.
        Spiller spiller1 = new Spiller(terreng.hentStart(), term, "Jørgen");
        spiller1.nesteTrekk();

        System.out.println("Resultat:");
        System.out.println(spiller1.hentResultat());

        GUI.main(args);
    }   
}