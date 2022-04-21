package dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class FilmCategory {
    String id;
    String category;
    Date lastUpdate;
    public FilmCategory(String id, String category, Date lastUpdate){
        setId(id);
        setCategory(category);
        setLastUpdate(lastUpdate);
    }
}
