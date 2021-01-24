import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.shape.*;
import java.util.Scanner;

public class Spill extends Application implements Runnable {
    static String resultater = "";
    
    //Metode for å opprette en tråd som stenger GUI-programmet etter 5 sekunder.
    public void run() {
        try {
            Thread.sleep(5000);
            Platform.exit();
        } catch (InterruptedException e) {
            System.out.println("Feil i tråden.");
        }
    }

    //Stopper programmet 
    class StoppProgram implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Platform.exit();
        }
    }

    public void start(Stage teater) {
        StoppProgram stopp = new StoppProgram();

        //Overskrift
        Text overskrift = new Text("Resultater");
        overskrift.setY(40);
        overskrift.setX(15);
        overskrift.setFont(new Font(40));

        Rectangle r = new Rectangle();
        r.setX(0);
        r.setY(50);
        r.setWidth(50000);
        r.setHeight(4);

        // Tekst over resultater
        Text resultat = new Text(resultater);
        resultat.setY(100);
        resultat.setX(15);
        resultat.setFont(new Font(30));
        resultat.setStyle("-fx-font-weight: bold");

        // Stoppknapp
        Button stoppknapp = new Button("Stopp");
        stoppknapp.setLayoutX(430);
        stoppknapp.setLayoutY(15);
        stoppknapp.setOnAction(stopp);

        // Pane
        Pane kulisser = new Pane();
        kulisser.setPrefSize(500, 200);
        kulisser.getChildren().add(overskrift);
        kulisser.getChildren().add(resultat);
        kulisser.getChildren().add(stoppknapp);
        kulisser.getChildren().add(r);

        // Scene
        Scene scene = new Scene(kulisser);
        teater.setTitle("Resultater fra skattejakten.");
        teater.setScene(scene);
        teater.show();
    }

    public static void main(String[] args) {
        Terreng terreng = new Terreng();
        Scanner spiller = new Scanner(System.in);
        Terminal term = new Terminal(spiller);
        Robot bot = new Robot();

        // Endre term til bot for å kjøre roboten.
        Spiller spiller1 = new Spiller(terreng.hentStart(), term, "Jorgen");
        spiller1.nesteTrekk();

        resultater = spiller1.hentResultat();

        System.out.println("Resultat:");
        System.out.println(resultater);

        Spill sleep = new Spill();
        Thread trad = new Thread(sleep);
        trad.start();

        launch(args);
    }
}
