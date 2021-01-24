class Node {
  private int minne;
  private int prosessorer;

  //Opretter en node, hvor minne og antall prosessorer er parameter.
  public Node(int minne, int antProsessorer){
    this.minne = minne;
    this.prosessorer = antProsessorer;
  }

  //Metode for å returnere antall prosessorer
  public int antProsessorer(){
    return prosessorer;
  }

  //Metode for å returnere om en node har mer en x antall gb minne. x er fra 
  public boolean nokMinne(int paakrevdMinne){
    return(minne >= paakrevdMinne);
  }
  
}