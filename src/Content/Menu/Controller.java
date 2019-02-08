package Content.Menu;

import Content.Sql_code.*;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{

///ZMIENNE obiektowe przycisków itd
    public Button button;
    public AnchorPane rootPane;
    public Button Login;
    public Button sigin;
    boolean a=true;

    public ImageView checkconnection;
    Image image = new Image("Content/img/connnectwrong.png");
    public Label Author;

    @Override
    public void initialize(URL location, ResourceBundle resources) {//Na samym początku inicjalizacja okna

        ///Ustawienie tekstu początkowego
        Author.setFont(new Font("AB Barberian",15));
        Author.setText("Coomunity create for:\n .Adrian.\n .Pawel.\n.Magda.");
        Author.setAlignment(Pos.CENTER);
        Author.setTextAlignment(TextAlignment.CENTER);

        chechconnect();


    }
    private void Transformfade() {
        ///Animacja zanikania
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        fadeTransition.play();


    }

    private void loadNext()throws Exception {
        ///Wyczytanie nowego panelu
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Panel.fxml"));
        pane.setOpacity(0.85);
        Author.setVisible(false);
        rootPane.getChildren().setAll(pane);
    }

    private void loadAnchor()throws Exception {
        ///Wyczytanie nowego panelu
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Login_panel.fxml"));
        pane.setOpacity(0.85);
        Author.setVisible(false);
        rootPane.getChildren().setAll(pane);
    }
    private void MakeFoudOut(boolean k) {
        ///Animacja pojawienia
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event)->{
            try {
                if(k==true){

                    loadNext();

                }
                else {

                    loadAnchor();
                }

                Transformfade();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        fadeTransition.play();
    }

    public void load(ActionEvent event)throws IOException{

        a=true;
        MakeFoudOut(a);

    }
    public void loadlogin(ActionEvent event)throws IOException{

        a=false;
        MakeFoudOut(a);

    }



    public void close(ActionEvent event) {///ZAMYKANIE OKNA
        System.exit(0);
    }
    private void chechconnect(){///SPRAWDZENIE POlonczenia z baza
        if(new App().chceckd_connection()==1)
        {
            ///USTAWIENIE OBRAZKA połaczenia kiedy jest dobre
            image = new Image("Content/img/connectgood.png");
            checkconnection.setImage(image);
        }
        else
        {
            ///USTAWIENIE OBRAZKA połaczenia kiedy go nie ma
            image = new Image("Content/img/connnectwrong.png");
            checkconnection.setImage(image);
        }

    }


}
