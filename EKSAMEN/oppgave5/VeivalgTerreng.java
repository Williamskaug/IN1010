import java.util.ArrayList; 
import java.util.Scanner; 
import java.io.File; 
import java.io.FileNotFoundException;  
class VeivalgTerreng extends Terreng {     
    public static ArrayList<VeivalgSted> steder2 = new ArrayList<>();

        public VeivalgTerreng(){         
            super();     
        }     

        @Override     
        public void LesFraFil(){         
            try{             
                File fil = new File("steder.txt");             
                Scanner inn = new Scanner(fil);      

                while (inn.hasNextLine()){                 
                    String beskrivelse = inn.nextLine();                 
                    VeivalgSted nyttSted = new VeivalgSted(beskrivelse);                 
                    nyttSted.plasserSkatt();                 
                    steder2.add(nyttSted);             
                }             
                inn.close();         
            }         
            catch(FileNotFoundException e){             
                System.out.println("Fant ikke filen");        
            }     
        } 
           
        public ArrayList<VeivalgSted> hentSteder(){         
            return steder2;     
        }     
        
        public VeivalgSted hentStart(){         
            return steder2.get(0);     
        }

}
