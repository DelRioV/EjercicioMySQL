package manager.impl;

import dao.Country;
import dao.Store;

import manager.StoreManager;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StoreManagerImp implements StoreManager {
    public List<Store> findAllById(Connection con, Set<String> ids) {
        // Creates the SQL command
        String sql = String.format("SELECT * FROM Store WHERE Code IN (%s)",
                ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));
        // "ESP","FR","DEU","UK","PR"
        // SELECT * FROM Store WHERE Code in ("ESP","FR","DEU","UK","PR"

        // Create a prepared statement
        try (Statement stmt = con.createStatement()) {

            // Executes sql command
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<Store> Stores = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a Store per result
                Stores.add(new Store(result.getString(1),result.getString(2),result.getString(3),result.getDate(4)));
            }

            return Stores;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Store filtrerStoreById(Connection con, String word) throws SQLException {

            Store store = null;
            try{
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM COUNTRY WHERE NAME LIKE ?");
                pstm.setString(1,word);
                ResultSet rs = pstm.executeQuery();
                store = new Store(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4));
                return store;

            } catch(SQLException e){
                e.printStackTrace();
                return null;
            }

    }

    @Override
    public boolean updateStore(Connection con, String name, String newName) throws SQLException {
        boolean kk = false;
        try{
            PreparedStatement pstm = con.prepareStatement("UPDATE Store SET NAME=? WHERE NAME=?");
            pstm.setString(1,newName);
            pstm.setString(2,name);
            ResultSet rs = pstm.executeQuery();
            kk = true;
            return kk;
        } catch (Exception e){
            e.printStackTrace();
            return kk;
    }
    }

    @Override
    public boolean deleteStore(Connection con, String name) throws SQLException {
        boolean kk = false;
        try{
            PreparedStatement pstm = con.prepareStatement("DELETE Store WHERE NAME=?");
            pstm.setString(1,name);
            ResultSet rs = pstm.executeQuery();
            kk = true;
            return kk;
        } catch (Exception e){
            e.printStackTrace();
            return kk;
        }
    }

    @Override
    public boolean insertStore(Connection con, String code, String name, String continent, String region, float surfaceArea, int population, String localName, String government, String code2) throws SQLException {
            boolean kk = false;
            try{
                PreparedStatement pstm = con.prepareStatement("INSERT INTO Store VALUES(CODE=?,NAME=?,CONTINENT=?,REGION=?,SURFACEAREA=?,POPULATION=?,LOCALNAME=?,GOVERNMENTFORM=?,CODE2=?)");
                pstm.setString(1,code);
                pstm.setString(2,name);
                pstm.setString(3,continent);
                pstm.setString(4,region);
                pstm.setFloat(5,surfaceArea);
                pstm.setInt(6,population);
                pstm.setString(7,localName);
                pstm.setString(8,government);
                pstm.setString(9,code2);
                ResultSet rs = pstm.executeQuery();
                kk = true;
                return kk;
            } catch (Exception e){
                e.printStackTrace();
                return kk;
            }
    }

    private List<Store> prepareReturn(ResultSet result) throws SQLException {

        List<Store> stores = new ArrayList<>();

        while (result.next()) {
            stores.add(new Store(result.getString(1),result.getString(2),result.getString(3),result.getDate(4)));
        }

        return stores;
    }
    
}
