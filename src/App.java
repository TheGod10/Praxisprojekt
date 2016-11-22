import dataModel.SurgeryDataModel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;
import parser.Parser;

import java.awt.*;
import java.io.*;
import java.util.*;

public class App extends Application {
    File firstFile;
    File secondFile;
    File mergedFile;

    ArrayList<SurgeryDataModel> surgeries;
    ArrayList<SurgeryDataModel> surgeries2;


    Button mergeButton = new Button("die geladenen Dateie mergen..." );
    Button infoButton = new Button();


    Label mergeLabel = new Label("Mergen:");

    Label amountOfRowsLi = new Label();
    Label amountOfRowsBh = new Label();

    Label infoMerge = new Label();

    Label getNameFirstFile = new Label();
    Label getNameSecondFile = new Label();

    //Label label = new Label("");
    Button buttonFirstFile = new Button("eine gültige Datei auswählen...");

    //Label label2 = new Label("Wähle die gewünschte Datei:");
    Button buttonSecondFile = new Button("eine gültige zweite Datei auswählen...");

    Button run = new Button("die erstellte Datei in Excell öffnen");




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(8);



        Text scenetitle = new Text("Dieses Tool merged CSV Dateien");
        scenetitle.getStyleClass().add("text-welcome");
        gridPane.add(scenetitle, 0, 0, 2, 1);


// Label, Button, FileCHooser für die erste Datei

        FileChooser fileChooser = new FileChooser();
        fileChooserExtensionFilter(fileChooser);



        // Info Label
        //Label ausgewählteDateiLabel = new Label("Die ausgewählte Datei:");
        //Label ausgewählteDateiLabel2 = new Label("Die ausgewählte Datei:");

// Label, Button, FileCHooser für die zweite Datei

        FileChooser fileChooser2 = new FileChooser();
        fileChooserExtensionFilter(fileChooser2);

        // Label zeigt FileName an



        buttonSecondFile.setDisable(true);
        //label2.setDisable(true);

        mergeLabel.setDisable(true);
        mergeButton.setDisable(true);

        run.setDisable(true);
        infoButton.setDisable(true);


// ButtonAktivität für die erste Datei
        buttonFirstFile.setOnAction(e -> {
            firstFile = fileChooser.showOpenDialog(null);
            if ((firstFile.getName().contains("Liestal")) || (firstFile.getName().contains("Bruderholz"))){

                try {
                    countRows(firstFile);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                getNameFirstFile.setText(firstFile.getName());

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
                enableButton2();
        }else{
            getNameFirstFile.setText("Bitte eine gültige Datei auswählen");
            getNameFirstFile.getStyleClass().add("label-getNameNotification");


        }

        });



//------------------------------------------------------------------------------------------------------------------

        buttonSecondFile.setOnAction(e -> {
                secondFile = fileChooser2.showOpenDialog(primaryStage);

            if ((secondFile.getName().contains("Liestal"))||(secondFile.getName().contains("Bruderholz"))) {
                try {
                    countRows(secondFile);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                getNameSecondFile.setText(secondFile.getName());

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
                enableMergeButton();
                enableInfoButton();
            }else{
                getNameSecondFile.setText("eine gültige Datei auswählen");
                getNameSecondFile.getStyleClass().add("label-getNameNotification");

            }
        });


//------------------------------------------------------------------------------------------------------------------
        // Button zum Mergen
        mergeButton.setOnAction(e -> {


            Set<SurgeryDataModel> newSet = new HashSet<SurgeryDataModel>(surgeries);
            newSet.addAll(surgeries2);
            ArrayList<SurgeryDataModel> newList = new ArrayList<SurgeryDataModel>(newSet);




            FileChooser dc = new FileChooser();
            fileChooserExtensionFilter(dc);
            mergedFile = dc.showSaveDialog(primaryStage);

            listInDatei(newList, mergedFile);

            infoMerge.setText("die Datei wurde erfolgreich erstellt");
            infoMerge.setTextFill(Color.FIREBRICK);
            enableRun();

        } );



        run.setOnAction(e -> {
            run();
        });





        infoButton.setText("Info zu den Dateien");
        infoButton.setOnAction(e -> {
            final Stage popUp = new Stage();
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(primaryStage);

            Button close = new Button("dieses Fenster schliessen");
            close.setOnAction(e1 -> {
                popUp.close();
            });

            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().addAll(new Text("Anzahl Zeilen pro Datei:"),amountOfRowsBh,amountOfRowsLi, close);
            Scene popUpScene = new Scene(dialogVbox, 300, 200);
            popUpScene.getStylesheets().add("merge.css");
            popUp.setScene(popUpScene);
            popUp.show();
        });


// Zuordnung zum Grid (Node, X-Position, Y-Position)
        //gridPane.add(label, 0, 1);
        gridPane.add(buttonFirstFile, 1, 1);
        //gridPane.add(label2, 0, 3);
        gridPane.add(buttonSecondFile, 1, 3);
       // gridPane.add(ausgewählteDateiLabel, 4, 1);
        gridPane.add(getNameFirstFile, 2, 1);
        //gridPane.add(ausgewählteDateiLabel2, 4, 3);
        gridPane.add(getNameSecondFile, 2, 3);
        gridPane.add(infoButton,1,5);
       // gridPane.add(amountOfRowsBh,3,5);
       // gridPane.add(mergeLabel, 0, 6);
        gridPane.add(mergeButton, 1, 6);
        gridPane.add(infoMerge, 2, 6);
        gridPane.add(run, 1, 8);




        window.setScene(new Scene(gridPane, 600, 300));
        window.setTitle("Merge-Tool");
        gridPane.getStylesheets().add(("merge.css"));
        window.show();
    }


    // liest eine Liste in eine CSV Datei ein und erstellt eine CSV Datei
    private static void listInDatei(ArrayList<SurgeryDataModel> list, File file) {
        PrintWriter printWriter = null;
        try {

            printWriter = new PrintWriter(new FileWriter(file));
            Iterator iter = list.iterator();

            printWriter.println("dataSource" +";"+ "opDate" + ";" + "opRoom" + ";" + "start" + ";" + "end" + ";" + "opDuaration" + ";" +
                    "meetingIdentifier" + ";" + "comment1" + ";" + "comment2" + ";" + "comment3" + ";" + "meetingNotice" + ";" + "tattCode" + ";" +
                    "taCode" + ";" + "taStatistic" + ";" +
                    "taIdnetifier" + ";" + "operatuer" + ";" + "assistance" + ";" + "anaesthesia" + ";" + "anaesthesiaCare" + ";" +
                    "instrumentation" + ";" + "zudienung" + ";" + "patientLastName" + ";" +
                    "patientFirstName" + ";" + "birthDate" + ";" + "gender" + ";" + "age" + ";" +
                    "room" + ";" + "pID" + ";" + "fID" + ";" + "stay" + ";" + "discipline" + ";" + "oe" + ";" +
                    "klasse" +";"+ "entrance"+";" + "entranceTime" + ";" + "leaving" + ";" + "leavingTime" + ";" +
                    "p1PatientRequest" + ";" +
                    "p3StartWrangle" + ";" + "p5PatientInOp" + ";" + "o5StartClean" + ";" + "o6StartPraesenzFirstOperateur" + ";" +
                    "o8StartOp" + ";" + "o10EndOp" + ";" + "o11End" + ";" + "p7PatientOutOfOp" + ";" +
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
        buttonSecondFile.setDisable(false);
        //label2.setDisable(false);

    }
    public void enableMergeButton(){
        mergeButton.setDisable(false);
       // mergeLabel.setDisable(false);

    }

    public void enableInfoButton(){
        infoButton.setDisable(false);
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

    public void countRows(File file) throws  Exception{
        try{
            Scanner scanner = new Scanner((new FileReader(file)));

            int i = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                i++;
            }
            if (file.getName().contains("Liestal")) {
                amountOfRowsLi.setText(file.getName() + " hat " + i + " Zeilen");
            }else{
                amountOfRowsBh.setText(file.getName() + " hat " + i + " Zeilen");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }


 }









    
