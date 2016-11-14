import dataModel.Surgery;
import input.*;
import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends Application {
    File firstFile;
    File secondFile;



    File mergedFile;

    Button mergeButton = new Button("OK");
    Label mergeLabel = new Label("Mergen:");

    ArrayList<Surgery> surgeries;
    ArrayList<Surgery> surgeries2;

    Label infoMerge = new Label();

    Label getName1 = new Label();
    Label getName2 = new Label();

    Label label = new Label("Wähle die gewünschte Datei:");
    Button button = new Button("Datei Auswahl!");

    Label label2 = new Label("Wähle die gewünschte Datei:");
    Button button2 = new Button("Datei Auswahl!");

    Button run = new Button("Run");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {




        final GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(7);
        gridPane.setVgap(7);



// Label, Button, FileCHooser für die erste Datei

        FileChooser fileChooser = new FileChooser();
        fileChooserExtensionFilter(fileChooser);

        // Label zeigt FileName an

        // Info Label
        Label ausgewählteDateiLabel = new Label("Die ausgewählte Datei:");
        Label ausgewählteDateiLabel2 = new Label("Die ausgewählte Datei:");

// Label, Button, FileCHooser für die zweite Datei

        FileChooser fileChooser2 = new FileChooser();
        fileChooserExtensionFilter(fileChooser2);

        // Label zeigt FileName an


// Label & Button gesperrt!
        button2.setDisable(true);
        label2.setDisable(true);

        mergeLabel.setDisable(true);
        mergeButton.setDisable(true);

        run.setDisable(true);


// ButtonAktivität für die erste Datei
        button.setOnAction(e -> {
            enableButton2();
            // FileChooser für die erste Datei
          firstFile = fileChooser.showOpenDialog(null);
                        getName1.setText(firstFile.getName());
            Parser parser = null;
            try {
                parser = Parser.resolveParser(firstFile);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                surgeries = parser.parse(firstFile);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });



//------------------------------------------------------------------------------------------------------------------

        button2.setOnAction(e -> {
            enableMergeButton();
            // 2. FileChooser für die zweite Datei
            secondFile = fileChooser2.showOpenDialog(primaryStage);
            getName2.setText(secondFile.getName());

            Parser parser2 = null;
            try {
                parser2 = Parser.resolveParser(secondFile);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                 surgeries2 = parser2.parse(secondFile);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


//------------------------------------------------------------------------------------------------------------------
        // Button zum Mergen
        mergeButton.setOnAction(e -> {
        enableRun();
// surgeries & surgeries2 zu newList zusammenführen
            Set<Surgery> newSet = new HashSet<Surgery>(surgeries);
            newSet.addAll(surgeries2);
            ArrayList<Surgery> newList = new ArrayList<Surgery>(newSet);


            // newList in eine CSV Datei einlesen

            FileChooser dc = new FileChooser();
            mergedFile = dc.showSaveDialog(primaryStage);
                listInDatei(newList, mergedFile);
                infoMerge.setText("Merge Datei wurde erstellt!");
        });


        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            primaryStage.close();
        });


        run.setOnAction(e -> {
           run();
        });


// Zuordnung zum Grid (Node, X-Position, Y-Position)
        gridPane.add(label, 0, 0);
        gridPane.add(button, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(button2, 1, 1);
        gridPane.add(ausgewählteDateiLabel, 0, 2);
        gridPane.add(getName1, 1, 2);
        gridPane.add(ausgewählteDateiLabel2, 0, 3);
        gridPane.add(getName2, 1, 3);
        gridPane.add(mergeLabel, 0, 4);
        gridPane.add(mergeButton, 1, 4);
        gridPane.add(infoMerge, 0, 5);
        gridPane.add(closeButton, 0, 6);
        gridPane.add(run, 1, 6);


        primaryStage.setScene(new Scene(gridPane, 500, 500));
        primaryStage.setTitle("Merge-Tool!");
        primaryStage.show();
    }


    // liest eine Liste in eine CSV Datei ein und erstellt eine CSV Datei
    private static void listInDatei(ArrayList<Surgery> list, File file) {
        PrintWriter printWriter = null;
        try {

            printWriter = new PrintWriter(new FileWriter(file));
            Iterator iter = list.iterator();

            printWriter.println("opDate" + ";" + "opRoom" + ";" + "start" + ";"
                    + ";" + "end" + ";" + "opDuaration" + ";" + "meetingIdentifier" + ";" + "comment1" + ";" + "comment2" + ";" + "comment3" + ";" + "meetingNotice" + ";" +
                    "tattCode" + ";" + "taCode" + ";" + "taStatistic" + ";" +
                    "taIdnetifier" + ";" + "operatuer" + ";" + "assistance" + ";" + "anaesthesia" + ";" + "anaesthesiaCare" + ";" + "instrumentation" + ";" + "zudienung" + ";" + "patientLastName" + ";" +
                    "patientFirstName" + ";" + "birthDate" + ";" + "gender" + ";" + "age" + ";" + "room" + ";" + "pID" + ";" + "fID"
                    + ";" + "stay" + ";" + "discipline" + ";" + "oe" + ";" + "klasse" + ";" + ";" + "entranceTime" + ";" + "leaving" + ";" + "leavingTime" + ";" + "p1PatientRequest" + ";" + "p3StartWrangle" + ";" +
                    "p5PatientInOp" + ";" + "o5StartClean" + ";" + "o6StartPraesenzFirstOperateur" + ";" + "o8StartOp" + ";" + "o10EndOp" + ";" + "o11End" + ";" + "p7PatientOutOfOp" + ";" +
                    "notFallSpezifikation" + ";" + "terminAbweichung" + ";" + "terminAbweichungVorbereitung" + ";" +
                    "terminAbweichungWiederaufbereitung" + ";" + "terminArtID" + ";" + "terminArtCode" + ";" + "terminID");


            while (iter.hasNext()) {
                Object o = iter.next();
                printWriter.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) printWriter.close();
            } catch (Exception e) {
            }
        }
    }

    // FileChooser ExtensionFilter
    public void fileChooserExtensionFilter(FileChooser fileChooser) {
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("CSV files", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
    }




    public void enableButton2(){
        button2.setDisable(false);
        label2.setDisable(false);

    }
    public void enableMergeButton(){
        mergeButton.setDisable(false);
        mergeLabel.setDisable(false);

    }

    public void enableRun(){
        run.setDisable(false);


    }
    public void run(){
        try {
            Desktop.getDesktop().open(mergedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
    
