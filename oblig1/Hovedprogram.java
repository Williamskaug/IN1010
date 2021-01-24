class Hovedprogram {
    public static void main(String[] args){
        //Opretter en ny dataklynge med parameter "filnavn"
        Dataklynge abel = new Dataklynge("dataklynge.txt");

        //Skriver ut info.
        System.out.println("32gb: " + abel.noderMedNokMinne(32));
        System.out.println("64gb: " + abel.noderMedNokMinne(64));
        System.out.println("128gb: " + abel.noderMedNokMinne(128));

        System.out.println("Antall prosessorer: " + abel.antProsessorer());
        System.out.println("Antall racks: " + abel.antRacks());

    }
}