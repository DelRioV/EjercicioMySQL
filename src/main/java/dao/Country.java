package dao;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.util.Date;
@Getter
@Setter
public class Country {
    String id;
    String name;
    Date lastUpdate;
    public Country(String id,String name, Date lastUpdate){
        setId(id);
        setName(name);
        setLastUpdate(lastUpdate);
    }

}
