import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by TheGod on 31.10.16.
 */

/**
 * Holds data from a specific variable of a file
 */
public class Surgery {
    private Date opDate;
    private String opRoom;
    private Time start;
    private Time end;
    private Integer opDuaration;
    private String meetingIdentifier;
    private String comment1;
    private String comment2;
    private String comment3;
    private String meetingNotice;
    private Character tattCode;
    private Integer taSequence;
    private Integer taCode;
    private Integer knotenID;
    private Integer taStatistic;
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
    private Date birthDate;
    private char gender;
    private Integer age;
    private String room;
    private Integer pID;
    private Integer fID;
    private String stay;
    private String discipline;
    private String oe;
    private String Klasse;
    private String categorie;
    private Date entrance;
    private Time entranceTime;
    private Date leaving;
    private Time leavingTime;
    private Time p1PatientRequest;
    private Time p2PatientArrive;
    private Time p3StartWrangle;
    private Time p4EndWrangle;
    private Time p5PatientInOp;
    private Time p6EnrolmentToCareUnit;
    private Time p7PatientOutOfOp;
    private Time p8Umbetten;
    private Time p9StartOpRoomClean;
    private Time p10EndOpRoomClean;
    private Time o1StartPreparingOpFunction;
    private Time o2EndPreparingOpFunction;
    private Time o3StartStore;
    private Time o4EndStore;
    private Time o5StartClean;
    private Time o6StartPraesenzFirstOperateur;
    private Time o7EndClean;
    private Time o8StartOp;
    private Time o9EndPraesenzOperateur;
    private Time o10EndOp;
    private Time o11End;
    private Time o12EndAfterOpWorkFunction;
    private String notFallSpezifikation;
    private Date terminAbweichungVorbereitung;
    private Date terminAbweichungWiederaufbereitung;
    private String terminArtID;
    private String terminArtCode;
    private String terminID;
    private String comment4;




    public Surgery parseLiestal (String[] elements, Date[] dateElements, Time[] timeElements, Integer[] numberElements) {

        Surgery s = new Surgery();
        s.opDate = dateElements[1];
        s.opRoom = elements[3];
        s.start = timeElements[4];
        s.end = timeElements[5];
        s.opDuaration = numberElements[6];
        


    }



    public Surgery parseBruderholz (String[] elements, Date[] dateElements, Time[]  timeElements, Integer[] numberElements, Character charelements[]){

        Surgery s=new Surgery();
        s.opDate=dateElements[1];
        s.opRoom=elements[3];
        s.start=timeElements[4];
        s.end=timeElements[5];
        s.opDuaration=numberElements[6];
        s.meetingIdentifier=elements[7];
        s.comment1=elements[8];
        s.comment2=elements[9];
        s.comment3=elements[10];
        s.meetingNotice=elements[11];
        s.tattCode=charelements[12];
        s.taSequence=numberElements[13];
        s.taCode=numberElements[14];
        s.knotenID=numberElements[15];
        s.taStatistic=numberElements[16];
        s.knotenIdentifier=elements[17];
        s.taIdnetifier=elements[18];
        s.operatuer=elements[20];
        s.assistance=elements[21];
        s.anaesthesiaCare=elements[22];
        s.instrumentation=elements[23];
        s.zudienung=elements[24];
        s.patientLastName=elements[25];
        s.patientFirstName=elements[26];
        s.birthDate=dateElements[27];
        s.gender=charelements[28];
        s.age=numberElements[29];
        s.room=elements[30];
        s.pID=numberElements[31];
        s.fID=numberElements[32];
        s.stay=elements[33];
        s.discipline=elements[34];
        s.oe=elements[35];
        s.Klasse=elements[36];
        s.categorie=elements[37];
        s.entrance=dateElements[38];
        s.entranceTime=timeElements[39];
        s.leaving=dateElements[40];
        s.leavingTime=timeElements[41];
        s.p1PatientRequest=timeElements[42];
        s.p3StartWrangle=timeElements[43];
        s.o1StartPreparingOpFunction=timeElements[44];
        s.o6StartPraesenzFirstOperateur=timeElements[45];
        s.o5StartClean=timeElements[46];
        s.o6StartPraesenzFirstOperateur=timeElements[47];
        s.o8StartOp=timeElements[48];
        s.o10EndOp=timeElements[49];
        s.o11End=timeElements[50];
        s.p7PatientOutOfOp=timeElements[51];
        s.comment4=elements[54];

        return s;
    }



}
