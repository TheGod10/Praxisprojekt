package input;

import dataModel.SurgeryDataModel;
import parser.Parser;
import java.io.UnsupportedEncodingException;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadLiestalData  implements Parser  {

    public  ArrayList<SurgeryDataModel> parse(File file) throws Exception {
        ArrayList<SurgeryDataModel> surgeriesLi = new ArrayList<>();
        int i=0;
        try {
            Scanner sc = new Scanner((new FileReader(file)));
            //  sc.useDelimiter(";");
            String splitby=";";
            //splitby = ";(?=([^\"]*\"[^\"]*\")*[^\"]*$)";



            if(sc.hasNext()){

                sc.nextLine();

            }


            while (sc.hasNextLine())

            {
                String line = sc.nextLine();


/*                String[] tokens = line.split(splitby,-1);
                System.out.println(i+":"+ tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    String token = tokens[j];
                    System.out.print(token + ", ");
                }
                System.out.println();*/

                SurgeryDataModel s = SurgeryDataModel.parseLiestal(parseCSV(line));
                surgeriesLi.add(s);

            }








        } catch (Exception e) {
            System.out.println(i);
            e.printStackTrace();
        }
        return surgeriesLi;






    }



    public static String[] parseCSV(String line){

  /*
  We use a simple parser to split an input string by semicolons which are not enclosed in quotes.
  It works as follows: We iterate through the caracters of the input string. Whenever we discover a quote,
  we cahnge state. After an odd number of quotes discovered, we are in the state 'inQuotes' (i.e. inQuotes == true), otherwise we are in the default state,
  (i.e. inQuotes == false).
  When we encounter a semicolon, we either split the string at theis semicolon (if we are not inQuotes), else we just keep adding characters.

  We could do this via regex, but this would likely be more complicated, harder to read and more error prone.
  */


        boolean inQuotes = false; // initially, we are not inQuotes.
        ArrayList<String> elements = new ArrayList<String>(); // here, we store the strings we parse
        StringBuilder strBuilder = new StringBuilder(); // we use this to build our strinbgs while parsing


        for (char c : line.toCharArray()){  // like for loop, iterate through every character in the line, is a bit more elegant. See docs.

            switch (c) {
                case ';':
                    if(inQuotes){
                        strBuilder.append(c); // if we are inQuotes, we just append the current character to our string
                    }else{
                        elements.add(strBuilder.toString()); // otherwise, we add the current string to our array(list) and clean the stringbuilder
                        strBuilder.delete(0, strBuilder.length());
                    }
                    break;

                case '\"':
                    inQuotes = !inQuotes; // change state

                default:
                    strBuilder.append(c);
                    break;
            } // end switch
        } // end for
        elements.add(strBuilder.toString());

        String[] elemArr = new String[elements.size()];
        elemArr = elements.toArray(elemArr);
        return elemArr;
    } // end parseCSV





} // end class

