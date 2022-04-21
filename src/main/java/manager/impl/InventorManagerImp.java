package manager.impl;

import dao.Inventor;
import dao.Inventor;
import manager.InventorManager;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InventorManagerImp implements InventorManager {
    public List<Inventor> findAllById(Connection con, Set<String> ids) {
        // Creates the SQL command
        String sql = String.format("SELECT * FROM Inventor WHERE Code IN (%s)",
                ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));
        // "ESP","FR","DEU","UK","PR"
        // SELECT * FROM Inventor WHERE Code in ("ESP","FR","DEU","UK","PR"

        // Create a prepared statement
        try (Statement stmt = con.createStatement()) {

            // Executes sql command
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<Inventor> Inventors = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a Inventor per result
                Inventors.add(new Inventor(result.getString(1),result.getString(2),result.getString(3),result.getDate(4)));
            }

            return Inventors;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Inventor filtrerInventorById(Connection con, String word) throws SQLException {

        Inventor Inventor = null;
        try{
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM COUNTRY WHERE NAME LIKE ?");
            pstm.setString(1,word);
            ResultSet rs = pstm.executeQuery();
            Inventor = new Inventor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4));
            return Inventor;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void updateInventor(Connection con, String name, String newName) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("UPDATE Inventor SET NAME=? WHERE NAME=?");
        pstm.setString(1,newName);
        pstm.setString(2,name);
        ResultSet rs = pstm.executeQuery();
    }

    @Override
    public void deleteInventor(Connection con, String name) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("DELETE Inventor WHERE NAME=?");
        pstm.setString(1,name);
        ResultSet rs = pstm.executeQuery();
    }

    @Override
    public void insertInventor(Connection con, String code, String name, String continent, String region, float surfaceArea, int population, String localName, String government, String code2) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO Inventor VALUES(CODE=?,NAME=?,CONTINENT=?,REGION=?,SURFACEAREA=?,POPULATION=?,LOCALNAME=?,GOVERNMENTFORM=?,CODE2=?)");
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
    }

    private List<Inventor> prepareReturn(ResultSet result) throws SQLException {

        List<Inventor> Inventors = new ArrayList<>();

        while (result.next()) {
            Inventors.add(new Inventor(result.getString(1),result.getString(2),result.getString(3),result.getDate(4)));
        }

        return Inventors;
    }

}
