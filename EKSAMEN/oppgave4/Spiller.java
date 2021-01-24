import java.util.ArrayList;

public class Spiller {
    Terminal term;
    int penger;
    Skattkiste ryggsekk;
    Sted posisjon;
    String navn;

    public Spiller(Sted posisjon, Terminal term, String navn) {
        this.term = term;
        this.posisjon = posisjon;
        this.penger = 0;
        this.navn = navn;

        ryggsekk = new Skattkiste();
        ryggsekk.tomRyggsekk();
    }

    //Metode for å returnere spillerens resultat når spillet er ferdig.
    public String hentResultat() {
        return (this.navn + ": " + this.penger + " kroner.");
    }

    //Metode som kjører en løkke gjennom alle stedene fra steder.txt, og gir brukeren valg for hver gang.
    public void nesteTrekk(){
        while(posisjon != null){
            System.out.println(posisjon.hentBeskrivelse());
            String alternativer[] = new String[ryggsekk.antGjenstander()+1];
            ArrayList<Gjenstand> ryggsekkInnhold = new ArrayList<Gjenstand>();
            ryggsekkInnhold = ryggsekk.returnerInnhold();

            if(ryggsekkInnhold.size() > 0){
            int a = 0;
            for(int i = 0; i < ryggsekkInnhold.size(); i++){
                alternativer[i] ="    "+ i + "." + (String)ryggsekkInnhold.get(i).hentNavn();
                a++;
            }
            alternativer[a] ="    " + a + ". Ikke legg ned noe.";

            //Legger tilbake en gjenstand i kisten og får penger for gjenstanden.
            int valg = term.beOmKommando("Hva vil du legge igjen?", alternativer);
                if (valg < a){
                    int verdi = posisjon.hentKiste().leggNed(ryggsekkInnhold.get(valg));
                    ryggsekk.fjern(valg);
                    penger = penger + verdi;
                }
            }

            //Tar opp en gjenstand fra skattekisten og lar bruker velge om man skal ta vare på den.
            if(ryggsekkInnhold.size() < 3){
                Gjenstand x = posisjon.hentKiste().hentSkatt();
                String[] nyAlt = new String[2];
                nyAlt[0] = "    1. JA ";
                nyAlt[1] = "    2. NEI";
                int valg = term.beOmKommando("Du ser i kisten og fant en "+ x.hentNavn() + " med verdi " + x.hentVerdi() + " kroner. Beholde den?", nyAlt);
                if(valg == 1){
                    ryggsekk.leggNed(x);
                }
                else{
                    posisjon.hentKiste().leggNed(x);
                }
            }
            else {
                System.out.println("Du har ikke plass til flere gjenstander i sekken din.");
            }
            System.out.println("Du har "+ penger + " kroner.");
            System.out.println("---------------------------------------------------------------------------------------------------------");    
            posisjon = posisjon.gaaTilNesteSted();
        }
    }
}