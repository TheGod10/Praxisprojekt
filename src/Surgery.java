

import java.io.*;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by TheGod on 31.10.16.
 */

/**
 * Holds data from a specific variable of a file
 */
public class Surgery {
    private String opDate;
    private String opRoom;
    private String start;
    private String end;
    private String opDuaration;
    private String meetingIdentifier;
    private String comment1;
    private String comment2;
    private String comment3;
    private String meetingNotice;
    private String tattCode;
    private String taSequence;
    private String taCode;
    private String knotenID;
    private String taStatistic;
    private String knotenIdentifier;
    private String taIdnetifier;
    private String operatuer;
    private String assistance;
    private String anaesthesia;
    private String anaesthesiaCare;
    private String instrumentation;
    private String zudienung;
    private String patientFirstName;
    private String patientLastName;
    private String birthDate;
    private String gender;
    private String age;
    private String room;
    private String pID;
    private String fID;
    private String stay;
    private String discipline;
    private String oe;
    private String klasse;
    private String categorie;
    private String entrance;
    private String entranceTime;
    private String leaving;
    private String leavingTime;
    private String p1PatientRequest;
    private String p2PatientArrive;
    private String p3StartWrangle;
    private String p4EndWrangle;
    private String p5PatientInOp;
    private String p6EnrolmentToCareUnit;
    private String p7PatientOutOfOp;
    private String p8Umbetten;
    private String p9StartOpRoomClean;
    private String p10EndOpRoomClean;
    private String o1StartPreparingOpFunction;
    private String o2EndPreparingOpFunction;
    private String o3StartStore;
    private String o4EndStore;
    private String o5StartClean;
    private String o6StartPraesenzFirstOperateur;
    private String o7EndClean;
    private String o8StartOp;
    private String o9EndPraesenzOperateur;
    private String o10EndOp;
    private String o11End;
    private String o12EndAfterOpWorkFunction;
    private String notFallSpezifikation;
    private String terminAbweichung;
    private String terminAbweichungVorbereitung;
    private String terminAbweichungWiederaufbereitung;
    private String terminArtID;
    private String terminArtCode;
    private String terminID;
    private String comment4;


    public static Surgery parseLiestal(String[] elements) {

        Surgery s = new Surgery();
        s.opDate = elements[0].replace("OpDat_pp", "opDate");
        s.opRoom = elements[2].replace("OpSaal_pp", "opRoom");
        s.start = elements[3].replace("BelegungBeginn", "star");
        s.end = elements[4].replace("BelegungEnde", "end");
        s.opDuaration = elements[5].replace("BelegungDauerMin", "opDuaration ");
        s.meetingIdentifier = elements[6].replace("TerminBezeichnung", "meetingIdentifier ");
        s.comment1 = elements[7].replace("TerminText1", "comment1 ");
        s.comment2 = elements[8].replace("TerminText2", "comment2  ");
        s.comment3 = elements[9].replace("TerminText3", "comment3  ");
        s.meetingNotice = elements[10].replace("TerminBemerkungen", "meetingNotice ");
        s.tattCode = elements[11].replace("TATTCode", "tattCode ");
        s.taCode = elements[12].replace("TACode", "taCode ");
        s.taStatistic = elements[13].replace("TAStatistik", "taStatistic");
        s.taIdnetifier = elements[14].replace("TABezeichnung", "taIdnetifier ");
        s.operatuer = elements[15].replace("Operateur", "operatuer  ");
        s.assistance = elements[16].replace("Assistenz", "assistance");
        s.anaesthesia = elements[17].replace("Anaesthesie", "anaesthesia ");
        s.anaesthesiaCare = elements[18].replace("AnaePflege", "anaesthesiaCare  ");
        s.instrumentation = elements[19].replace("Instrumentierung", "instrumentation  ");
        s.zudienung = elements[20].replace("Zudienung", "zudienung ");
        s.patientLastName = elements[21].replace("Name_pp", "patientLastName ");
        s.patientFirstName = elements[22].replace("Vorname_pp", "patientFirstName ");
        s.birthDate = elements[23].replace("GebDat_pp", "birthDate");
        s.gender = elements[24].replace("Geschlecht_pp", "gender  ");
        s.age = elements[25].replace("Alter_pp", "age  ");
        s.room = elements[26].replace("Zimmer", "room ");
        s.pID = elements[27].replace("PID", "pID ");
        s.fID = elements[28].replace("PID", "fID ");
        s.stay = elements[29].replace("Aufenthalt", "stay  ");
        s.discipline = elements[30].replace("Disziplin_pp", "discipline ");
        s.oe = elements[31].replace("OE", "oe");
        s.klasse = elements[32].replace("Klasse", "klasse ");
        s.categorie = elements[33].replace("Kategorie", "categorie ");
        s.entrance = elements[34].replace("Eintritt", "entrance  ");
        s.entranceTime = elements[35].replace("EintrittZeit", "entranceTime  ");
        s.leaving = elements[36].replace("Austritt", "leaving  ");
        s.leavingTime = elements[37].replace("AustrittZeit", "leavingTime  ");
        s.p1PatientRequest = elements[38].replace("P1_PatAnf_pp", "p1PatientRequest ");
        s.p3StartWrangle = elements[39].replace("P3_BegEin_pp", "p3StartWrangle");
        s.p5PatientInOp = elements[40].replace("P5_ImSaal_pp", "p5PatientInOp ");
        s.o5StartClean = elements[41].replace("O5_BegAbwasch_pp", "o5StartClean");
        s.o6StartPraesenzFirstOperateur = elements[42].replace("O6_PräsOperateur_pp", "o6StartPraesenzFirstOperateur ");
        s.o8StartOp = elements[43].replace("O8_Schnitt_pp", "o8StartOp ");
        s.o10EndOp = elements[44].replace("O10_Naht_pp", "o10EndOp  ");
        s.o11End = elements[45].replace("O11_EndNachbMassn_pp", "o11End  ");
        s.p7PatientOutOfOp = elements[46].replace("P7_AusOp_pp", "p7PatientOutOfOp ");
        s.notFallSpezifikation = elements[49].replace("Notfallklassifikation", "notFallSpezifikation ");
        s.terminAbweichung = elements[50].replace("Termin_Abweichung", "terminAbweichung ");
        s.terminAbweichungVorbereitung = elements[51].replace("Termin_Abweichung_Vorbereitung", "terminAbweichungVorbereitung ");
        s.terminAbweichungWiederaufbereitung = elements[52].replace("Termin_Abweichung_Wiederaufbereitung", "terminAbweichungWiederaufbereitung ");
        s.terminArtID = elements[53].replace("TerminartID", "terminArtID");
        s.terminArtCode = elements[54].replace("TerminartCode", "terminArtCode ");
        s.terminID = elements[55].replace("TerminID", "terminID ");


        return s;

    }


    public static Surgery parseBruderholz(String[] elements) {

        Surgery bh = new Surgery();
        bh.opDate = elements[0].replace("OpDat_pp", "opDate");
        bh.opRoom = elements[2].replace("OpSaal_pp", "opRoom");
        bh.start = elements[3].replace("BelegungBeginn", "star");
        bh.end = elements[4].replace("BelegungEnde", "end");
        bh.opDuaration = elements[5].replace("BelegungDauerMin", "opDuaration ");
        bh.meetingIdentifier = elements[6].replace("TerminBezeichnung", "meetingIdentifier ");
        bh.comment1 = elements[7].replace("TerminText1", "comment1 ");
        bh.comment2 = elements[8].replace("TerminText2", "comment2  ");
        bh.comment3 = elements[9].replace("TerminText3", "comment3  ");
        bh.meetingNotice = elements[10].replace("TerminBemerkungen", "meetingNotice ");
        bh.tattCode = elements[11].replace("TATTCode", "tattCode ");
        bh.taCode = elements[12].replace("TACode", "taCode ");
        bh.taStatistic = elements[13].replace("TAStatistik", "taStatistic");
        bh.taIdnetifier = elements[14].replace("TABezeichnung", "taIdnetifier ");
        bh.operatuer = elements[15].replace("Operateur", "operatuer  ");
        bh.assistance = elements[16].replace("Assistenz", "assistance");
        bh.anaesthesia = elements[17].replace("Anaesthesie", "anaesthesia ");
        bh.anaesthesiaCare = elements[18].replace("AnaePflege", "anaesthesiaCare  ");
        bh.instrumentation = elements[19].replace("Instrumentierung", "instrumentation  ");
        bh.zudienung = elements[20].replace("Zudienung", "zudienung ");
        bh.patientLastName = elements[21].replace("Name_pp", "patientLastName ");
        bh.patientFirstName = elements[22].replace("Vorname_pp", "patientFirstName ");
        bh.birthDate = elements[23].replace("GebDat_pp", "birthDate");
        bh.gender = elements[24].replace("Geschlecht_pp", "gender  ");
        bh.age = elements[25].replace("Alter_pp", "age  ");
        bh.room = elements[26].replace("Zimmer", "room ");
        bh.pID = elements[27].replace("PID", "pID ");
        bh.fID = elements[28].replace("PID", "fID ");
        bh.stay = elements[29].replace("Aufenthalt", "stay  ");
        bh.discipline = elements[30].replace("Disziplin_pp", "discipline ");
        bh.oe = elements[31].replace("OE", "oe");
        bh.klasse = elements[32].replace("Klasse", "klasse ");
        bh.categorie = elements[33].replace("Kategorie", "categorie ");
        bh.entrance = elements[34].replace("Eintritt", "entrance  ");
        bh.entranceTime = elements[35].replace("EintrittZeit", "entranceTime  ");
        bh.leaving = elements[36].replace("Austritt", "leaving  ");
        bh.leavingTime = elements[37].replace("AustrittZeit", "leavingTime  ");
        bh.p1PatientRequest = elements[38].replace("P1_PatAnf_pp", "p1PatientRequest ");
        bh.p3StartWrangle = elements[39].replace("P3_BegEin_pp", "p3StartWrangle");
        bh.p5PatientInOp = elements[40].replace("P5_ImSaal_pp", "p5PatientInOp ");
        bh.o5StartClean = elements[41].replace("O5_BegAbwasch_pp", "o5StartClean");
        bh.o6StartPraesenzFirstOperateur = elements[42].replace("O6_PräsOperateur_pp", "o6StartPraesenzFirstOperateur ");
        bh.o8StartOp = elements[43].replace("O8_Schnitt_pp", "o8StartOp ");
        bh.o10EndOp = elements[44].replace("O10_Naht_pp", "o10EndOp  ");
        bh.o11End = elements[45].replace("O11_EndNachbMassn_pp", "o11End  ");
        bh.p7PatientOutOfOp = elements[46].replace("P7_AusOp_pp", "p7PatientOutOfOp ");
        bh.notFallSpezifikation = elements[49].replace("Notfallklassifikation", "notFallSpezifikation ");
        bh.terminAbweichung = elements[50].replace("Termin_Abweichung", "terminAbweichung ");
        bh.terminAbweichungVorbereitung = elements[51].replace("Termin_Abweichung_Vorbereitung", "terminAbweichungVorbereitung ");
        bh.terminAbweichungWiederaufbereitung = elements[52].replace("Termin_Abweichung_Wiederaufbereitung", "terminAbweichungWiederaufbereitung ");
        bh.terminArtID = elements[53].replace("TerminartID", "terminArtID");
        bh.terminArtCode = elements[54].replace("TerminartCode", "terminArtCode ");
        bh.terminID = elements[55].replace("TerminID", "terminID ");


        return bh;

    }


    public static void main(String[] args) throws Exception {
        ArrayList<Surgery> s = new ArrayList<Surgery>();
        ArrayList<Surgery> bh = new ArrayList<Surgery>();
        try {
            s = addDatatonewCsvLiestal();
            bh = addDatatonewCsvBruderholz();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(s.get(0).opDate);
        //System.out.println(s.get(0).patientFirstName);
        //System.out.println(bh.get(0).opDate);

// Hier wird die NewList aus addDatatonewCsvLiestal() und addDatatonewCsvBruderholz() erstellt.

        Set<Surgery> newSet = new HashSet<Surgery>(addDatatonewCsvLiestal());
        newSet.addAll(addDatatonewCsvBruderholz());
        ArrayList<Surgery> newList = new ArrayList<Surgery>(newSet);

        // System.out.println(newList.toString());

// Diese Methode speicher den Inhalt von NewList in eine neue CSV-Datei
        listInDatei(newList,new File("/Users/TheGod/Desktop/Praxisprojekt/src/newFile.csv"));


    }


    public static ArrayList<Surgery> addDatatonewCsvLiestal(/*File file*/) throws Exception {
        ArrayList<Surgery> surgeriesLi = new ArrayList<>();

        try {
            Scanner sc = new Scanner((new FileReader("/Users/TheGod/Desktop/Praxisprojekt/src/Polypoint RAP Liestal Februar 2016.csv")));
            // boolean output = true;
            String splitby = ";";

            // int crt = 0;
            while (sc.hasNextLine())

            {

                //System.out.println(crt++);
                String line = sc.nextLine();

                Surgery s = parseLiestal(line.split(splitby));

                surgeriesLi.add(s);


                //java.lang.String[] b = line.split(splitby);
                /*if (output) {
                    for (int i = 0; i < b.length; i++)
                        System.out.println(b[i]);
                    System.out.println("-----------------------------------------------------");
                }*/


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surgeriesLi;
    }


    public static ArrayList<Surgery> addDatatonewCsvBruderholz(/*File file*/) throws Exception {
        ArrayList<Surgery> surgeriesBH = new ArrayList<>();

        try {
            Scanner sc2 = new Scanner((new FileReader("/Users/TheGod/Desktop/Praxisprojekt/src/Polypoint RAP Liestal Februar 2016.csv")));
            // boolean output = true;
            String splitby = ";";

            // int crt = 0;
            while (sc2.hasNextLine())

            {

                //System.out.println(crt++);
                String line = sc2.nextLine();

                Surgery bh = parseBruderholz(line.split(splitby));

                surgeriesBH.add(bh);


                //java.lang.String[] b = line.split(splitby);
                /*if (output) {
                    for (int i = 0; i < b.length; i++)
                        System.out.println(b[i]);
                    System.out.println("-----------------------------------------------------");
                }*/


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surgeriesBH;
    }

    /**
     * Methode erstellt aus einer Liste eine Datei! Kein Rückgabewert, nur eine Funktion, die in der MainMethode ist.
     * @param list
     * @param file
     */
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


}







