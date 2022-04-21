
import manager.impl.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        Connection con;
        try {
            con = new MySQLConnector().getMySQLConnection();
            ActorManagerImp acmi = new ActorManagerImp();
            CountryManagerImp cmi = new CountryManagerImp();
            FilmCategoryManagerImp fcmi = new FilmCategoryManagerImp();
            InventorManagerImp itmi = new InventorManagerImp();
            StoreManagerImp stmi =new StoreManagerImp();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

}
