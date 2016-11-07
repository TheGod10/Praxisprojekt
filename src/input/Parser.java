package input;

import dataModel.Surgery;

import java.io.File;
import java.util.ArrayList;


/**
 * Created by TheGod on 07.11.16.
 */
public interface Parser {

    ArrayList<Surgery> parse(File file) throws Exception;

    static Parser resolveParser(File file) throws Exception {
        if (file.getName().contains("Liestal")) {
            System.out.println(file.getName());
            return new ParseLIestal();
        } else if (file.getName().contains("Bruderholz")){
            System.out.println(file.getName());
            return new ParseBruderholz();
        }
        else {
            return null;
        }
    }


}
