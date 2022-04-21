package dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Store {
    String store_id;
    String manger_staff_id;
    String address_id;
    Date lastUpdate;
    public Store(String store_id, String manger_staff_id, String address_id, Date lastUpdate){
        setStore_id(store_id);
        setAddress_id(address_id);
        setManger_staff_id(manger_staff_id);
        setLastUpdate(lastUpdate);
    }
}
