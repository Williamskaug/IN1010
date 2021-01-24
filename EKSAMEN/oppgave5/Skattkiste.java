import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Skattkiste {
    ArrayList<Gjenstand> innhold = LesfraFil();
    
    //Leser inn alle gjenstandene fra Gjenstander.txt, og returnerer en liste med 5 tilfeldige av gjentandene. Dette gjør at hver skattekiste vil være forskjellig.
    public ArrayList<Gjenstand> LesfraFil(){
        ArrayList<Gjenstand> listeinnhold = new ArrayList<Gjenstand>();
        ArrayList<Gjenstand> returListe = new ArrayList<Gjenstand>();
        try {
            File fil = new File("gjenstander.txt");
            Scanner scan = new Scanner(fil);
            while (scan.hasNextLine()) {
              String data = scan.nextLine();
              String[] datal = data.split(" ", 2);
              Gjenstand nyGjenstand = new Gjenstand(datal[0], Integer.parseInt(datal[1]));
              listeinnhold.add(nyGjenstand);
            }
            scan.close();
          } 
          
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        //Lager en liste med 5 tilfeldige gjenstander som skal i skattekister.
        for(int i = 0; i < 5; i++){
            int randint = (int)(Math.random() * listeinnhold.size());
            Gjenstand tilfeldig = listeinnhold.get(randint);
            listeinnhold.remove(randint);
            returListe.add(tilfeldig);
        }
        return returListe;
    }

    //Returnerer en tilfeldig gjenstand fra skattekisten.
    public Gjenstand hentSkatt(){
        int Randint = (int)(Math.random() * innhold.size());
        Gjenstand x = innhold.get(Randint);
        innhold.remove(Randint);
        return x;
    }

    public int leggNed(Gjenstand x){
        innhold.add(x);
        int verdi = x.hentVerdi()/10 * 8 + (int)(Math.random() * 12);
        return verdi;
    }

    //Trenger en metode for å tømme skattekisten, da vi benytter skattekiste-klassen til "ryggsekk"-objekter.
    public void tomRyggsekk(){
        while(innhold.size() > 0){
            innhold.remove(0);
        }
    }

    public int antGjenstander(){
        return innhold.size();
    }

    public void fjern(int pos){
        innhold.remove(pos);
    }
    
    public ArrayList<Gjenstand> returnerInnhold(){
        return innhold;
    }
}