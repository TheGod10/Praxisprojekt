package input;

import dataModel.SurgeryDataModel;
import parser.Parser;


import java.io.File;
import java.io.FileInputStream;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import static input.ReadLiestalData.parseCSV;



public class ReadBruderholzData implements Parser {

    /**
     * gets the file from parser.
     * Parse the file, creates a Arraylist and fill the Arraylist
     *
     * @param file
     * @return A Arraylist with the parsed values
     */

    public  ArrayList<SurgeryDataModel> parse(File file) throws ExceptionHandling {
        ArrayList<SurgeryDataModel> surgeriesBH = new ArrayList<>();
        try {
            Scanner sc2 = new Scanner(new FileInputStream(file), StandardCharsets.ISO_8859_1.name());
            if(sc2.hasNext()){

                sc2.nextLine();

            }
            while (sc2.hasNextLine())
            {
                String line = sc2.nextLine();
                SurgeryDataModel bh = SurgeryDataModel.parseBruderholz(parseCSV(line));
                surgeriesBH.add(bh);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return surgeriesBH;
    }

}


