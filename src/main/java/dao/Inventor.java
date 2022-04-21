package dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Inventor {
    String inv_id;
    String film_id;
    String store_id;
    Date lastUpdate;
    public Inventor(String inv_id, String film_id , String store_id , Date lastUpdate){
        setInv_id(inv_id);
        setFilm_id(film_id);
        setStore_id(store_id);
        setLastUpdate(lastUpdate);
    }
}
