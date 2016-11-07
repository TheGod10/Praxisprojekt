package input;

import dataModel.Surgery;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class ParseBruderholz {
    public static ArrayList<Surgery> addDatatonewCsvBruderholz(File file) throws Exception {
        ArrayList<Surgery> surgeriesBH = new ArrayList<>();
        try {
            Scanner sc2 = new Scanner((new FileReader(file)));
            String splitby = ";";
            while (sc2.hasNextLine())

            {
                String line = sc2.nextLine();
                Surgery bh = Surgery.parseBruderholz(line.split(splitby));
                surgeriesBH.add(bh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surgeriesBH;
    }
}
