class TestResepter {
    public static void main(String[] args){

    //Oppretter legemiddel-objekter
    Narkotisk morfin = new Narkotisk("morfin", 15000, 1, 10);
    Vanlig hostesaft = new Vanlig("hostesaft", 220, 100);
    Vanlig ppiller = new Vanlig("P-piller", 550, 100);

    //Oppretter et lege-objekt
    Lege Jorgen = new Lege("Jørgen");

    //Oppretter resept-objekter
    Presept ppillerResept = new Presept(ppiller, Jorgen, 1);
    Militarresept morfinResept = new Militarresept(morfin, Jorgen, 1, 5);
    ReseptBlaa hostesaftResept = new ReseptBlaa(hostesaft, Jorgen, 1, 4);

    //Skriver ut
    System.out.println("\nP-Piller-resept");
    System.out.println(ppillerResept.hentLegemiddel());
    System.out.println(ppillerResept.hentPasientId());
    System.out.println(ppillerResept.farge());
    System.out.println(ppillerResept.prisAaBetale());
    System.out.println(ppillerResept.hentId());
    System.out.println(ppillerResept.bruk());
    System.out.println(ppillerResept.hentReit());

    System.out.println("\nMorfin-resept");
    System.out.println(morfinResept.prisAaBetale());
    System.out.println(morfinResept.farge());
    System.out.println(morfinResept.hentId());

    System.out.println("\nHostesaft-resept");
    System.out.println(hostesaftResept.prisAaBetale());
    System.out.println(hostesaftResept.farge());
    System.out.println(hostesaftResept.hentId());

    }
}
