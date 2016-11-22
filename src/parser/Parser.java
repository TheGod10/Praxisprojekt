package parser;

import dataModel.SurgeryDataModel;
import input.ReadBruderholzData;
import input.ReadLiestalData;


import java.io.File;
import java.util.ArrayList;


/**
 * Created by TheGod on 07.11.16.
 */
public interface Parser {

    ArrayList<SurgeryDataModel> parse(File file) throws Exception;

    static Parser resolveParser(File file) throws Exception {
        if (file.getName().contains("Liestal")) {
            System.out.println(file.getName());
            return new ReadLiestalData();
        } else if (file.getName().contains("Bruderholz")){
            System.out.println(file.getName());
            return new ReadBruderholzData();
        }
        else {
            return null;
        }
    }


}
