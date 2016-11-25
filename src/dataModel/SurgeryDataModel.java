package dataModel;


/**
 * Holds data from a specific variable of a file
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Holds data from a specific variable of a file
 */
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
    public String p1PatientRequest;
    public String p3StartWrangle;
    public String p5PatientInOp;
    public String p7PatientOutOfOp;
    public String o1StartPreparingOpFunction;
    public String o5StartClean;
    public String o6StartPraesenzFirstOperateur;
    public String o8StartOp;
    public String o10EndOp;
    public String o11End;
    public String notFallSpezifikation;
    public int terminAbweichung;
    public int terminAbweichungVorbereitung;
    public int terminAbweichungWiederaufbereitung;
    public int terminArtID;
    public int terminArtCode;
    public int terminID;
    public String comment4;






    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    /**
     * Creates the column name for every parameter as String
     *
     * @return Columnnames as String
     */
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


    /**
     * Creates a DataContainer
     * @param dataSource The name of the variable.
     */
    public SurgeryDataModel(String dataSource){
        this.dataSource=dataSource;
    }



    /**
     * Returns the name of the variable.
     * @return The name of the variable.
     */
    public static SurgeryDataModel parseBruderholz(String[] elements)  {

        SurgeryDataModel bh = new SurgeryDataModel("Bruderholz");


        if (isTimebiggerThanTime(parseElement(elements,3),parseElement(elements,4))) {
            System.out.println(" Bruderholz->start ist grösser als end: "+parseElement(elements,3)+"zu"+parseElement(elements,4));
          //  return new ExceptionHandling(" Bruderholz->start ist grösser als end: "+parseElement(elements,3)+"zu"+parseElement(elements,4));
        } else {
            System.out.println("-");
        }



        if (isDatebiggerThanDate(parseElement(elements,37),parseElement(elements,39))) {
            System.out.println(" Bruderholz->entrance ist grösser als leaving : "+parseElement(elements,37)+"zu"+parseElement(elements,39));
        } else {
            System.out.println("-");
        }




        try {

            if (isStringEmpty(parseElement(elements,0))) {
                if (isValidDatestamp(parseElement(elements,0))) {
                    if (isExpire(parseElement(elements,0))) {
                        bh.opDate =convertStringToDate( parseElement(elements, 0));
                    } else {
                        System.out.println("date: ist nicht möglich");
                    }
                } else {
                    System.out.println("hier stimmt was nicht brooo:  ");
                }
            } else { bh.opDate="-";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,2))) {
                bh.opRoom = parseElement(elements, 2);
            } else {
                bh.opRoom="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,3))) {
                bh.start=convertStringToTime(parseElement(elements, 3));
            } else {
                bh.start="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,4))) {
                bh.end = convertStringToTime(parseElement(elements, 4));
            } else {
                bh.end="-";
            }
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
            if (isStringEmpty(parseElement(elements,6))) {
                bh.meetingIdentifier = parseElement(elements, 6);
            } else {
                bh.meetingIdentifier="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,7))) {
                bh.comment1 = parseElement(elements, 7);
            } else {
                bh.comment1="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,8))) {
                bh.comment2 = parseElement(elements, 8);
            } else {
                bh.comment2="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,9))) {
                bh.comment3 = parseElement(elements, 9);
            } else {
                bh.comment3="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,10))) {
                bh.meetingNotice = parseElement(elements, 10);
            } else {
                bh.meetingNotice="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,11))) {
                bh.tattCode = parseElement(elements, 11);
            } else {
                bh.tattCode="-";
            }
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

            if (isStringEmpty(parseElement(elements,18))) {
                bh.operatuer = parseElement(elements, 18);
            } else {
                bh.operatuer="-";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,19))) {
                bh.assistance = parseElement(elements, 19);
            } else {
                bh.assistance="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,20))) {
                bh.anaesthesia = parseElement(elements, 20);
            } else {
                bh.anaesthesia="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,21))) {
                bh.anaesthesiaCare = parseElement(elements, 21);
            } else {
                bh.anaesthesiaCare="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,22))) {
                bh.instrumentation = parseElement(elements, 22);
            } else {
                bh.instrumentation="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,23))) {
                bh.zudienung = parseElement(elements, 23);
            } else {
                bh.zudienung="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,24))) {
                bh.patientLastName = parseElement(elements, 24);
            } else {
                bh.patientLastName="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            if (isStringEmpty(parseElement(elements,25))) {
                bh.patientFirstName = parseElement(elements, 25);
            } else {
                bh.patientFirstName="-";
            }
        } catch (Exception e) {

            e.printStackTrace();

        }


        try {


            if (isStringEmpty(parseElement(elements,26))) {
                if (isValidDatestamp(parseElement(elements,26))) {
                    if (isExpire(parseElement(elements,26))) {
                        bh.birthDate = convertStringToDate(parseElement(elements, 26));
                    } else {
                        System.out.println("Hier stimmt was nicht: "+parseElement(elements,26));
                    }
                } else {
                    System.out.println("hier stimmt was nicht");
                }
            } else {
                bh.birthDate="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,27))) {
                bh.gender = parseElement(elements, 27);
            } else {
                bh.gender="-";
            }
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
            if (isStringEmpty(parseElement(elements,29))) {
                bh.room = parseElement(elements, 29);
            } else {
                bh.room="-";
            }
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
            if (isStringEmpty(parseElement(elements,32))) {
                bh.stay = parseElement(elements, 32);
            } else {
                bh.stay="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,33))) {
                bh.discipline = parseElement(elements, 33);
            } else {
                bh.discipline="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,34))) {
                bh.oe = parseElement(elements, 34);
            } else {
                bh.oe="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,35))) {
                bh.klasse = parseElement(elements, 35);
            } else {
                bh.klasse="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,26))) {
                bh.categorie = parseElement(elements, 36);
            } else {
                bh.categorie="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,37))) {
                if (isValidDatestamp(parseElement(elements,37))) {
                    bh.entrance = convertStringToDate(parseElement(elements, 37));
                } else {
                    System.out.println("hier stimmt was nicht");
                }
            } else {
                bh.entrance="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,38))) {
                bh.entranceTime =convertStringToTime( parseElement(elements, 38));
            } else {
                bh.entranceTime="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,39))) {
                if (isValidDatestamp(parseElement(elements,39))) {
                    bh.leaving = convertStringToDate(parseElement(elements, 39));
                } else {
                    System.out.println("hier stimmt was nicht");
                }
            } else {
                bh.leaving="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,40))) {
                bh.leavingTime = convertStringToTime(parseElement(elements, 40));
            } else {
                bh.leavingTime="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,42))) {
                bh.p1PatientRequest = parseElement(elements, 42);
            } else {
                bh.p1PatientRequest="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,43))) {
                bh.p3StartWrangle =convertStandardStringToTime(parseElement(elements, 43));
            } else {
                bh.p3StartWrangle="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,44))) {
                bh.o1StartPreparingOpFunction = convertStandardStringToTime(parseElement(elements, 44));
            } else {
                bh.o1StartPreparingOpFunction="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,45))) {
                bh.o6StartPraesenzFirstOperateur =convertStandardStringToTime( parseElement(elements, 45));
            } else {bh.o6StartPraesenzFirstOperateur="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,45))) {
                bh.o5StartClean =convertStandardStringToTime(parseElement(elements, 46));
            } else {bh.o5StartClean="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,47))) {
                bh.o6StartPraesenzFirstOperateur =convertStandardStringToTime( parseElement(elements, 47));
            } else {bh.o6StartPraesenzFirstOperateur="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,48))) {
                bh.o8StartOp =convertStandardStringToTime( parseElement(elements, 48));
            } else {bh.o8StartOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,49))) {
                bh.o10EndOp =convertStandardStringToTime( parseElement(elements, 49));
            } else {bh.o10EndOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,50))) {
                bh.o11End =convertStandardStringToTime(parseElement(elements, 50));
            } else {bh.o11End="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,51))) {
                bh.p7PatientOutOfOp =convertStandardStringToTime( parseElement(elements, 51));
            } else {bh.p7PatientOutOfOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,54))) {
                bh.comment4 = parseElement(elements, 54);
            } else {bh.p7PatientOutOfOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bh;

    }


    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------





    /**
     * Returns the name of the variable.
     * @return The name of the variable.
     */

    public static SurgeryDataModel parseLiestal(String[] elements) {
        SurgeryDataModel s = new SurgeryDataModel("Liestal");

        if (isTimebiggerThanTime(parseElement(elements,3),parseElement(elements,4))) {
            System.out.println("Liestal ->start ist grösser als end: "+parseElement(elements,3)+"zu"+parseElement(elements,4));
        } else {System.out.println("-");
        }
        System.out.println("-");


        if (isDatebiggerThanDate(parseElement(elements,34),parseElement(elements,36))) {
            System.out.println(" Liestal->entrance ist grösser als leaving : "+parseElement(elements,34)+"zu"+parseElement(elements,36));
        } else {System.out.println("-");
        }



        try {

            if (isStringEmpty(parseElement(elements,0))) {
                if (isValidDatestamp(parseElement(elements,0))) {
                    if (isExpire(parseElement(elements,0))) {
                        s.opDate = convertStringToDate(parseElement(elements, 0));
                    } else {
                        System.out.println("date-das kann nicht sein");
                    }
                } else {
                    System.out.println("hier stimmt was nicht brooo:  ");
                }
            } else {s.opDate="-";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,2))) {
                s.opRoom = parseElement(elements, 2);
            } else {s.opRoom="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,3))) {
                s.start = convertStringToTime(parseElement(elements, 3));
            } else {s.start="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,4))) {
                s.end = convertStringToTime(parseElement(elements, 4));
            } else {s.end="-";
            }
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
            if (isStringEmpty(parseElement(elements,6))) {
                s.meetingIdentifier = parseElement(elements, 6);
            } else {s.meetingIdentifier="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            if (isStringEmpty(parseElement(elements,7))) {
                s.comment1 = parseElement(elements, 7);
            } else {s.comment1="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,8))) {
                s.comment2 = parseElement(elements, 8);
            } else {s.comment2="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,9))) {
                s.comment3 = parseElement(elements, 9);
            } else {s.comment3="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,10))) {
                s.meetingNotice = parseElement(elements, 10);
            } else {s.meetingNotice="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,11))) {
                s.tattCode = parseElement(elements, 11);
            } else {s.tattCode="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,12))) {
                s.taCode = parseElement(elements, 12);
            } else {s.taCode="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,13))) {
                s.taStatistic = parseElement(elements, 13);
            } else {s.taStatistic="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,14))) {
                s.taIdnetifier = parseElement(elements, 14);
            } else {s.taIdnetifier="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,15))) {
                s.operatuer = parseElement(elements, 15);
            } else {s.operatuer="";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,16))) {
                s.assistance = parseElement(elements, 16);
            } else {s.assistance="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,17))) {
                s.anaesthesia = parseElement(elements, 17);
            } else {s.anaesthesia="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,18))) {
                s.anaesthesiaCare = parseElement(elements, 18);
            } else {s.anaesthesiaCare="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,19))) {
                s.instrumentation = parseElement(elements, 19);
            } else {s.instrumentation="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,20))) {
                s.zudienung = parseElement(elements, 20);
            } else {s.zudienung="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,21))) {
                s.patientLastName = parseElement(elements, 21);
            } else {s.patientLastName="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,22))) {
                s.patientFirstName = parseElement(elements, 22);
            } else {s.patientFirstName="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,23))) {
                if (isValidDatestamp(parseElement(elements,23))) {
                    if (isExpire(parseElement(elements,23))) {
                        s.birthDate = convertStringToDate(parseElement(elements, 23));
                    } else {
                        System.out.println("hier stimmt was nicht: "+ parseElement(elements,23));
                    }
                } else {
                    System.out.println("hier stimmt was nicht");
                }
            } else {s.birthDate="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,24))) {
                s.gender = parseElement(elements, 24);
            } else {s.gender="-";
            }
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
            if (isStringEmpty(parseElement(elements,25))) {
                s.room = parseElement(elements, 26);
            } else {s.room="-";
            }
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
            if (isStringEmpty(parseElement(elements,29))) {
                s.stay = parseElement(elements, 29);
            } else {s.stay="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,30))) {
                s.discipline = parseElement(elements, 30);
            } else {s.discipline="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,31))) {
                s.oe = parseElement(elements, 31);
            } else {s.oe="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,32))) {
                s.klasse = parseElement(elements, 32);
            } else {s.klasse="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isStringEmpty(parseElement(elements,33))) {
                s.categorie = parseElement(elements, 33);
            } else {s.categorie="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,34))) {
                if (isValidDatestamp(parseElement(elements,34))) {
                    s.entrance = convertStringToDate(parseElement(elements, 34));
                } else {
                    System.out.println("hier stimmt was nicht");
                }
            } else {s.entrance="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,35))) {
                s.entranceTime = convertStringToTime(parseElement(elements, 35));
            } else {s.entranceTime="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,36))) {
                if (isValidDatestamp(parseElement(elements,36))) {
                    s.leaving = convertStringToDate(parseElement(elements, 36));
                } else {
                    System.out.println("hier stimmt was nicht");
                }
            } else {s.leaving="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,37))) {
                s.leavingTime = convertStringToTime(parseElement(elements, 37));
            } else {s.leavingTime="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (isStringEmpty(parseElement(elements,38))) {
                s.p1PatientRequest = parseElement(elements, 38);
            } else {s.p1PatientRequest="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,39))) {
                s.p3StartWrangle = parseElement(elements, 39);
            } else {s.p3StartWrangle="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,40))) {
                s.p5PatientInOp = parseElement(elements, 40);
            } else {s.p5PatientInOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,41))) {
                s.o5StartClean = parseElement(elements, 41);
            } else {s.o5StartClean="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,42))) {
                s.o6StartPraesenzFirstOperateur = parseElement(elements, 42);
            } else {s.o6StartPraesenzFirstOperateur="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,43))) {
                s.o8StartOp = parseElement(elements, 43);
            } else {s.o8StartOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,44))) {
                s.o10EndOp = parseElement(elements, 44);
            } else {s.o10EndOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,45))) {
                s.o11End = parseElement(elements, 45);
            } else {s.o11End="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,46))) {
                s.p7PatientOutOfOp = parseElement(elements, 46);
            } else {s.p7PatientOutOfOp="-";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (isStringEmpty(parseElement(elements,49))) {
                s.notFallSpezifikation = parseElement(elements, 49);
            } else {s.notFallSpezifikation="-";
            }
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




    /**
     * Parse every row
     *
     * @param elements, index
     * @return elements in a Array
     */
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

    /**
     * Check if its interger
     *
     * @param s as String
     * @return true if its an integer
     */
    static boolean isInteger(String s) {
        try {
            //noinspection ResultOfMethodCallIgnored
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


    /**
     * Convert a String to Date format
     *
     * @param dateString as a String
     * @return fomratted date
     */
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



    /**
     * To check whether the given Datestamp is valid or not. If Valid means erturn true. else, return false.
     *
     * @param timeStamp as a string
     * @return true, if is valid timestamp
     */
    public static boolean isValidDatestamp(String timeStamp) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            sdf.setLenient(false);
            sdf.parse(timeStamp);
        } catch (ParseException e) {
            throw new Exception("Invalid Timestamp...");
        }
        return true;
    }



    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------//




    /**
     * Convert String time values to type time
     *
     * @param timeString as a string
     * @return formattedtime as time in time
     */

    static String convertStringToTime(String timeString) {

        timeString = timeString.concat(":00");
        String formattedtime = null;
        DateFormat formatter;

        formatter = new SimpleDateFormat("HH:mm:ss");
        try{
            Date string=formatter.parse(timeString);
            formattedtime = formatter.format(string);

        }
        catch ( Exception ex ){
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(ex);
        }
        return formattedtime;
    }



    /**
     * Convert String time values without extension to type time
     *
     * @param timeString as a string
     * @return formattedtime as time in time
     */

    static String convertStandardStringToTime(String timeString) {


        String formattedtime = null;
        DateFormat formatter;

        formatter = new SimpleDateFormat("HH:mm:ss");
        try{
            Date string=formatter.parse(timeString);
            formattedtime = formatter.format(string);

        }
        catch ( Exception ex ){
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(ex);
        }
        return formattedtime;
    }





    /**
     * Check if input is empty
     *
     * @param input as a string
     */

    public static boolean isStringEmpty(String input){
        return !input.equals("");
    }


    /**
     * Compare date with current date
     *
     * @param date as a string
     * @return true, if expired
     */

    public static boolean isExpire(String date){
        if(date.isEmpty() || date.trim().equals("")){
            return false;
        }else{
            SimpleDateFormat sdf =  new SimpleDateFormat("dd.MM.yyyy"); // Jan-20-2015 1:30:55 PM
            Date d;
            Date d1;
            String today=   getToday("dd.MM.yyyy");
            try {
                //System.out.println("expdate>> "+date);
                //System.out.println("today>> "+today+"\n\n");
                d = sdf.parse(date);
                d1 = sdf.parse(today);
                if(d1.compareTo(d) <0){// not expired
                    return false;
                }else if(d.compareTo(d1)==0){// both date are same
                    if(d.getTime() < d1.getTime()){// not expired
                        return false;
                    }else if(d.getTime() == d1.getTime()){//expired
                        return true;
                    }else{//expired
                        return true;
                    }
                }else{//expired
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }
    }



    /**
     * Get todaysdate
     *
     * @param format as a string
     * @return Todays date
     */
    public static String getToday(String format){
        Date date = new Date();
        return new SimpleDateFormat(format).format(date);
    }


    /**
     * Check if start time is earlier than end time
     *
     * @param start as a String, end as a String
     * @return true if end time is earlier
     */
    public static boolean isTimebiggerThanTime(String start, String end){
        if(start.isEmpty() || start.trim().equals("")&& end.isEmpty()||end.equals("")){
            return false;

        }else{
            SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm"); //  01:30 PM
            Date d1;
            Date d2;

            try {
                //System.out.println("expdate>> "+date);
                //System.out.println("today>> "+today+"\n\n");
                d1 = sdf.parse(start);
                d2 = sdf.parse(end);


                if(d1.compareTo(d2) <0){// not expired
                    return false;
                }else if(d1.compareTo(d2)==0){// both date are same
                    if(d1.getTime() < d2.getTime()){// not expired
                        return false;
                    }else if(d1.getTime() == d2.getTime()){//expired
                        return true;
                    }else{//expired
                        return true;
                    }
                }else{//expired
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * Check if start date is earlier than end date
     *
     * @param start as a String, end as a String
     * @return true if end date is earlier
     */

    public static boolean isDatebiggerThanDate(String start, String end){
        if(start.isEmpty() || start.trim().equals("")&& end.isEmpty()||end.equals("")){
            return false;

        }else{
            SimpleDateFormat sdf =  new SimpleDateFormat("dd.MM.yyyy"); //  01:30 PM
            Date d1;
            Date d2;

            try {
                //System.out.println("expdate>> "+date);
                //System.out.println("today>> "+today+"\n\n");
                d1 = sdf.parse(start);
                d2 = sdf.parse(end);


                if(d1.compareTo(d2) <0){// not expired
                    return false;
                }else if(d1.compareTo(d2)==0){// both date are same
                    if(d1.getTime() < d2.getTime()){// not expired
                        return false;
                    }else if(d1.getTime() == d2.getTime()){//expired
                        return true;
                    }else{//expired
                        return true;
                    }
                }else{//expired
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }
    }



}





