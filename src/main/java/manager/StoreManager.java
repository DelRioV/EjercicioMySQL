package manager;

import dao.Store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface StoreManager {
    public List<Store> findAllById(Connection con, Set<String> ids);

    public Store filtrerStoreById(Connection con, String word) throws SQLException;

    public boolean updateStore(Connection con,String name,String newName) throws SQLException;

    public boolean deleteStore(Connection con,String name) throws SQLException;

    public boolean insertStore(Connection con,String code,String name,String continent,String region,float surfaceArea,int population,String localName,String government,String code2) throws SQLException;

}
