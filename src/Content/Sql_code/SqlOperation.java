package Content.Sql_code;

import java.sql.*;


public class SqlOperation implements SqlMethod {

    @Override
    public void create_Databases() {//Twocrzenie bazy danych

        Connection connection = null;//Połączenie ustanowione na null
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS USERS"+"(id int primary key unique auto_increment," +
                    " Username varchar(20), Password varchar(20),E_Mail varchar(30))");//Utworzenie tablei w bazie users polecienia MYSQL



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int insert_Users(String Usersname, String password, String Email) throws SQLException {//pól użytkowników ,hasla itd

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement  statement = null;
        ResultSet resultSet = null;



            try {

                connection = ConnectionConfiguration.getConnection();

                statement=connection.createStatement();
                resultSet = statement.executeQuery("SELECT USERNAME FROM  USERS WHERE USERNAME LIKE '"+Usersname+"'");//WYSZUKANIE użytkownika w bazie (i poźniejsze zapisanie przed stworzeniem podobnego)


                while (resultSet.next()) {

                     if(resultSet.getString("USERNAME").equals(Usersname))//zabezpieczenie przed dodaniem tego samoego usera
                     {
                                ///Zamykanie zasobów

                             if (preparedStatement != null) {
                             try {
                                 preparedStatement.close();
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                         }
                         if (resultSet != null) {
                             try {
                                 resultSet.close();
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                         }

                         if (connection != null) {
                             try {

                                 connection.close();
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                         }
                         if (statement != null) {
                             try {
                                 statement.close();
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                         }

                         return 1;

                     }

                }

                    preparedStatement = connection.prepareStatement("INSERT INTO USERS" + " (Username,Password,E_Mail)" +
                            "VALUES (?, ?, ?)");//dodanie do Tabeli danych

                    preparedStatement.setString(1, Usersname);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, Email);


                    preparedStatement.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    try {

                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return 0;
        }

    @Override
    public int login_base(String Usersname, String password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement  statement = null;
        ResultSet resultSet = null;



        try {

            connection = ConnectionConfiguration.getConnection();

            statement=connection.createStatement();
            resultSet = statement.executeQuery("SELECT USERNAME,PASSWORD FROM  USERS WHERE USERNAME LIKE '"+Usersname+"'");//WYSZUKANIE użytkownika w bazie (i poźniejsze zapisanie przed stworzeniem podobnego)


            while (resultSet.next()) {

                if(resultSet.getString("USERNAME").equals(Usersname)&&resultSet.getString("PASSWORD").equals(password))//zabezpieczenie przed dodaniem tego samoego usera
                {
                    System.out.println(Usersname);

                    return 1;

                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

void closeresourc(){

}
}
