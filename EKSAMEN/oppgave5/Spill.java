import java.util.Scanner;
import java.util.ArrayList;

public class Spill {
    public static void main(String[] args) {   
            String resultater = "";
            VeivalgTerreng terreng1 = new VeivalgTerreng();  
            Terreng terreng2 =  new Terreng();
            Scanner spiller = new Scanner(System.in); 
            ArrayList<Spiller> spillere = new ArrayList<Spiller>();
            ArrayList<VeivalgSpiller> veivalgspillere = new ArrayList<VeivalgSpiller>();


            Terminal term = new Terminal(spiller);         
            Robot bot = new Robot();
            
            Scanner scan = new Scanner(System.in);

            //Tilfeldig eller vanlig sti
            String[] alt = {"   1. Vanlig", "   2. Tilfeldig"};
            int svar = term.beOmKommando("Vanlig sti eller tilfeldig sti?", alt); 

            if(svar == 2){
                System.out.println("Tilfeldig vei: ");
                System.out.println("Hvor mange spillere?");
                int antallspillere = Integer.parseInt(scan.nextLine().trim());

                for(int i = 0; i < antallspillere; i++){
                    veivalgspillere.add(new VeivalgSpiller(terreng1.hentStart(), bot, ("Spiller"+(i+1))));
                }

                System.out.println("Hvor mange trekk vil dere spille?");
                int antalltrekk = Integer.parseInt(scan.nextLine().trim());

                for(int a = 0; a < antalltrekk; a++){
                        for(int b = 0; b < veivalgspillere.size(); b++){
                            veivalgspillere.get(b).nesteTrekk();
                        }
                }

                for(int b = 0; b < veivalgspillere.size(); b++){
                    System.out.println(veivalgspillere.get(b).hentResultat());
                }
            }


            else {
                System.out.println("Vanlig vei: ");
                System.out.println("Hvor mange spillere?");
                int antallspillere = Integer.parseInt(scan.nextLine().trim());

                for(int i = 0; i < antallspillere; i++){
                    spillere.add(new Spiller(terreng2.hentStart(), bot, ("Spiller"+(i+1))));
                }

                System.out.println("Hvor mange trekk vil dere spille?");
                int antalltrekk = Integer.parseInt(scan.nextLine().trim());

                for(int a = 0; a < antalltrekk; a++){
                        for(int b = 0; b < spillere.size(); b++){
                            spillere.get(b).nesteTrekk();
                        }
                    }

                for(int b = 0; b < spillere.size(); b++){
                    System.out.println(spillere.get(b).hentResultat());
                }
            }

    }
}
