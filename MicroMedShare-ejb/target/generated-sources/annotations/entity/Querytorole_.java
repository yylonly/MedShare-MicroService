package entity;

import entity.Querylist;
import entity.QuerytorolePK;
import entity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-24T00:10:56")
@StaticMetamodel(Querytorole.class)
public class Querytorole_ { 

    public static volatile SingularAttribute<Querytorole, Role> role;
    public static volatile SingularAttribute<Querytorole, QuerytorolePK> querytorolePK;
    public static volatile SingularAttribute<Querytorole, String> description;
    public static volatile SingularAttribute<Querytorole, Querylist> querylist;

}