import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.*;

import java.io.File;
import java.io.FileNotFoundException;

public class GUI extends Application {
    public Liste<String> veienUt;

    public Rute labyrintRuter [][];
    public Hvit labyrintRuteHvit[][];
    public Svart labyrintRuteSvart[][];

    public Hvit hvitKnapp[];
    public Svart svartKnapp[];

    boolean[][] liste;
    GridPane labyrintRuteNett = new GridPane();
    public Labyrint l = null;
    String test = "";
    int teller = 1;

    Text info = new Text("Velg en Rute for aa finne veien ut");

    static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
        boolean[][] losning = new boolean[hoyde][bredde];
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
        java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
        while (m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            losning[y][x] = true;
        }
        return losning;
    }

//stopper programmet
    class StoppProgram implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e ) {
            Platform.exit();
        }
    }

    class NesteProgram implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            liste = losningStringTilTabell(test, l.kolonner, l.rader);
            for (int i = 0; i < l.rader; i++) {
                for (int n = 0; n < l.kolonner; n++) {
                    if (liste[i][n] == true) {
                        Hvit x = new Hvit(n,i);
                        x.settHvit();
                        labyrintRuteNett.add(x,n,i);
                    }
                }
                System.out.println("");
            }

            for (int i = 0; i < veienUt.stoerrelse(); i++) {
                System.out.println(veienUt.hent(i));
            }

            if (teller < veienUt.stoerrelse()) {
                skrivUt(veienUt.hent(teller));
                teller++;
            } else {
                teller = 0;
                skrivUt(veienUt.hent(teller));
            }
        }

        void skrivUt(String x) {
            liste = losningStringTilTabell(x, l.kolonner, l.rader);

            for (int i = 0; i < l.rader; i++) {
                for (int n = 0; n < l.kolonner; n++) {
                    if (liste[i][n] == true) {
                        Hvit h = new Hvit(i,n);
                        h.settRod();
                        labyrintRuteNett.add(h,n,i);
                    }
                }
                System.out.println("");
            }
        }
    }

//klikkprogram til rutene i labyrinten
    class KlikkProgram implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            int startRaden;
            int startKolonnen;

            String listeAvVeienUt = "";

            Hvit valgtKnapp = (Hvit) e.getSource();

            startRaden = valgtKnapp.hentRaden();
            startKolonnen = valgtKnapp.hentKolonnen();

            System.out.print(startKolonnen + " ");
            System.out.println(startRaden);

            System.out.println(l.RuteArr[startKolonnen][startRaden]);

            try {
                veienUt = l.finnUtveiFra(startKolonnen, startRaden);

                test= veienUt.hent(0);
                System.out.println(veienUt);

                liste = losningStringTilTabell(test, l.kolonner, l.rader);
                for (int i = 0; i < l.rader; i++) {
                    for (int n = 0; n < l.kolonner; n++) {
                        if (liste[i][n] == true) {
                            Hvit x = new Hvit(i,n);
                            x.settRod();
                            labyrintRuteNett.add(x,n,i);
                        }
                    }
                    System.out.println("");
                }
                info.setText("Viser veien ut fra kolonne: " + startKolonnen + " Rad: " + startRaden);
            } catch (UgyldigListeIndeks i) {
                info.setText("Klikk på en rute som har en utvei");
            }

        }
    }

//knappene
    class Hvit extends Button {
        int y;
        int x;
        Hvit(int k, int r) {
            super(" ");
            y = k;
            x = r;
            setFont(new Font(10));
            setPrefSize(10,10);
            setStyle("-fx-background-color: #ffffff");
        }

        void settMerkHvit(char x) {
            setText(""+x);
        }

        void settRod(){
            setStyle("-fx-background-color: #ff0000");
        }

        void settHvit(){
            setStyle("-fx-background-color: #ffffff");
        }


        int hentRaden(){
            return x;
        }

        int hentKolonnen(){
            return y;
        }
    }

    class Svart extends Button {
        Svart() {
            super(" ");
            setFont(new Font(10));
            setPrefSize(10,10);
        }

        void settMerkSvart(char x) {
            setText(""+x);
        }
    }

    public void start(Stage teater) {
        labyrintRuteNett.setGridLinesVisible(true);
        StoppProgram stopp = new StoppProgram();
        KlikkProgram hvitKlikk = new KlikkProgram();
        NesteProgram nesteKlikk = new NesteProgram();

        //Velger fil
        File velg = new FileChooser().showOpenDialog(teater);

        if (velg != null) {
            String filTilString = velg.toString();
            losningStringTilTabell(filTilString,0, 0);
            System.out.println(filTilString);

            try {
                l = Labyrint.lesFraFil(velg);
                //print
                System.out.println(l.rader);
                System.out.println(l.kolonner);
                System.out.println(l.RuteArr);

                hvitKnapp = new Hvit[l.hvitRute];
                svartKnapp = new Svart[l.sortRute];
                int antHvit = 0;
                int antSvart = 0;


                for (int i = 0; i < l.rader; i++) {
                    for (int n = 0; n < l.kolonner; n++) {
                        if (l.RuteArr[i][n].tilTegn() != '#') {
                            hvitKnapp[antHvit] = new Hvit(i,n);
                            labyrintRuteNett.add(hvitKnapp[antHvit], n, i);
                            hvitKnapp[antHvit].setOnAction(hvitKlikk);
                            antHvit++;
                        } else {
                            svartKnapp[antSvart] = new Svart();
                            svartKnapp[antSvart].setStyle("-fx-background-color: #00ff00");

                            labyrintRuteNett.add(svartKnapp[antSvart], n, i);
                            antSvart++;
                        }
                    }
                }

            } catch (FileNotFoundException i) {
                System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", velg);
                System.exit(1);
            }
        }

        //Overskriften
        Text overskrift = new Text("Finn utveien");
        overskrift.setY(40); overskrift.setX(15);
        overskrift.setFont(new Font(40));

        info.setY(70); info.setX(15);
        info.setFont(new Font(15));

        labyrintRuteNett.setLayoutX(15); labyrintRuteNett.setLayoutY(90);

        //Stoppknapp
        Button stoppknapp = new Button("Stopp");
        stoppknapp.setLayoutX(280); stoppknapp.setLayoutY(15);
        stoppknapp.setOnAction(stopp);

        Button nesteknapp = new Button("Neste Utvei");
        nesteknapp.setLayoutX(350); nesteknapp.setLayoutY(15);
        nesteknapp.setOnAction(nesteKlikk);

        //Pane
        Pane kulisser = new Pane();
        kulisser.setPrefSize(800,800);
        kulisser.getChildren().add(overskrift);
        kulisser.getChildren().add(stoppknapp);
        kulisser.getChildren().add(nesteknapp);
        kulisser.getChildren().add(labyrintRuteNett);
        kulisser.getChildren().add(info);

        // Scene
        Scene scene = new Scene(kulisser);

        teater.setTitle("labyrint looseren");
        teater.setScene(scene);
        teater.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
