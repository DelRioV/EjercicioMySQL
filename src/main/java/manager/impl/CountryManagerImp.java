package manager.impl;

import dao.Country;
import manager.CountryManager;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Country DTO Manager.
 * <p>
 * Contains all the queries used to consult and manipulate Countries data.
 *
 * @author jose.m.prieto.villar
 */
public class CountryManagerImp implements CountryManager {

    public List<Country> findAllById(Connection con, Set<String> ids) {
        // Creates the SQL command
        String sql = String.format("SELECT * FROM Country WHERE Code IN (%s)",
                ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));
        // "ESP","FR","DEU","UK","PR"
        // SELECT * FROM Country WHERE Code in ("ESP","FR","DEU","UK","PR"

        // Create a prepared statement
        try (Statement stmt = con.createStatement()) {

            // Executes sql command
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<Country> countries = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a country per result
                countries.add(new Country(result.getString(1),result.getString(2),result.getDate(3)));
            }

            return countries;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Country filtrerCountryByName(Connection con, String word) throws SQLException {
        Country country = null;
        try{
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM COUNTRY WHERE NAME LIKE ?");
            pstm.setString(1,word);
            ResultSet rs = pstm.executeQuery();
            country = new Country(rs.getString(1),rs.getString(2),rs.getDate(3));
            return country;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void updateCountry(Connection con, String name, String newName) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("UPDATE COUNTRY SET NAME=? WHERE NAME=?");
        pstm.setString(1,newName);
        pstm.setString(2,name);
        ResultSet rs = pstm.executeQuery();
    }

    @Override
    public void deleteCountry(Connection con, String name) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("DELETE COUNTRY WHERE NAME=?");
        pstm.setString(1,name);
        ResultSet rs = pstm.executeQuery();
    }

    @Override
    public void insertCountry(Connection con, String code, String name, String continent, String region, float surfaceArea, int population, String localName, String government, String code2) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO COUNTRY VALUES(CODE=?,NAME=?,CONTINENT=?,REGION=?,SURFACEAREA=?,POPULATION=?,LOCALNAME=?,GOVERNMENTFORM=?,CODE2=?)");
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


    /**
     * Prepare the return of a result set
     * @param result the result set to prepate
     * @return a {@link List} of {@link Country}
     * @throws {@link SQLException}
     */
    private List<Country> prepareReturn(ResultSet result) throws SQLException {

        List<Country> countries = new ArrayList<>();

        while (result.next()) {
            countries.add(new Country(result.getString(1),result.getString(2),result.getDate(3)));
        }

        return countries;
    }

}

