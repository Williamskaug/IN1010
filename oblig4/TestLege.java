



// ULOVLIG UTSKRIFT SKRIVER IKKE UT MELDING !! FIKS SENERE


class TestLege{
    public static void main(String[] args){

        Spesialist henrik = new Spesialist("Henrik", 1);
        Spesialist william = new Spesialist("William", 2);
        william.sorterLege();
        henrik.sorterLege();
        SortertLenkeliste nylegeListe = william.hentLegeliste();
        System.out.println(nylegeListe.stoerrelse());
        System.out.println(nylegeListe.hent(0));

         //Oppretter legemiddel-objekter
         Narkotisk morfin = new Narkotisk("morfin", 15000, 1, 10);
         Vanlig hostesaft = new Vanlig("hostesaft", 220, 100);
         Vanlig ppiller = new Vanlig("P-piller", 550, 100);

        Pasient pasient1 = new Pasient("15.10.1988.43298", "Tor-Espen Andersen");
        Pasient pasient2 = new Pasient("28.04.1981.53883", "Lars Svendsen");
        Pasient pasient3 = new Pasient("04.12.1998.06583", "Sindre Hansen");

        // Test Resepter fra Legeklassen
        try{
        ReseptHvit resept1  =  henrik.skrivHvitResept(morfin, pasient1, 3);
        Militarresept resept2 = william.skrivMillitaerResept(hostesaft, pasient2, 4);
        Presept resept3 = henrik.skrivPResept(ppiller, pasient3);
        ReseptBlaa resept4 = william.skrivBlaaResept(ppiller, pasient1, 5);

    }
    catch(UlovligUtskrift e){}
    
    
    Lenkeliste liste= henrik.hentReseptliste();
    for(int i=0; i<liste.stoerrelse(); i++){
        System.out.println(liste.hent(i));
        
    }
    }
}