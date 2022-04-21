package manager;

import dao.Inventor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface InventorManager {
    public List<Inventor> findAllById(Connection con, Set<String> ids);

    public Inventor filtrerInventorById(Connection con, String word) throws SQLException;

    public void updateInventor(Connection con,String name,String newName) throws SQLException;

    public void deleteInventor(Connection con,String name) throws SQLException;

    public void insertInventor(Connection con,String code,String name,String continent,String region,float surfaceArea,int population,String localName,String government,String code2) throws SQLException;

}
