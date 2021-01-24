import java.util.ArrayList;

public class VeivalgSpiller extends Spiller {
    VeivalgSted sted;

    public VeivalgSpiller(VeivalgSted nyttsted, Terminal term, String navn) {
        super(nyttsted, term, navn);
        sted = nyttsted; 
    }
    
    @Override
    public void nesteTrekk(){
        while(sted != null){
            System.out.println(sted.hentBeskrivelse());
            String alternativer[] = new String[ryggsekk.antGjenstander()+1];
            ArrayList<Gjenstand> ryggsekkInnhold = new ArrayList<Gjenstand>();
            ryggsekkInnhold = ryggsekk.returnerInnhold();

            if(ryggsekkInnhold.size() > 0){
            int a = 0;
            for(int i = 0; i < ryggsekkInnhold.size(); i++){
                alternativer[i] = i + "." + (String)ryggsekkInnhold.get(i).hentNavn();
                a++;
            }
            alternativer[a] = a + ". Ikke legg ned noe.";

            //Legger tilbake en gjenstand i kisten og får penger for gjenstanden.
            int valg = term.beOmKommando("Hva vil du legge igjen?", alternativer);
                if (valg < a){
                    int verdi = sted.hentKiste().leggNed(ryggsekkInnhold.get(valg));
                    ryggsekk.fjern(valg);
                    penger = penger + verdi;
                }
            }

            //Tar opp en gjenstand fra skattekisten og lar bruker velge om man skal ta vare på den.
            if(ryggsekkInnhold.size() < 3){
                Gjenstand x = sted.hentKiste().hentSkatt();
                String[] nyAlt = new String[2];
                nyAlt[0] = "1. JA ";
                nyAlt[1] = "2. NEI";
                int valg = term.beOmKommando("Du ser i kisten og fant en "+ x.hentNavn() + " med verdi " + x.hentVerdi() + " kroner. Beholde den?", nyAlt);
                if(valg == 1){
                    ryggsekk.leggNed(x);
                }
                else{
                    sted.hentKiste().leggNed(x);
                }
            }
            else {
                System.out.println("Du har ikke plass til flere gjenstander i sekken din.");
            }
            System.out.println("Du har "+ penger + " kroner.");
            System.out.println("---------------------------------------------------------------------------------------------------------");    
            
            //Går til neste sted.
            String sporsmaal = "Hvilken vei vil du gaa?";
                String[] alt = {"1. Rett frem", "2. Hoyre", "3. Venstre"};

                if(sted.hentLengde() > 1){
                    int valgt = term.beOmKommando(sporsmaal, alt);
                    sted = sted.nesteSted(valgt);
                }
                else{
                    sted = null;
                }

            System.out.println();
        }
    }

    @Override
    public String hentResultat() {
        return (this.navn + ": " + this.penger + " kroner.");
    }

}