package Content.Sql_code;

import java.sql.SQLException;
import java.util.List;

public interface SqlMethod {//Utworznie metod do implementowania

    void create_Databases();//tworzenia bazy

    int insert_Users(String Usersname,String password,String Email) throws SQLException;//dodanie użytkowników

    int login_base(String Usersname,String password);



}
