package Content.Game;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;


public class Menugame extends Application {


    Pane root=new Pane();

    Toolkit zestaw = Toolkit.getDefaultToolkit();

    Dimension wymiary = zestaw.getScreenSize();
    int wysokosc = wymiary.height;
    int szerokosc = wymiary.width;
    private GameMenu gameMenu;
    Stage primaryStagea;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStagea=primaryStage;

    CursorChanger();//Zmiana kursora
    AddingWindows(primaryStage); //Utworzene okna
    AddingIcon(primaryStage);//Dodanie ikony
    CreateMenu();  //Dodanie elementów do sceny


    }

    private void CreateMenu() {
        gameMenu = new GameMenu(primaryStagea);
        gameMenu.setVisible(true);
        root.getChildren().add( gameMenu);
    }

    private void CursorChanger() {
        Image image = new Image("Content/img/if_skull2.png");  //pass in the image path
        root.setCursor(new ImageCursor(image));
    }

    private void AddingWindows(Stage primaryStage) {

        primaryStage.setTitle("Vernalization");
        root.setPrefSize(szerokosc*0.75, wysokosc*0.75);
        Scene scene = new Scene(root );
        scene.setFill( Color.rgb(30,30,30));

        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);

        primaryStage.show();

        javafx.scene.shape.Rectangle bgcolor = new Rectangle(0,0,szerokosc*0.75,wysokosc*0.75);//Tlo okna
        bgcolor.setFill(Color.rgb(30,30,30));
        root.getChildren().add(bgcolor);
    }

    public void AddingIcon(Stage primaryStage) {
        Image icon = new Image("Content/img/Vernalization_logo_v6.png");
        primaryStage.getIcons().add(icon);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
