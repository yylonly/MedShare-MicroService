package entity;

import entity.Querytorole;
import entity.Urlforwebservice;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-24T00:10:56")
@StaticMetamodel(Querylist.class)
public class Querylist_ { 

    public static volatile CollectionAttribute<Querylist, Querytorole> querytoroleCollection;
    public static volatile SingularAttribute<Querylist, String> description;
    public static volatile SingularAttribute<Querylist, Integer> id;
    public static volatile SingularAttribute<Querylist, String> sqlquery;
    public static volatile SingularAttribute<Querylist, Urlforwebservice> urlid;

}