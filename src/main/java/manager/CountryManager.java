package manager;

import dao.Country;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Countries data.
 *
 * @author jose.m.prieto.villar
 *
 */
public interface CountryManager {

    /**
     * Finds all the countries in the DB based on a list of ids.
     *
     * @param con DB connection
     * @param ids Countries id set to search for.
     * @return a {@link List} of {@link Country}
     */
    public List<Country> findAllById(Connection con, Set<String> ids);


    /**
     *
     * Find an specific Country by Name
     *
     * @param con
     * @param word
     * @return the Country
     */
    public Country filtrerCountryByName(Connection con, String word) throws SQLException;


    /**
     * Update Country searched by Name
     *
     * @param con
     * @param name
     * @param newName
     */
    public void updateCountry(Connection con,String name,String newName) throws SQLException;

    /**
     * Delete Country by Name
     *
     * @param con
     * @param name
     */
    public void deleteCountry(Connection con,String name) throws SQLException;

    /**
     * Insert new country
     *
     * @param con
     * @param code
     * @param name
     * @param continent
     * @param region
     * @param surfaceArea
     * @param population
     * @param localName
     * @param government
     * @param code2
     */

    public void insertCountry(Connection con,String code,String name,String continent,String region,float surfaceArea,int population,String localName,String government,String code2) throws SQLException;


}

