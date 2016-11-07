/**
 * Created by TheGod on 03.11.16.
 */

import dataModel.Surgery;
import input.*;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{


        FileChooser fileChooser = new FileChooser();
        chooseFile(fileChooser);
        File file = fileChooser.showOpenDialog(primaryStage);

        if (file.getName().contains("Liestal")|| file.getName().contains("Bruderholz")) {
            new ParseLIestal().addDatatonewCsvLiestal(file);
            File file2 = fileChooser.showOpenDialog(primaryStage);
            new ParseBruderholz().addDatatonewCsvBruderholz(file2);
        }else {
            System.out.println("Please choose another file!");
        }


        Set<Surgery> newSet = new HashSet<Surgery>(ParseLIestal.addDatatonewCsvLiestal(file));
        newSet.addAll(ParseBruderholz.addDatatonewCsvBruderholz(file));
        ArrayList<Surgery> newList = new ArrayList<Surgery>(newSet);

        listInDatei(newList,new File("/Users/TheGod/Desktop/Praxisprojekt/src/newFile.csv"));

    }





    private static void listInDatei(ArrayList<Surgery> list, File file) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(file));
            Iterator iter = list.iterator();
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


    public void chooseFile(FileChooser fileChooser) {
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("CSV files", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
    }


}

