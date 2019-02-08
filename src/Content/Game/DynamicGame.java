package Content.Game;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

//package sample;
//
//import javafx.animation.FadeTransition;
//import javafx.application.Application;
//import javafx.scene.Parent;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class DynamicGame extends Parent {
//    public DynamicGame(Stage primaryStagea) throws Exception {
//
//        FadeTransition ft = new FadeTransition(Duration.seconds(1.1), this);
//        ft.setFromValue(0);
//        ft.setToValue(1);
//        ft.setOnFinished(evt -> {setVisible(true);});
//        ft.play();
//
//        //Game Game=new Game();
//      //  Game game=new Game(primaryStagea);
//
//        //this.getChildren().add(game);
//
//            //game.start();
//
//
////        Rectangle a = new Rectangle(100, 300);
////        a.setFill(Color.BLUE);
////        a.setY(100);
////        getChildren().addAll(a);
//
//
//
//    }
//}
public class DynamicGame extends Parent {
    public DynamicGame(Stage primaryStagea) throws Exception {
        //Game game=new Game(primaryStagea);
        start(primaryStagea);
    }

    public void start(Stage primaryStage) throws Exception {



        Pane root = new Pane();

        Image image = new Image("Content/img/if_skull2.png");  //Zmiana kursora
        root.setCursor(new ImageCursor(image));


        Rectangle rect = new Rectangle(0, 0, 25, 50);
        rect.setFill(Color.ORANGE);

        Circle circle = new Circle(125, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
     //   Rectangle a=new Rectangle(1920*0.75,1080*0.75);
       // a.setFill( Color.rgb(30,30,30));
     //   root.getChildren().add(a);
       // Image view=new Image("img/if_skull.png");

    //    javafx.scene.image.ImageView vieo=new javafx.scene.image.ImageView(view);

        root.getChildren().add(rect);
     //   root.getChildren().add(vieo);
        root.getChildren().add(circle);



        Toolkit zestaw = Toolkit.getDefaultToolkit();

        Dimension wymiary = zestaw.getScreenSize();
        int wysokosc = wymiary.height;
        int szerokosc = wymiary.width;

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(5000));
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setPath(circle);
        pt.setNode(rect);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setAutoReverse(true);
        pt.play();

        circle.setOnMousePressed(e -> { pt.pause(); });
        circle.setOnMouseReleased(e-> { pt.play(); });

        Scene scene = new Scene(root, szerokosc*0.75, wysokosc*0.75);

        FadeTransition ft = new FadeTransition(Duration.seconds(1.1), root);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setOnFinished(evt -> {setVisible(true);});
        ft.play();

        scene.setFill( Color.rgb(30,30,30));






        primaryStage.setScene(scene);
        primaryStage.show();


    }

//    private void fillcontent(Rectangle rect) {
//        FillTransition ft =
//                new FillTransition(Duration.millis(3000), rect, Color.rgb(30,30,30), Color.WHITE);
//
//
//        ft.setAutoReverse(true);
//        ft.play();
//    }


}