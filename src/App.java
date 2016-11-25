import dataModel.SurgeryDataModel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class App extends Application {

    //All variables are global

    GridPane gridPane = new GridPane();
    MenuBar menuBar = new MenuBar();

    Text scenetitle = new Text("This is a merging Tool");

    FileChooser fileChooser = new FileChooser();
    FileChooser fileChooser2 = new FileChooser();

    File firstFile;
    File secondFile;
    File mergedFile;

    ArrayList<SurgeryDataModel> surgeries;
    ArrayList<SurgeryDataModel> surgeries2;

    Label mergeLabel = new Label("merging:");
    Label amountOfRowsLi = new Label();
    Label amountOfRowsBh = new Label();
    Label infoMerge = new Label();
    Label getNameFirstFile = new Label();
    Label getNameSecondFile = new Label();


    Button buttonFirstFile = new Button("please load a valid file...");
    Button buttonSecondFile = new Button("please load another valid file...");
    Button run = new Button("open the created file in Excel");
    Button mergeButton = new Button("merge the loaded files..." );
    Button infoButton = new Button();




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        createGridPane(primaryStage);
        createMenuBar(primaryStage);

// Zuordnung zum Grid (Node, X-Position, Y-Position)

        gridPane.add(buttonFirstFile, 1, 2);
        gridPane.add(buttonSecondFile, 1, 4);
        gridPane.add(getNameFirstFile, 2, 2);
        gridPane.add(getNameSecondFile, 2, 4);
        gridPane.add(infoButton,1,6);
        gridPane.add(mergeButton, 1, 7);
        gridPane.add(infoMerge, 2, 7);
        gridPane.add(run, 1, 9);



        BorderPane pane = new BorderPane();
        pane.setLeft(gridPane);
        pane.setTop(menuBar);
        primaryStage.setScene(new Scene(pane, 600, 300));
        primaryStage.setTitle("Merge-Tool");
        pane.getStylesheets().add(("merge.css"));
        primaryStage.show();
    }




    /**
     * Creates a csv file with all the values from Arraylists
     */
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
            } catch (Exception e) {   e.printStackTrace();
            }
        }
    }



    /**
     * Extensionfilter for fileChooser
     */
    public void fileChooserExtensionFilter(FileChooser fileChooser) {
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("CSV files", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
    }


    /**
     * Enable the button to load the second file
     */
    public void enableButtonSecondfile(){
        buttonSecondFile.setDisable(false);
    }


    /**
     * Enable the button for merging
     */
    public void enableMergeButton(){
        mergeButton.setDisable(false);
    }

    /**
     * Enable the info button
     */
    public void enableInfoButton(){
        infoButton.setDisable(false);
    }

    /**
     * Enable the Run button
     */

    public void enableRun(){
        run.setDisable(false);
    }


    /**
     * Opens the merged csv file in Excel
     *
     */
    public void run(){
        try {
            Desktop.getDesktop().open(mergedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Count the amount of rows in a file
     *
     */
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


    /**
     * creates a menu bar
     *
     * @param primaryStage
     * @return menu bar
     */

    public MenuBar createMenuBar(Stage primaryStage){

        Menu menu1 = new Menu("Info");

        MenuItem aboutUs = new MenuItem("About us...");
        aboutUs.setOnAction(e->{
            double version = 1.0;
            String text = "This MergeTool were developed and managed by students of FHNW.   Version: " + version;

            Alert alert = new Alert(Alert.AlertType.INFORMATION, text);
            alert.setTitle("About us");
            alert.getDialogPane().setHeaderText(null);
            alert.showAndWait();
        });

        MenuItem help = new MenuItem("Help...");

        help.setOnAction(e->{
            final Stage popUp = new Stage();
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(primaryStage);

            Button openPDF = new Button("open userguideline");
            File pdfFile = new File("/Users/TheGod/Desktop/Praxisprojekt/src/02_UserGuide.pdf");

            openPDF.setOnAction(e1->{
                try {
                    Desktop.getDesktop().open(pdfFile);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            });


            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().addAll(new Text("This is a Userguideline for the MergeTool"),openPDF);
            Scene popUpScene = new Scene(dialogVbox, 300, 100);
            popUpScene.getStylesheets().add("merge.css");
            popUp.setScene(popUpScene);
            popUp.show();
        });



        menu1.getItems().add(aboutUs);
        menu1.getItems().add(help);
        menuBar.getMenus().add(menu1);


        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        return menuBar;
    }



    /**
     * creates a grid pane
     *
     * @param primaryStage
     * @return grid pane
     */

    public GridPane createGridPane(Stage primaryStage){
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(8);



        scenetitle.getStyleClass().add("text-welcome");
        gridPane.add(scenetitle, 0, 1, 2, 1);


        fileChooserExtensionFilter(fileChooser);
        fileChooserExtensionFilter(fileChooser2);


        buttonSecondFile.setDisable(true);
        mergeLabel.setDisable(true);
        mergeButton.setDisable(true);
        run.setDisable(true);
        infoButton.setDisable(true);



        buttonFirstFile.setOnAction(e -> {
            firstFile = fileChooser.showOpenDialog(null);
            if(firstFile == null){
                getNameFirstFile.setText("no file was loaded, please load a file");
                getNameFirstFile.getStyleClass().add("label-getNameNotification");
            }else {
                if ((firstFile.getName().contains("Liestal")) || (firstFile.getName().contains("Bruderholz"))) {

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
                    enableButtonSecondfile();
                } else {
                    getNameFirstFile.setText("please load a valid file");
                    getNameFirstFile.getStyleClass().add("label-getNameNotification");
                }
            }

        });



//------------------------------------------------------------------------------------------------------------------

        buttonSecondFile.setOnAction(e -> {
            secondFile = fileChooser2.showOpenDialog(primaryStage);
            if(secondFile == null){
                getNameSecondFile.setText("no file was loaded, please load a file");
                getNameSecondFile.getStyleClass().add("label-getNameNotification");
            }else {
                if ((secondFile.getName().contains("Liestal")) || (secondFile.getName().contains("Bruderholz"))) {
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
                        assert parser2 != null;
                        surgeries2 = parser2.parse(secondFile);

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    enableMergeButton();
                    enableInfoButton();
                } else {
                    getNameSecondFile.setText("please load a valid file");
                    getNameSecondFile.getStyleClass().add("label-getNameNotification");
                }
            }
        });


//------------------------------------------------------------------------------------------------------------------

        mergeButton.setOnAction(e -> {


            Set<SurgeryDataModel> newSet = new HashSet<>(surgeries);
            newSet.addAll(surgeries2);
            ArrayList<SurgeryDataModel> newList = new ArrayList<>(newSet);

            FileChooser saveFile = new FileChooser();
            fileChooserExtensionFilter(saveFile);
            mergedFile = saveFile.showSaveDialog(primaryStage);
            if (mergedFile == null) {
                infoMerge.setText("the file was not created");
                infoMerge.setTextFill(Color.FIREBRICK);
            }else {

                listInDatei(newList, mergedFile);

                infoMerge.setText("the file was created successfully");
                infoMerge.setTextFill(Color.FIREBRICK);
                enableRun();
            }
        } );

        run.setOnAction(e -> run());

        infoButton.setText("Information to the files...");
        infoButton.setOnAction(e -> {
            final Stage popUp = new Stage();
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(primaryStage);

            Button close = new Button("close");
            close.setOnAction(e1 -> popUp.close());

            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().addAll(new Text("number of rows per file: "),amountOfRowsBh,amountOfRowsLi, close);
            Scene popUpScene = new Scene(dialogVbox, 500, 200);
            popUpScene.getStylesheets().add("merge.css");
            popUp.setScene(popUpScene);
            popUp.show();
        });
        return gridPane;
    }


}










