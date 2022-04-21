package dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Actor {

    String id;
    String firstName;
    String lastName;
    Date lastUpdate;
    public Actor(String id,String firstName,String lastName,Date lastUpdate){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setLastUpdate(lastUpdate);
    }
}
