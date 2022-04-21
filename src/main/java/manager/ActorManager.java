package manager;


import dao.Actor;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ActorManager {
    public List<Actor> findAllById(Connection con, Set<String> ids);

    public Actor filtrerActorById(Connection con, String word) throws SQLException;

    public void updateActor(Connection con,String name,String newName) throws SQLException;

    public void deleteActor(Connection con,String name) throws SQLException;

    public void insertActor(Connection con,String code,String name,String continent,String region,float surfaceArea,int population,String localName,String government,String code2) throws SQLException;


}
