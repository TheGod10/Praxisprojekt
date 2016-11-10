package dataModel;


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

    private double exampleNumericColumn;


    public static Surgery parseLiestal(String[] elements) {

        Surgery s = new Surgery();

        try {
            s.opDate = parseElement(elements, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.opRoom = parseElement(elements, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            s.start = parseElement(elements, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            s.end = parseElement(elements, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

            s.opDuaration = parseElement(elements, 5);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        s.meetingIdentifier = parseElement(elements, 6);
        s.comment1 = parseElement(elements, 7);
        s.comment2 = parseElement(elements, 8);
        s.comment3 = parseElement(elements, 9);
        s.meetingNotice = parseElement(elements, 10);


        s.tattCode = parseElement(elements, 11);


        try {
            s.taCode = parseElement(elements, 12);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        s.taStatistic = parseElement(elements, 13);

        s.taIdnetifier = parseElement(elements, 14);

        s.operatuer = parseElement(elements, 15);

        s.assistance = parseElement(elements, 16);
        s.anaesthesia = parseElement(elements, 17);
        s.anaesthesiaCare = parseElement(elements, 18);

        s.instrumentation = parseElement(elements, 19);
        s.zudienung = parseElement(elements, 20);

        s.patientLastName = parseElement(elements, 21);
        s.patientFirstName = parseElement(elements, 22);


        s.birthDate = parseElement(elements, 23);


        s.gender = parseElement(elements, 24);


        try {
            s.age = parseElement(elements, 25);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        s.room = parseElement(elements, 26);


        try {

            s.pID = parseElement(elements, 27);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {
            s.fID = parseElement(elements, 28);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        s.stay = parseElement(elements, 29);
        s.discipline = parseElement(elements, 30);
        s.oe = parseElement(elements, 31);
        s.klasse = parseElement(elements, 32);
        s.categorie = parseElement(elements, 33);


        s.entrance = parseElement(elements, 34);


        s.entranceTime = parseElement(elements, 35);


        s.leaving = parseElement(elements, 36);


        s.leavingTime = parseElement(elements, 37);


        s.p1PatientRequest = parseElement(elements, 38);
        s.p3StartWrangle = parseElement(elements, 39);
        s.p5PatientInOp = parseElement(elements, 40);
        s.o5StartClean = parseElement(elements, 41);
        s.o6StartPraesenzFirstOperateur = parseElement(elements, 42);
        s.o8StartOp = parseElement(elements, 43);
        s.o10EndOp = parseElement(elements, 44);
        s.o11End = parseElement(elements, 45);
        s.p7PatientOutOfOp = parseElement(elements, 46);
        s.notFallSpezifikation = parseElement(elements, 49);


        try {

            s.terminAbweichung = parseElement(elements, 50);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        try {

            s.terminAbweichungVorbereitung = parseElement(elements, 51);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {


            s.terminAbweichungWiederaufbereitung = parseElement(elements, 52);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {


            s.terminArtID = parseElement(elements, 53);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {


            s.terminArtCode = parseElement(elements, 54);


        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        s.terminID = parseElement(elements, 55);


        return s;


    }

    public static Surgery parseBruderholz(String[] elements) {

        Surgery bh = new Surgery();


        try {
            System.out.println("parsing " + parseElement(elements, 0));
            bh.opDate = parseElement(elements, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }


        bh.opRoom = parseElement(elements, 2);


        try {
            bh.start =parseElement(elements,3);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.end = parseElement(elements,4);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            bh.opDuaration = parseElement(elements,5);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        bh.meetingIdentifier = parseElement(elements,6);
        bh.comment1 = parseElement(elements,7);
        bh.comment2 = parseElement(elements,8);
        bh.comment3 = parseElement(elements,9);
        bh.meetingNotice = parseElement(elements,10);
        bh.tattCode = parseElement(elements,11);


        try {
            bh.taSequence=parseElement(elements,12);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }



        try {
            bh.taCode =parseElement(elements,13);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }



        try {
            bh.knotenID=parseElement(elements,14);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        bh.taStatistic = parseElement(elements,15);
        bh.knotenIdentifier=parseElement(elements,16);
        bh.taIdnetifier = parseElement(elements,17);
        bh.operatuer = parseElement(elements,18);
        bh.assistance =parseElement(elements,19);
        bh.anaesthesia = parseElement(elements,20);
        bh.anaesthesiaCare = parseElement(elements,21);
        bh.instrumentation =parseElement(elements,22);
        bh.zudienung = parseElement(elements,23);
        bh.patientLastName = parseElement(elements,24);
        bh.patientFirstName = parseElement(elements,25);


        try {
            bh.birthDate = parseElement(elements,26);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bh.gender =parseElement(elements,28);

        try {
            bh.age = parseElement(elements,29);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        bh.room = parseElement(elements,30);


        try {
            bh.pID =parseElement(elements,31);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bh.fID =parseElement(elements,32);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bh.stay = parseElement(elements,33);
        bh.discipline = parseElement(elements,34);
        bh.oe = parseElement(elements,35);
        bh.klasse = parseElement(elements,36);
        bh.categorie = parseElement(elements,37);


        try {
            bh.entrance =parseElement(elements,38);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.entranceTime = parseElement(elements,39);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.leaving =parseElement(elements,40);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bh.leavingTime = parseElement(elements,41);
        } catch (Exception e) {
            e.printStackTrace();
        }


        bh.p1PatientRequest = parseElement(elements,42);
        bh.p3StartWrangle =parseElement(elements,43);
        bh.o1StartPreparingOpFunction=parseElement(elements,44);
        bh.o6StartPraesenzFirstOperateur=parseElement(elements,45);
        bh.o5StartClean=parseElement(elements,46);
        bh.o6StartPraesenzFirstOperateur=parseElement(elements,47);
        bh.o8StartOp=parseElement(elements,48);
        bh.o10EndOp=parseElement(elements,49);
        bh.o11End=parseElement(elements,50);
        bh.p7PatientOutOfOp=parseElement(elements,51);
        bh.comment4=parseElement(elements,54);

        try {
            bh.terminID =parseElement(elements,55);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return bh;

    }

    static String parseElement(String[] elements, int index) {
        if (index >= elements.length) {
            return "";
        } else {
            return elements[index];
        }
    }


    @Override
    public String toString()
    {

        return  opDate +";"+opRoom+";"+start+";"+";"+end+";"+opDuaration+";"+meetingIdentifier+";"+comment1+";"+comment2+";"+comment3+";"+meetingNotice+";"+
                tattCode+";"+taCode+";"+taStatistic+";"+
                taIdnetifier+";"+operatuer+";"+assistance+";"+anaesthesia+";"+anaesthesiaCare+";"+instrumentation+";"+zudienung+";"+patientLastName+";"+
                patientFirstName+";"+birthDate+";"+gender+";"+age+";"+room+";"+pID+";"+fID
                +";"+stay+";"+discipline+";"+oe+";"+klasse+";"+entrance+";"+entranceTime+";"+leaving+";"+leavingTime+";"+p1PatientRequest+";"+p3StartWrangle+";"+
                p5PatientInOp+";"+o5StartClean+";"+o6StartPraesenzFirstOperateur+";"+o8StartOp+";"+o10EndOp+";"+o11End+";"+p7PatientOutOfOp+";"+
                notFallSpezifikation+";"+terminAbweichung+";"+terminAbweichungVorbereitung+";"+
                terminAbweichungWiederaufbereitung+";"+terminArtID+";"+terminArtCode+";"+terminID;
    }

}



