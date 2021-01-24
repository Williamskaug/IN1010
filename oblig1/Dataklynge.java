
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Dataklynge {
  //Oppretter instansvariabler
  private int noder;
  private int minne;
  private int prosessorer;
  private int noderPerRack;
  private ArrayList<Rack> klyngeArray;

  public Dataklynge(String filnavn){
    Scanner fil = null;

        //Bruker try/catch for å avsluttte dersom filen ikke blir funnet.
        try {
            fil = new Scanner(new File(filnavn));
        }

        catch(Exception e) {
            System.out.print("Fant ikke filen.");
            System.exit(1);
        }

        //Dersom det finnes et neste tall i filen - starter programmet å lese fra fil.
        if(fil.hasNextInt()){

            noderPerRack = fil.nextInt();
            
            //Oppretter en ny rack med x antall noder per rack, henter verdien fra fil.
            Rack rack = new Rack(noderPerRack);
            klyngeArray = new ArrayList<Rack>();
            klyngeArray.add(rack);

            //Dersom filen inneholder en linje til, leser den av antall noder, str minne, antall prosessoter.
            while (fil.hasNextLine()){
                fil.nextLine();
                noder = fil.nextInt();
                minne = fil.nextInt();
                prosessorer = fil.nextInt();
            
                //Bruker verdiene fra fil og oppretter nye noder.
                for(int i=0; i<noder; i++){
                    Node node = new Node(minne, prosessorer);
                    this.settInnNode(node);
                }

            }

            fil.close();
     
        }

    }

  //Metode for å sette inn noder. 
  public void settInnNode(Node node1){
    if(klyngeArray.get(klyngeArray.size()-1).getAntNoder() < noderPerRack){
      klyngeArray.get(klyngeArray.size()-1).settInnNode(node1);
    }
    else {
      Rack rack = new Rack(noderPerRack);
      klyngeArray.add(rack);
      klyngeArray.get(klyngeArray.size()-1).settInnNode(node1);
    }
  }

  //Metode for å finne antall prosessorer, returnerer antall.
  public int antProsessorer(){
    int antall = 0;
    for(int i = 0; i < klyngeArray.size(); i++){
      antall += klyngeArray.get(i).antProsessorer();
    }
    return antall;
  }

  //Metode som returnerer antall racks.
  public int antRacks(){
    return(klyngeArray.size());
  }

  //Metode som returnerer antall noder med nok minne. Nok minne som parameter.
  public int noderMedNokMinne(int antallMinne){
    int antall = 0;
      for(int i = 0; i < klyngeArray.size(); i++){
        antall += klyngeArray.get(i).noderMedNokMinne(antallMinne);
      }
    return antall;
  }
} 