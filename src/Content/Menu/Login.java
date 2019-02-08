package Content.Menu;

import Content.Game.*;
import Content.Sql_code.SqlOperation;
import Content.Sql_code.contener;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.omg.PortableServer.POA;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    public TextField username;
    public PasswordField password;
    public CheckBox clickmeber;
    public Label error;
    public Button Login;

    public void comeon(ActionEvent event) throws Exception {
        //Przycisk zalohowania

        if (new SqlOperation().login_base(username.getText(), password.getText()) == 1) {
            error.setText("METoDA ");

            Menugame menu = new Menugame();
            Stage primary = new Stage();
//            Pane root = new Pane();
            menu.start(primary);

            Stage stage = (Stage) Login.getScene().getWindow();
            stage.close();

            //Civ6MenuApp plik=new Civ6MenuApp();


        } else {
            error.setText("Login or Password is incorect ! ");
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        error.setAlignment(Pos.TOP_CENTER);
        error.setTextFill(Color.WHITE);
        ;
    }
}
