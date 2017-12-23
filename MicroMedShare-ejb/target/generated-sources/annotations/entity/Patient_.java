package entity;

import entity.Clinicaldetection;
import entity.Examination;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-24T00:10:56")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, String> country;
    public static volatile CollectionAttribute<Patient, Examination> examinationCollection;
    public static volatile SingularAttribute<Patient, Character> gender;
    public static volatile SingularAttribute<Patient, String> streetAddress;
    public static volatile SingularAttribute<Patient, String> city;
    public static volatile SingularAttribute<Patient, String> surname;
    public static volatile SingularAttribute<Patient, Date> doB;
    public static volatile SingularAttribute<Patient, String> name;
    public static volatile CollectionAttribute<Patient, Clinicaldetection> clinicaldetectionCollection;
    public static volatile SingularAttribute<Patient, Integer> pid;
    public static volatile SingularAttribute<Patient, String> postal;

}