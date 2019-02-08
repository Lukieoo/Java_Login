package Content.Menu;

import Content.Sql_code.*;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

import java.awt.*;
import java.sql.SQLException;

public class Register  {

    public TextField email;
    public TextField username;
    public TextField repaeatpassword;
    public PasswordField password;
    public RadioButton Select;
    public Label error;


    private String user;
    private String pass;
    private String e_mail;
    private String rep_passw;


    public void Create_acount(ActionEvent event)   {

        SqlOperation sqlOperation=new SqlOperation();//Utworzenie obiektu klasy
        sqlOperation.create_Databases();//Wywołanie metody zobiektu

        //UStawienie zmiennych do sprawdzenia poprawności danych
        user=username.getText();
        pass=password.getText();
        e_mail=email.getText();
        rep_passw=repaeatpassword.getText();


        //konfiguracja tekstu
        error.setFont(new Font(14));
        error.setAlignment(Pos.TOP_CENTER);

        //Zdarzenia z polami
        if (user.equals("")||pass.equals("")||e_mail.equals("")||!pass.equals(rep_passw)||!Select.isSelected())
        {
            if (user.equals("")) username.setStyle("-fx-background-color: brown;");
            if (pass.equals("")) password.setStyle("-fx-background-color: brown;");
            if (!pass.equals(rep_passw))
            {
                password.setStyle("-fx-background-color: brown;");
                repaeatpassword.setStyle("-fx-background-color: brown;");
            }
            if (rep_passw.equals("")) repaeatpassword.setStyle("-fx-background-color: brown;");
            if (e_mail.equals("")) email.setStyle("-fx-background-color: brown;");
            if (!Select.isSelected()) Select.setStyle("-fx-background-color: brown;");

        }
        else
        {
            try {



                if (sqlOperation.insert_Users( user ,pass,e_mail)==1)
                {
                    error.setText(" NOT CREATE, USER EXIST ! ");
                    username.setStyle("-fx-background-color: brown;");
                }
                else
                {
                    error.setText(" USER CREATE ,NOW SIGN IN ");
                    error.setTextFill(Color.GREEN);
                    setDefault();


                }

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }




    }

    private void setDefault() {


        username.setText("");
        password.setText("");
        email.setText("");
        repaeatpassword.setText("");

        username.setStyle("-fx-background-color:  white;");
        password.setStyle("-fx-background-color:  white;");
        email.setStyle("-fx-background-color:  white;");
        repaeatpassword.setStyle("-fx-background-color:  white;");
        Select.setStyle("-fx-background-color:  none;");

        Select.setSelected(false);
    }
}
