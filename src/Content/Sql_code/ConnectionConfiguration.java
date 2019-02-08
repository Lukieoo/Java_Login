package Content.Sql_code;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {


    public static Connection getConnection() {  ///Pobiera połączenie
        Connection connection = null;   ///Ustawienie wstępne obiektu na warość 0


        try {
            Class.forName("com.mysql.jdbc.Driver");//Wycztanie z klasy com.

//              connection = DriverManager.getConnection("jdbc:mysql://bro.nazwa.pl:3306/bro_bro", "bro_bro", "Barcelona99!");//Próba połączenia
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");//Próba połączenia

        } catch (Exception e) {
            e.printStackTrace();//Wycztanie trasy błędów
        }

        return connection;//zwrócenie połączenia
    }

}