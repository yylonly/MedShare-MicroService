package entity;

import entity.Patient;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-24T00:10:56")
@StaticMetamodel(Clinicaldetection.class)
public class Clinicaldetection_ { 

    public static volatile SingularAttribute<Clinicaldetection, String> times;
    public static volatile SingularAttribute<Clinicaldetection, String> antiHBs;
    public static volatile SingularAttribute<Clinicaldetection, String> hiv;
    public static volatile SingularAttribute<Clinicaldetection, Patient> patientID;
    public static volatile SingularAttribute<Clinicaldetection, String> hBsAg;
    public static volatile SingularAttribute<Clinicaldetection, Date> detectedDate;
    public static volatile SingularAttribute<Clinicaldetection, String> hcv;
    public static volatile SingularAttribute<Clinicaldetection, String> hdv;
    public static volatile SingularAttribute<Clinicaldetection, Integer> detectionID;

}