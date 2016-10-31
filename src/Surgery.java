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
    private Integer tattCode;
    private Integer taSequence;
    private Integer taCode;
    private Integer knotenID;
    private Integer taStatistic;
    private Integer knotenIdentifier;
    private Integer taIdnetifier;
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




    public Surgery parseLiestal (String[] elements, Date[] dateElements, Time[] timeElements, Integer[] numberElements) {

        Surgery s = new Surgery();
        s.opDate = dateElements[1];
        s.opRoom = elements[3];
        s.start = timeElements[4];
        s.end = timeElements[5];
        s.opDuaration = numberElements[6];
        


    }


}
