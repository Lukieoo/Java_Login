package Content.Not_use;

import Content.Sql_code.*;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller2 implements Initializable{


    public Button sigin;
    public GridPane rootpanel;



    Image image = new Image("Content/img/connnectwrong.png");
    public ImageView check;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(new App().chceckd_connection()==1)
        {
            image = new Image("Content/img/connectgood.png");
            check.setImage(image);
        }
        else
        {
            image = new Image("Content/img/connnectwrong.png");
            check.setImage(image);
        }
    }

    public void load(ActionEvent event) throws Exception {
        //    button.setStyle("-fx-background-color:#4d4d4d");


        MakeFoudOut();
        //loadNext();

    }

    private void loadNextSCene()throws Exception {

        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(200));
        fadeTransition.setNode(rootpanel);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
//        fadeTransition.setOnFinished((ActionEvent event)->{
//            try {
//                loadNext();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        fadeTransition.play();


    }

    private void loadNext()throws Exception {
        AnchorPane pane=  FXMLLoader.load(getClass().getResource(".fxml"));

        rootpanel.getChildren().setAll(pane);
    }
    private void MakeFoudOut() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(200));
        fadeTransition.setNode(rootpanel);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event)->{
            try {
                loadNext();
                loadNextSCene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        fadeTransition.play();
    }


}