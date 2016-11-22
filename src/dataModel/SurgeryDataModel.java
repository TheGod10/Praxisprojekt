package dataModel;


/**
 * Created by TheGod on 31.10.16.
 */

/**
 * Holds data from a specific variable of a file
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SurgeryDataModel {
    public String dataSource;
    public String opDate;
    public String opRoom;
    public String start;
    public String end;
    public int opDuaration;
    public String meetingIdentifier;
    public String comment1;
    public String comment2;
    public String comment3;
    public String meetingNotice;
    public String tattCode;
    public int taSequence;
    public String taCode;
    public int knotenID;
    public String taStatistic;
    public String knotenIdentifier;
    public String taIdnetifier;
    public String operatuer;
    public String assistance;
    public String anaesthesia;
    public String anaesthesiaCare;
    public String instrumentation;
    public String zudienung;
    public String patientFirstName;
    public String patientLastName;
    public String birthDate;
    public String gender;
    public int age;
    public String room;
    public int pID;
    public int fID;
    public String stay;
    public String discipline;
    public String oe;
    public String klasse;
    public String categorie;
    public String entrance;
    public String entranceTime;
    public String leaving;
    public String leavingTime;
    public String Austrittziel;
    public String p1PatientRequest;
    public String p2PatientArrive;
    public String p3StartWrangle;
    public String p4EndWrangle;
    public String p5PatientInOp;
    public String p6EnrolmentToCareUnit;
    public String p7PatientOutOfOp;
    public String p8Umbetten;
    public String p9StartOpRoomClean;
    public String p10EndOpRoomClean;
    public String o1StartPreparingOpFunction;
    public String o2EndPreparingOpFunction;
    public String o3StartStore;
    public String o4EndStore;
    public String o5StartClean;
    public String o6StartPraesenzFirstOperateur;
    public String o7EndClean;
    public String o8StartOp;
    public String o9EndPraesenzOperateur;
    public String o10EndOp;
    public String o11End;
    public String o12EndAfterOpWorkFunction;
    public String notFallSpezifikation;
    public int terminAbweichung;
    public int terminAbweichungVorbereitung;
    public int terminAbweichungWiederaufbereitung;
    public int terminArtID;
    public int terminArtCode;
    public int terminID;
    public String comment4;
    public String Stempel;





    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------


    @Override
    public String toString() {

        return  dataSource+";"+opDate + ";" + opRoom + ";" + start + ";"  + end + ";" + opDuaration + ";" + meetingIdentifier + ";" + comment1 + ";" + comment2 + ";" + comment3 + ";" + meetingNotice + ";" +
                tattCode + ";" + taCode + ";" + taStatistic + ";" +
                taIdnetifier + ";" + operatuer + ";" + assistance + ";" + anaesthesia + ";" + anaesthesiaCare + ";" + instrumentation + ";" + zudienung + ";" + patientLastName + ";" +
                patientFirstName + ";" + birthDate + ";" + gender + ";" + age + ";" + room + ";" + pID + ";" + fID
                + ";" + stay + ";" + discipline + ";" + oe + ";" + klasse + ";" + entrance + ";" + entranceTime + ";" + leaving + ";" + leavingTime + ";" + p1PatientRequest + ";" + p3StartWrangle + ";" +
                p5PatientInOp + ";" + o5StartClean + ";" + o6StartPraesenzFirstOperateur + ";" + o8StartOp + ";" + o10EndOp + ";" + o11End + ";" + p7PatientOutOfOp + ";" +
                notFallSpezifikation + ";" + terminAbweichung + ";" + terminAbweichungVorbereitung + ";" +
                terminAbweichungWiederaufbereitung + ";" + terminArtID + ";" + terminArtCode + ";" + terminID;
    }

    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------



    public SurgeryDataModel(String dataSource){

        this.dataSource=dataSource;

    }


    public static SurgeryDataModel parseBruderholz(String[] elements) {

        SurgeryDataModel bh = new SurgeryDataModel("Bruderholz");





        try {

            if (isThisDateValid(parseElement(elements,0),"dd.MM.yyyy")) {
                bh.opDate =convertStringToDate( parseElement(elements, 0));
            } else {
                System.out.println("hier stimmt was nicht brooo:  ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.opRoom = parseElement(elements, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.start=convertStringToTime(parseElement(elements, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.end = convertStringToTime(parseElement(elements, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isInteger(parseElement(elements, 5))) {
                bh.opDuaration = Integer.parseInt(parseElement(elements, 5));
            } else {
                bh.opDuaration = 0;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            bh.meetingIdentifier = parseElement(elements, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.comment1 = parseElement(elements, 7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.comment2 = parseElement(elements, 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.comment3 = parseElement(elements, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.meetingNotice = parseElement(elements, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.tattCode = parseElement(elements, 11);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isInteger(parseElement(elements, 12))) {
                bh.taSequence = Integer.parseInt(parseElement(elements, 12));
            } else {
                bh.taSequence = 0;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            bh.taCode = parseElement(elements, 13);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            if (isInteger(parseElement(elements, 14))) {
                bh.knotenID = Integer.parseInt(parseElement(elements, 14));
            } else {
                bh.knotenID = 0;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            bh.taStatistic = parseElement(elements, 15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.knotenIdentifier = parseElement(elements, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.taIdnetifier = parseElement(elements, 17);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.operatuer = parseElement(elements, 18);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.assistance = parseElement(elements, 19);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.anaesthesia = parseElement(elements, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.anaesthesiaCare = parseElement(elements, 21);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.instrumentation = parseElement(elements, 22);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.zudienung = parseElement(elements, 23);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.patientLastName = parseElement(elements, 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.patientFirstName = parseElement(elements, 25);
        } catch (Exception e) {


        }


        try {

            bh.birthDate = convertStringToDate(parseElement(elements, 26));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.gender = parseElement(elements, 27);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isInteger(parseElement(elements, 28))) {
                bh.age = Integer.parseInt(parseElement(elements, 28));
            } else {
                bh.age = 0;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            bh.room = parseElement(elements, 29);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isInteger(parseElement(elements, 30))) {
                bh.pID = Integer.parseInt(parseElement(elements, 30));
            } else {
                bh.pID = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isInteger(parseElement(elements, 31))) {
                bh.fID = Integer.parseInt(parseElement(elements, 31));
            } else {
                bh.fID = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.stay = parseElement(elements, 32);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.discipline = parseElement(elements, 33);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.oe = parseElement(elements, 34);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.klasse = parseElement(elements, 35);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.categorie = parseElement(elements, 36);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.entrance = convertStringToDate(parseElement(elements, 37));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.entranceTime =convertStringToTime( parseElement(elements, 38));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.leaving = convertStringToDate(parseElement(elements, 39));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.leavingTime = convertStringToTime(parseElement(elements, 40));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.p1PatientRequest = parseElement(elements, 42);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.p3StartWrangle =convertStandardStringToTime(parseElement(elements, 43));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.o1StartPreparingOpFunction = convertStandardStringToTime(parseElement(elements, 44));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.o6StartPraesenzFirstOperateur =convertStandardStringToTime( parseElement(elements, 45));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.o5StartClean =convertStandardStringToTime(parseElement(elements, 46));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.o6StartPraesenzFirstOperateur =convertStandardStringToTime( parseElement(elements, 47));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.o8StartOp =convertStandardStringToTime( parseElement(elements, 48));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.o10EndOp =convertStandardStringToTime( parseElement(elements, 49));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.o11End =convertStandardStringToTime(parseElement(elements, 50));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.p7PatientOutOfOp =convertStandardStringToTime( parseElement(elements, 51));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.comment4 = parseElement(elements, 54);
        } catch (Exception e) {
            e.printStackTrace();
        }

/*        try {
            if (isInteger(parseElement(elements, 55))) {
                bh.terminID = Integer.parseInt(parseElement(elements, 55));
            } else {
                bh.terminID=-1;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/

        return bh;

    }


    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------







    public static SurgeryDataModel parseLiestal(String[] elements) {


        SurgeryDataModel s = new SurgeryDataModel("Liestal");

        try {

            if (isThisDateValid(parseElement(elements,0),"dd.MM.yyyy")) {
                s.opDate = convertStringToDate(parseElement(elements, 0));
            } else {
                System.out.println("hier stimmt was nicht brooo:  ");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.opRoom = parseElement(elements, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.start = convertStringToTime(parseElement(elements, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.end = convertStringToTime(parseElement(elements, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

            if (isInteger(parseElement(elements, 5))) {
                s.opDuaration = Integer.parseInt(parseElement(elements, 5));
            } else {
                s.opDuaration = 0;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            try {
                s.meetingIdentifier = parseElement(elements, 6);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.comment1 = parseElement(elements, 7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.comment2 = parseElement(elements, 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.comment3 = parseElement(elements, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.meetingNotice = parseElement(elements, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.tattCode = parseElement(elements, 11);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

            s.taCode = parseElement(elements, 12);
            {

            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            s.taStatistic = parseElement(elements, 13);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.taIdnetifier = parseElement(elements, 14);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.operatuer = parseElement(elements, 15);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.assistance = parseElement(elements, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.anaesthesia = parseElement(elements, 17);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.anaesthesiaCare = parseElement(elements, 18);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.instrumentation = parseElement(elements, 19);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.zudienung = parseElement(elements, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.patientLastName = parseElement(elements, 21);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.patientFirstName = parseElement(elements, 22);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.birthDate = convertStringToDate(parseElement(elements, 23));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.gender = parseElement(elements, 24);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

            if (isInteger(parseElement(elements, 25))) {
                s.age = Integer.parseInt(parseElement(elements, 25));
            } else {
                s.age = 0;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();

        }

        try {
            s.room = parseElement(elements, 26);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

            if (isInteger(parseElement(elements, 27))) {
                s.pID = Integer.parseInt(parseElement(elements, 27));
            } else {
                s.pID = 0;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            if (isInteger(parseElement(elements, 28))) {
                s.fID = Integer.parseInt(parseElement(elements, 28));
            } else {
                s.fID = 0;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            s.stay = parseElement(elements, 29);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.discipline = parseElement(elements, 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.oe = parseElement(elements, 31);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.klasse = parseElement(elements, 32);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.categorie = parseElement(elements, 33);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.entrance = convertStringToDate(parseElement(elements, 34));
        } catch (Exception e) {
            e.printStackTrace();
        }


        s.entranceTime = convertStringToTime(parseElement(elements, 35));


        try {
            s.leaving = convertStringToDate(parseElement(elements, 36));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.leavingTime = convertStringToTime(parseElement(elements, 37));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.p1PatientRequest = parseElement(elements, 38);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.p3StartWrangle = parseElement(elements, 39);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.p5PatientInOp = parseElement(elements, 40);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.o5StartClean = parseElement(elements, 41);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.o6StartPraesenzFirstOperateur = parseElement(elements, 42);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.o8StartOp = parseElement(elements, 43);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.o10EndOp = parseElement(elements, 44);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.o11End = parseElement(elements, 45);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.p7PatientOutOfOp = parseElement(elements, 46);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.notFallSpezifikation = parseElement(elements, 49);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

            if (isInteger(parseElement(elements, 50))) {
                s.terminAbweichung = Integer.parseInt(parseElement(elements, 50));
            } else {
                s.terminAbweichung = 0;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {

            if (isInteger(parseElement(elements, 51))) {
                s.terminAbweichungVorbereitung = Integer.parseInt(parseElement(elements, 51));
            } else {
                s.terminAbweichungVorbereitung = 0;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {


            if (isInteger(parseElement(elements, 52))) {
                s.terminAbweichungWiederaufbereitung = Integer.parseInt(parseElement(elements, 52));
            } else {
                s.terminAbweichungWiederaufbereitung = 0;
            }


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {


            if (isInteger(parseElement(elements, 53))) {
                s.terminArtID = Integer.parseInt(parseElement(elements, 53));
            } else {
                s.terminArtID = 0;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {


            if (isInteger(parseElement(elements, 54))) {
                s.terminArtCode = Integer.parseInt(parseElement(elements, 54));
            } else {
                s.terminArtCode = 0;

            }


        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        if (isInteger(parseElement(elements, 55))) {
            s.terminID = Integer.parseInt(parseElement(elements, 55));
        } else {
            s.terminID = 0;
        }


        return s;

    }



    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------



    static String parseElement(String[] elements, int index) {
        if (index >= elements.length) {
            return "";
        } else {
            return elements[index];
        }
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        } // only got here if we didn't return false return true;

        return true;
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    static String convertStringToDate(String dateString)
    {

        String formatteddate = null;
        DateFormat formatter;

        formatter = new SimpleDateFormat("dd.MM.yyyy");
        try{
            Date string=formatter.parse(dateString);
            formatteddate = formatter.format(string);

        }
        catch ( Exception ex ){
            //System.out.println(ex);
        }
        return formatteddate;
    }




  static  boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
           // System.out.println(date);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }




    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
/*
    static String convertStringToDateTime(String dateString)
    {

        String formatteddate = null;
        DateTimeFormatter formatter;

        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyyHH:mm:ss");
        try{
            LocalDateTime stirng =LocalDateTime.from(formatter.parse(dateString));
            //  formatteddate = formatter
 .format(string);



        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
        return formatteddate;






    }
*/


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------//



    static String convertStringToTime(String timeString)
    {

        timeString = timeString.concat(":00");
        String formattedtime = null;
        DateFormat formatter;

        formatter = new SimpleDateFormat("HH:mm:ss");
        try{
            Date string=formatter.parse(timeString);
            formattedtime = formatter.format(string);

        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
        return formattedtime;
    }


    static String convertStandardStringToTime(String timeString)
    {


        String formattedtime = null;
        DateFormat formatter;

        formatter = new SimpleDateFormat("HH:mm:ss");
        try{
            Date string=formatter.parse(timeString);
            formattedtime = formatter.format(string);

        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
        return formattedtime;
    }


/*
    static String convertStringToDateTime(String timeString)
    {


        String formattedtime = null;
        DateFormat formatter;

        formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try{
            Date string=formatter.parse(timeString);
            formattedtime = formatter.format(string);

        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
        return formattedtime;
    }
*/

}






