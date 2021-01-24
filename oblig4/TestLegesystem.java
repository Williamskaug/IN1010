import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

class TestLegesystem<T extends Comparable<T>>{
    //Legger til elementene i lister for å kunne hente dem ut flere steder i legesystemet.  
    static Lenkeliste<Pasient> PasientListe = new Lenkeliste<Pasient>();
    static Lenkeliste<Legemiddel> LegemiddelListe = new Lenkeliste<Legemiddel>();
    static Lenkeliste<Lege> LegeListe = new Lenkeliste<Lege>();
    static Lenkeliste<Resept> ReseptListe = new Lenkeliste<Resept>();


    public static void main(String[] args){
    
        innlesning("litenfil.txt");
        kommandolokke();
    }


    //Metode som oppretter/overskriver en fil og skriver ut alle elementer i registeret. 
    public static void fil(){
        try{
            //Opprette utskriftsfil
            FileWriter skrivTilFil = new FileWriter("utskrift.txt");

            //Skriver ut pasienter
            skrivTilFil.write("# Pasienter (navn, fnr)\n");
            for(int i = 0; i < PasientListe.stoerrelse(); i++){
                skrivTilFil.write(PasientListe.hent(i).navn + "," + PasientListe.hent(i).fodselsnr + "\n");
            }

            //Skriver ut legemidler
            skrivTilFil.write("# Legemidler (navn,type,pris,virkestoff,[styrke])\n");
            for(int i = 0; i < LegemiddelListe.stoerrelse(); i++){
                Legemiddel l = LegemiddelListe.hent(i);
                
                if(l instanceof Vanlig){
                    skrivTilFil.write(l.navn + "," + "vanlig" + "," + l.pris + "\n");
                }
                else if(l instanceof Narkotisk){
                    skrivTilFil.write(l.navn + "," + "narkotisk" + "," + l.pris +","+ ((Narkotisk) l).hentNarkotiskStyrke() + "\n");
                } 
                else{
                    skrivTilFil.write(l.navn + "," + "vanedannende" + "," + l.pris +","+  ((Vanedannende) l).hentVanedannendeStyrke() +"\n");
                }
            }

            //Skriver ut leger
            skrivTilFil.write("# Leger (navn,kontrollid / 0 hvis vanlig lege)\n");
            for(int i = 0; i < LegeListe.stoerrelse(); i++){
                Lege l = LegeListe.hent(i);

                if(l instanceof Spesialist){
                    skrivTilFil.write(l.navn +"," +((Spesialist) l).hentKontrollID() +  "\n" );
                }
                else {
                    skrivTilFil.write(l.navn + "," + 0 + "\n");
                }
            }

            //Skriver ut resepter
            skrivTilFil.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
            for(int i = 0; i < ReseptListe.stoerrelse(); i++){
                Resept r = ReseptListe.hent(i);


                if(r instanceof ReseptHvit){
                    skrivTilFil.write(r.hentLegemiddel() + "," + r.hentLege() +","+ r.hentPasientId() +","+ "hvit" + "," + r.hentReit()+ "\n");
                }
                else if(r instanceof ReseptBlaa){
                    skrivTilFil.write(r.hentLegemiddel() + "," + r.hentLege() +","+ r.hentPasientId() +","+ "blaa" + "," + r.hentReit()+ "\n");
                } 
                else if(r instanceof Militarresept){
                    skrivTilFil.write(r.hentLegemiddel() + "," + r.hentLege() +","+ r.hentPasientId() +","+ "militaer" + "," + r.hentReit()+ "\n");
                }
                else{ //P-resept
                    skrivTilFil.write(r.hentLegemiddel() + "," + r.hentLege() +","+ r.hentPasientId() +","+ "p" + "," + r.hentReit()+ "\n");
                }

            }

            skrivTilFil.close();
            System.out.println("Skrevet ut til fil.");
        }

        catch(IOException e){
            System.out.println("Feil i opprettning av fil");
        }
    }


    //Metode som skriver ut brukerens tilgjenglige funksjoner. 
    public static void kommandolokke() {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------");
        System.out.println("Velg funksjon:");
        System.out.println("\nSkrive ut -"); 
        System.out.println("1. pasienter");
        System.out.println("2. Leger");
        System.out.println("3. Legemidler");
        System.out.println("4. Resepter");
        System.out.println("\nEndringer -");
        System.out.println("5. Opprette og legge til nye elementer i systemet");
        System.out.println("6. Bruke en gitt resept fra listen til en pasient");
        System.out.println("7. Skrive ut statistikk for vanedannede og narkotiske legemidler.");
        System.out.println("8. Skrive alle data til fil\n");
        System.out.println("9. Avslutt");
        System.out.println("-------------------------");

        String input = sc.nextLine();

        if(input.equals("1")){
            for(int i = 0; i < PasientListe.stoerrelse(); i++){
                System.out.println(PasientListe.hent(i));
            }
            kommandolokke();
        }
        else if(input.equals("2")){
            for(int i = 0; i < LegeListe.stoerrelse(); i++){
                System.out.println(LegeListe.hent(i));
            }
            kommandolokke();
        }
        else if(input.equals("3")){
            for(int i = 0; i < LegemiddelListe.stoerrelse(); i++){
                System.out.println(LegemiddelListe.hent(i));
            }
            kommandolokke();
        }
        else if(input.equals("4")){
            for(int i = 0; i < ReseptListe.stoerrelse(); i++){
                System.out.println(ReseptListe.hent(i));
            }
            kommandolokke();   
        }

        else if(input.equals("5")){
            System.out.println("Velg hva du vil legge til:");
            System.out.println("1. Pasienter");
            System.out.println("2. Leger");
            System.out.println("3. Legemidler");
            System.out.println("4. Resepter");

            input = sc.nextLine();
            if(input.equals("1")){
                System.out.println("Skriv inn pasient på denne måten: fødselsnummer, navn");
                String[] data = sc.nextLine().split(",",2);
                Pasient nyPasient = new Pasient(data[0].trim(), data[1].trim());
                PasientListe.leggTil(nyPasient);
                System.out.println(nyPasient);
            }
            else if(input.equals("2")){         
                System.out.println("Skriv inn lege på denne måten: navn, kontrollnummer(Skriv 0, dersom legen ikke er spesialist.)");
                String[] data = sc.nextLine().split(",",0);
                
                if(data[1].trim().equals("0")){
                    Lege nyLege = new Lege(data[0].trim());
                    nyLege.sorterLege();
                    LegeListe.leggTil(nyLege);
                    System.out.println(nyLege);
                }
                else {
                    Spesialist nySpesialist = new Spesialist(data[0].trim(), Integer.parseInt(data[1].trim())); 
                    nySpesialist.sorterLege();
                    LegeListe.leggTil(nySpesialist);
                    System.out.println(nySpesialist);
                }
                for(int i = 0; i < LegeListe.stoerrelse(); i++){
                System.out.println("\n" + LegeListe.hent(i));
                }
            }

            else if(input.equals("3")){
                System.out.println("Velg type legemiddel:");
                System.out.println("1. Vanlig");
                System.out.println("2. Narkotisk");
                System.out.println("3. Vanedannende");
                String type = sc.nextLine();

                System.out.println("Skriv inn Legemiddelet: navn, pris, virkestoff, [styrke]");
                input = sc.nextLine();
                String[] data = input.trim().split(",",0);

                if(type.equals("1")){
                    Vanlig nyVanlig = new Vanlig(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
                    LegemiddelListe.leggTil(nyVanlig);
                }
                if(type.equals("2")){
                    Narkotisk nyNarkotisk = new Narkotisk(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                    LegemiddelListe.leggTil(nyNarkotisk);
                }
                if(type.equals("3")){
                    Vanedannende nyVanedannende = new Vanedannende(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                    LegemiddelListe.leggTil(nyVanedannende);
                }      
                }


            else if(input.equals("4")){
                System.out.println("Velg type resept:");
                System.out.println("1. Hvit");
                System.out.println("2. Blaa");
                System.out.println("3. P-resept");
                System.out.println("4. Militaer resept");
                String type = sc.nextLine();
                System.out.println("Skriv inn resept: lege(navn), legemiddelid, pasientid, [reit]");
                input = sc.nextLine();
                String[] data = input.split(",",0);
                Lege lege1 = null;
                Pasient p = null;
                Legemiddel lm = null;

                //Finner Lege med riktig navn:
                for(int i = 0; i < LegeListe.stoerrelse(); i++){
                    if(LegeListe.hent(i).hentNavn().equals(data[0])){
                         lege1 = LegeListe.hent(i); 
                    }
                }
                //Finner Pasient med riktig ID:
                for(int i = 0; i < PasientListe.stoerrelse(); i++){
                    if(Integer.toString(PasientListe.hent(i).hentId()).equals(data[2].trim())){
                        p = PasientListe.hent(i);
                    }
                }
                 //Finner legemiddel med riktig id:
                for(int i = 0; i < LegemiddelListe.stoerrelse(); i++){
                    if(Integer.toString(LegemiddelListe.hent(i).hentId()).equals(data[1].trim())){
                        lm = LegemiddelListe.hent(i);
                    }
                }

                if(type.equals("1")){
                    try {
                    lege1.skrivHvitResept(lm, p, Integer.parseInt(data[3].trim()));
                    } catch(UlovligUtskrift e){} 
                }
                else if(type.equals("2")){
                    try {
                        lege1.skrivBlaaResept(lm, p, Integer.parseInt(data[3].trim()));
                        } catch(UlovligUtskrift e){}
                }
                else if(type.equals("3")){
                    try {
                        lege1.skrivPResept(lm, p);
                        } catch(UlovligUtskrift e){} 
                }
                else if(type.equals("4")){
                    try {
                        lege1.skrivMillitaerResept(lm, p, Integer.parseInt(data[3].trim()));
                        } catch(UlovligUtskrift e){} 
                }
            }
            else {
                System.out.println("Du må skrive in et av tallene til kommandoene.");
            }

            kommandolokke();
        }


        //Bruker en reit hos en pasients resept.
        else if(input.equals("6")){
            System.out.println("Hva er Id'en til pasienten: ");

            for( int i = 0; i<PasientListe.stoerrelse(); i++){
                System.out.println(PasientListe.hent(i));
            }

            String id = sc.nextLine();
            Pasient p = null;
            Boolean a = false;
            for( int i = 0; i<PasientListe.stoerrelse(); i++){
                if(Integer.toString(PasientListe.hent(i).hentId()).equals(id)){
                    p = PasientListe.hent(i);
                    a = true;
                }
            }
            //Tester om brukeren har skrevet inn en id som finnes.
            if(a){
                System.out.println("Du har valgt " + p + "\n Hvilken resept vil du bruke?");
                System.out.println(p.printResept());
                String reseptTall = sc.nextLine();
                p.reseptListe.hent(Integer.parseInt(reseptTall)).bruk();
                System.out.println("Brukt en resept for " + p.reseptListe.hent(Integer.parseInt(reseptTall)).hentLegemiddel().hentNavn() + ". Du har " + p.reseptListe.hent(Integer.parseInt(reseptTall)).hentReit() + " gjenvaerende uttak." );
            }
            else{
                System.out.println("Du har skrevet inn en ugyldig ID.");
            }
            kommandolokke();
        }
        else if(input.equals("7")){
            
            // Antall Vanedannede legemidler
            int vanedannedelm = 0;
            for(int i = 0; i < LegemiddelListe.stoerrelse(); i++){
                if(LegemiddelListe.hent(i) instanceof Vanedannende){
                    vanedannedelm++;
                }
            }
            System.out.println("Vandedannede legemidler: " + vanedannedelm);

            // Antall Narkotiske legemidler
            int narkotiskelm = 0;
            for(int i = 0; i < LegemiddelListe.stoerrelse(); i++){
                if(LegemiddelListe.hent(i) instanceof Narkotisk){
                    narkotiskelm++;
                }
            }
            System.out.println("Narkotiske legemidler: " + narkotiskelm);
            
            // Leger som har skrevet ut narkotika!
            for(int i = 0; i<LegeListe.stoerrelse(); i++){
                int antResepter = 0;
                Lenkeliste legensResepter = LegeListe.hent(i).hentReseptliste();
                for (int x = 0; x < legensResepter.stoerrelse();x++){
                    if (((Resept) legensResepter.hent(x)).hentLegemiddel() instanceof Narkotisk){
                        antResepter++;
                    }
                }
                if(antResepter > 0){
                    System.out.println(LegeListe.hent(i) + " har " + antResepter + " av typen narkotisk.");
                }
            }
            // Pasienter som har narkotiske resepter
                for(int i = 0; i<PasientListe.stoerrelse();i++){
                    Stabel pasientResepter = PasientListe.hent(i).hentReseptliste();
                    int antResepter = 0;
                    for (int x = 0; x < pasientResepter.stoerrelse();x++){
                        if (((Resept) pasientResepter.hent(x)).hentLegemiddel() instanceof Narkotisk){
                            if(((Resept) pasientResepter.hent(x)).hentReit() > 0) {
                            antResepter++;
                            }
                        }
                    }
                    if(antResepter > 0){
                        System.out.println(PasientListe.hent(i) + " har " + antResepter + " av typen narkotisk.");
                    }    
                }
                kommandolokke();
            }
        else if(input.equals("8")){
            fil();
            kommandolokke();   
        }

        else if(input.equals("9")){
            System.out.println("done");
        }

        else {
            System.out.println("Du må skrive in et av tallene til kommandoene.");
            kommandolokke();
        }
        sc.close();
    }
    
    //Metod som leser inn fil. 
    public static void innlesning(String filnavn){
        int antFeil = 0;
        try{
            File fil1 = new File(filnavn);
            Scanner sc = new Scanner(fil1); 
            String linje = sc.nextLine();   
            
            while (sc.hasNextLine()){
                        if(linje.contains("# Pasienter")){
                            Boolean pasientSjekk = true;
                            linje = sc.nextLine();
                            while(pasientSjekk){
                                String[] data = linje.split(",",0);
                                Pasient nyPasient = new Pasient(data[1], data[0]);
                                PasientListe.leggTil(nyPasient);

                                //Går til neste linje, og tester om det er en #-linje med ny informasjon.
                                linje = sc.nextLine();
                                if(linje.charAt(0) == '#'){pasientSjekk = false;}
                            }
                        }

                        if(linje.contains("# Legemidler")){
                            Boolean legemiddelSjekk = true;
                            linje = sc.nextLine();

                            //Oppretter reseptene avhengig av typen resept.
                            while(legemiddelSjekk){
                                String[] data = linje.split(",",0);
                                if(data[1].equals("narkotisk")){
                                    Narkotisk nyNarkotisk = new Narkotisk(data[0], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]));
                                    LegemiddelListe.leggTil(nyNarkotisk);
                                }
                                else if(data[1].equals("vanedannende")){
                                    Vanedannende nyVanedannende = new Vanedannende(data[0],Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]));
                                    LegemiddelListe.leggTil(nyVanedannende);
                                }
                                else if(data[1].equals("vanlig")){
                                    Vanlig nyVanlig = new Vanlig(data[0], Double.parseDouble(data[2]), Double.parseDouble(data[3]));
                                    LegemiddelListe.leggTil(nyVanlig);
                                }
                                //Lager dummyobjekt for å ikke forskyve id-verdien.
                                else{
                                    antFeil++;
                                    Narkotisk dummy = new Narkotisk("Dummy", 0, 0, 0);
                                }

                                //Går til neste linje, og tester om det er en #-linje med ny informasjon.
                                linje = sc.nextLine();
                                if(linje.charAt(0) == '#'){legemiddelSjekk = false;}
                            }
                        }
                        
                        if(linje.contains("# Leger")){
                            Boolean legeSjekk = true;
                            linje = sc.nextLine();
                            while(legeSjekk){
                                String[] data = linje.split(",",0);

                                if(data[1].equals("0")){
                                    Lege nyLege = new Lege(data[0]);
                                    nyLege.sorterLege();
                                    LegeListe.leggTil(nyLege);
                                }
                                else if(Integer.parseInt(data[1]) > 0){
                                    Spesialist nySpesialist = new Spesialist(data[0], Integer.parseInt((data[1]).trim()));
                                    nySpesialist.sorterLege();
                                    LegeListe.leggTil(nySpesialist);
                                }
                                else{
                                    System.out.println("Feil i innlesning.");
                                    antFeil++;
                                }

                                //Går til neste linje, og tester om det er en #-linje med ny informasjon.
                                if(sc.hasNextLine()){linje = sc.nextLine();}
                                if(linje.charAt(0) == '#'){legeSjekk = false;}

                            }
                        }
                        
                        if(linje.contains("# Resepter")){
                            Boolean reseptSjekk = true;
                            linje = sc.nextLine();
                            while(reseptSjekk){
                                String[] data = linje.split(",",0);
                                Legemiddel lm = null;
                                Lege l = null;
                                Pasient p = null;
                                
                                //Finner legemiddel med riktig id:
                                for(int i = 0; i < LegemiddelListe.stoerrelse(); i++){
                                    if(Integer.toString(LegemiddelListe.hent(i).hentId()).equals(data[0])){
                                        lm = LegemiddelListe.hent(i);
                                    }
                                }
                                //Finner Lege med riktig navn:
                                for(int i = 0; i < LegeListe.stoerrelse(); i++){
                                    if(LegeListe.hent(i).hentNavn().equals(data[1])){
                                        l = LegeListe.hent(i);
                                    }
                                }
                                //Finner Pasient med riktig ID:
                                for(int i = 0; i < PasientListe.stoerrelse(); i++){
                                    if(Integer.toString(PasientListe.hent(i).hentId()).equals(data[2])){
                                        p = PasientListe.hent(i);
                                    }
                                }

                                //Oppretter reseptene avhengig av typen resept.
                                try{
                                if(data[3].equals("hvit")){
                                    ReseptHvit nyReseptHvit = l.skrivHvitResept(lm, p, Integer.parseInt(data[4]));
                                    ReseptListe.leggTil(nyReseptHvit);
                                }
                                else if(data[3].equals("blaa")){
                                    ReseptBlaa nyReseptBlaa = l.skrivBlaaResept(lm, p, Integer.parseInt(data[4]));
                                    ReseptListe.leggTil(nyReseptBlaa);
                                }
                                else if(data[3].equals("millitaer")){
                                    Militarresept nyMilitarresept = l.skrivMillitaerResept(lm, p, Integer.parseInt(data[4]));
                                    ReseptListe.leggTil(nyMilitarresept);
                                }   
                                else if(data[3].equals("p")){
                                    Presept nyPresept =  l.skrivPResept(lm, p);
                                    ReseptListe.leggTil(nyPresept);
                                }}
                                catch (UlovligUtskrift e){
                                    System.out.println("Feil i innlesning.");
                                    antFeil++;
                                }
                                //Går til neste linje, og tester om det er en #-linje med ny informasjon.
                                if(sc.hasNextLine()){
                                    linje = sc.nextLine();
                                }
                                else{break;}
                                if(linje.charAt(0) == '#'){reseptSjekk = false;}

                            }
                        }
                        else{
                            sc.nextLine();
                        }   
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Feil i innlesning av fil.");
        }    
        System.out.println("Antall feil i innlesning: " + antFeil);
        } 

    }