class Hovedprogram {
    public static void main(String[] args){
        
        //Oppretter legemiddel-objekter
        Narkotisk morfin = new Narkotisk("morfin", 15000, 1, 10);
        Vanlig ppiller = new Vanlig("P-piller", 550, 100);
    
        //Oppretter lege-objekter
        Lege Jorgen = new Lege("Dr. Jørgen");
        Spesialist Sindre = new Spesialist("Dr. Sindre", 2345);
    
        //Oppretter resept-objekter
        Militarresept morfinResept = new Militarresept(morfin, Jorgen, 1, 5);
        Presept ppillerResept = new Presept(ppiller, Jorgen, 1);

        //Tester funksjonene settNyPris() og bruk().
        System.out.println("Tester (Skal returnere True dersom det er riktig.");

        morfin.settNyPris(99.90);
        if (morfin.hentPris() == 99.90){
            System.out.println("Riktig");
        }

        morfinResept.bruk();
        if (morfinResept.hentReit() == 4){
            System.out.println("Riktig");
        }


        //Skriver ut
        System.out.println("\nP-Piller-resept:");
        System.out.println(ppillerResept.hentLegemiddel());
        System.out.println(ppillerResept.hentPasientId());
        System.out.println(ppillerResept.farge());
        System.out.println(ppillerResept.prisAaBetale());
        System.out.println(ppillerResept.hentId());
        System.out.println(ppillerResept.bruk());
        System.out.println(ppillerResept.hentReit());
    
        System.out.println("\nLege-objekt:");
        System.out.println(Sindre.hentNavn());
        System.out.println(Sindre.hentKontrollID());

    }
}