package input;

import dataModel.Surgery;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class ParseLIestal implements Parser {

    public  ArrayList<Surgery> parse(File file) throws Exception {
        ArrayList<Surgery> surgeriesLi = new ArrayList<>();
        try {
            Scanner sc = new Scanner((new FileReader(file)));
            String splitby = ";";
            int i = 0;
            while (sc.hasNextLine())

            {
                String line = sc.nextLine();
                Surgery s = Surgery.parseLiestal(line.split(splitby));
                surgeriesLi.add(s);
                System.out.println(i+":"+ line.split(splitby).length);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surgeriesLi;
    }

}
