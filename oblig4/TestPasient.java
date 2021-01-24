class TestPasient {
    public static void main(String[] args){

        //Oppretter legemiddel-objekter
        Narkotisk morfin = new Narkotisk("morfin", 15000, 1, 10);
        Vanlig hostesaft = new Vanlig("hostesaft", 220, 100);
        Vanlig ppiller = new Vanlig("P-piller", 550, 100);

        //Oppretter et lege-objekt
        Lege Jorgen = new Lege("Jørgen");

        //oppretter Pasient
        Pasient pasient1 = new Pasient("15.10.1988.43298", "Tor-Espen Andersen");
        Pasient pasient2 = new Pasient("28.04.1981.53883", "Lars Svendsen");
        Pasient pasient3 = new Pasient("04.12.1998.06583", "Sindre Hansen");

        //Oppretter resept-objekter
        Presept resept1 = new Presept(ppiller, Jorgen, pasient1);
        Militarresept resept2 = new Militarresept(morfin, Jorgen, pasient2, 5);
        ReseptBlaa resept3 = new ReseptBlaa(hostesaft, Jorgen, pasient3, 4);

        //Legger til resepter til pasienter
        pasient1.leggTil(resept1);
        pasient1.leggTil(resept2);
        pasient1.leggTil(resept3);
        System.out.println(pasient1.reseptListe.stoerrelse()); 
//        System.out.println(pasient1.printResept());
        pasient1.hentUt();

/*
        //Skriver ut
        System.out.println(resept1);
        System.out.println("\n");
        System.out.println(resept1.hentLegemiddel());
        System.out.println(resept1.hentPasientId());
        System.out.println(resept1.hentReit());

        System.out.println(resept2);
        System.out.println("\n");
        System.out.println(resept2.hentLegemiddel());
        System.out.println(resept2.hentPasientId());
        System.out.println(resept2.hentReit());

        System.out.println(resept3);
        System.out.println("\n");
        System.out.println(resept3.hentLegemiddel());
        System.out.println(resept3.hentPasientId());
        System.out.println(resept3.hentReit());

*/
    }
}
