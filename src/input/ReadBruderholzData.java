package input;

import dataModel.SurgeryDataModel;
import parser.Parser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import static input.ReadLiestalData.parseCSV;



public class ReadBruderholzData implements Parser {


    public  ArrayList<SurgeryDataModel> parse(File file) throws Exception {
        ArrayList<SurgeryDataModel> surgeriesBH = new ArrayList<>();
        try {
            Scanner sc2 = new Scanner((new FileReader(file)));
            //  sc2.useDelimiter(";");
            //  String splitby = (",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);



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


