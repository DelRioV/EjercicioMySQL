
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        Connection con;
        try {
            con = new MySQLConnector().getMySQLConnection();
            System.out.println(con.getCatalog());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
