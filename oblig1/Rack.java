class Rack {
  private Node[] rackArray;


  //Metode for å opprette en ny rack med plass til antNoder antall noder.
  public Rack(int antNoder){
    rackArray = new Node[antNoder];
  }

  //Metode for å legge til en node i en ledig rack. Travasjerer Arrayet til den finner en "tom" plass hvor den legger til noden, deretter hopper dne ut av løkken.
  public void settInnNode(Node node){
    for(int i = 0; i < rackArray.length; i++){
      if(rackArray[i] == null){
        rackArray[i] = node;
        break;
      }
    }
  }

  //Metode som returner antall noder i en rack.
  public int getAntNoder() {
    int teller = 0;
    for(int i = 0; i < rackArray.length; i++){
      if(rackArray[i] != null){
        teller++;
      }
    }
    return teller;
  }

  //Metode som returnerer antall prosessorer i en rack.
  public int antProsessorer(){
    int antall = 0;
    for(int i = 0; i < rackArray.length; i++){
      if(rackArray[i] != null){
        antall += rackArray[i].antProsessorer();
      }
    }
    return antall;
  }


  //Metode som returnerer antall noder med nok minne. Nok minne som parameter.
  public int noderMedNokMinne(int paakrevdMinne){
      int antall = 0;
      for(int i = 0; i < rackArray.length; i++){
        if(rackArray[i] != null){
          if(rackArray[i].nokMinne(paakrevdMinne)){
            antall++;
          }
        }
      }
      return antall;
  }
}