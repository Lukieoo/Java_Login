package Content.Sql_code;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public  int chceckd_connection() {//Sprawdzenie połączenia


        Connection connection = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            if (connection != null) {

                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                try {

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();


                }
            }
        }
    return 0;
    }
}