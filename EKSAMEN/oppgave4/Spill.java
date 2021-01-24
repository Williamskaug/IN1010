import java.util.Scanner;

public class Spill {
    public static void main(String[] args) {   
            String resultater = "";
            VeivalgTerreng terreng1 = new VeivalgTerreng();  
            Terreng terreng2 =  new Terreng();   
            Scanner spiller = new Scanner(System.in);        
            Terminal term = new Terminal(spiller);         
            Robot bot = new Robot();      

            String[] alt = {"   1. Vanlig", "   2. Tilfeldig"};
            int svar = term.beOmKommando("Vanlig sti eller tilfeldig sti?", alt); 

            if(svar == 2){
                VeivalgSpiller spiller1 = new VeivalgSpiller(terreng1.hentStart(),term, "Erna Solberg");
                spiller1.nesteTrekk();   
                resultater = spiller1.hentResultat();
            }
            else {
                Spiller spiller1 = new Spiller(terreng2.hentStart(),term, "Erna Solberg");
                spiller1.nesteTrekk();   
                resultater = spiller1.hentResultat();
            }

            System.out.println("");
            System.out.println("RESULTATER:");
            System.out.println(resultater);
    }
}
