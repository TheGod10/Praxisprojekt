package input;

import dataModel.Surgery;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class ParseBruderholz implements Parser {


    public  ArrayList<Surgery> parse(File file) throws Exception {
        ArrayList<Surgery> surgeriesBH = new ArrayList<>();
        try {
            Scanner sc2 = new Scanner((new FileReader(file)));
            String splitby = ";";
            int i = 0;
            while (sc2.hasNextLine())

            {
                String line = sc2.nextLine();
                Surgery bh = Surgery.parseBruderholz(line.split(splitby));
                surgeriesBH.add(bh);
               // System.out.println(i+":"+ line.split(splitby).length);
                i++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return surgeriesBH;
    }



}
