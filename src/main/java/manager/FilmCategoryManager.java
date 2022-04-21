package manager;

import dao.FilmCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface FilmCategoryManager {
    public List<FilmCategory> findAllById(Connection con, Set<String> ids);

    public FilmCategory filtrerFilmCategoryById(Connection con, String word) throws SQLException;

    public void updateFilmCategory(Connection con,String name,String newName) throws SQLException;

    public void deleteFilmCategory(Connection con,String name) throws SQLException;

    public void insertFilmCategory(Connection con,String code,String name,String continent,String region,float surfaceArea,int population,String localName,String government,String code2) throws SQLException;

}
