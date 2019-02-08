package Content.Game;

import Content.Menu.Main;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

class GameMenu extends Parent {

    public GameMenu(Stage primaryStagea) {

        //Dodanie obiektów VBOX układaja się pod soba (--z odległosciami obiektów (spacing)

        ImageView logo = new ImageView();


        VBox menu0 = new VBox(1);
        VBox menu1 = new VBox(1);

        //Pobranie szerokości i wysokosci ekranu

            Toolkit zestaw = Toolkit.getDefaultToolkit();
            Dimension wymiary = zestaw.getScreenSize();
            int wysokosc = wymiary.height;
            int szerokosc = wymiary.width;



        Image image = new Image("Content/img/Vernalization.png");

        logo.setImage(image);
        logo.setFitHeight(250);
        logo.setFitWidth(650);
        logo.setX(((szerokosc*0.75)/2)-325);


        //Położenienie menu1
        menu0.setTranslateX(((szerokosc*0.75)/2)-125);
        menu0.setTranslateY(((wysokosc*0.75)/2));

        //Położenienie menu2
        menu1.setTranslateX(((szerokosc*0.75)/2)-125);
        menu1.setTranslateY(((wysokosc*0.75)/2));


        final int offset = (int) (szerokosc*0.75);

        menu1.setTranslateX(offset);

        Rectangle bg = new Rectangle(szerokosc, 300);
        bg.setY((((wysokosc*0.75)/2))-100);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);



        //Po nacisnieciu przycisku wznów
        MenuButton btnResume = new MenuButton("RESUME");//z klasy Menu wywołuje konstuktor klasy MenuButon z nazwa obiektu
        btnResume.setOnMouseClicked(event -> {

            //efekt zanikania
            FadeTransition ft = new FadeTransition(Duration.seconds(1.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);


            ft.setOnFinished(evt -> {setVisible(false);
                try {
                    create(menu0,logo,bg,primaryStagea);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
          //  ft.setOnFinished(evt -> {getChildren().remove(menu0);});
            ft.play();


        });


        //Po nacisnieciu przycisku opcje
        MenuButton btnOptions = new MenuButton("OPTIONS");
        btnOptions.setOnMouseClicked(event -> {
            //Dodanie 2 menu
            getChildren().add(menu1);

            //Przesuniecie 1 menu
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            //Przesuniecie 2 menu
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            //Odtworzenie animacji
            tt.play();
            tt1.play();

            //usuniecie 1 menu z pamięci
            tt.setOnFinished(evt -> {
                getChildren().remove(menu0);
            });
        });

        //Wyjście przysciskiem exit
        MenuButton btnExit = new MenuButton("EXIT");
        btnExit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        //Zaminaa menu analogiczna jak w opcje
        MenuButton btnBack = new MenuButton("BACK");
        btnBack.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu1);
            });
        });

        MenuButton logout = new MenuButton("LOGOUT");
        logout.setOnMouseClicked(event -> {
            Stage astage=new Stage();
            Main elo=new Main();

            Stage stage = (Stage)  logout.getScene().getWindow();
            stage.close();

            try {
                elo.start(astage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        MenuButton btnVideo = new MenuButton("VIDEO");

        ///Dodanie obiektów do wyświetlenia
        menu0.getChildren().addAll(btnResume, btnOptions,logout, btnExit);
        menu1.getChildren().addAll(btnBack, btnVideo);
        //  menu1.getChildren().addAll(btnBack);


        //Utworzenie tła dla przycisków
//        Rectangle bg = new Rectangle(szerokosc, 300);
//        bg.setY((((wysokosc*0.75)/2))-100);
//        bg.setFill(Color.GREY);
//        bg.setOpacity(0.4);




        //Dodanie obiektów początkowych
        getChildren().addAll(bg, menu0,logo);
    }

    private void create(VBox menu0, ImageView logo, Rectangle bg, Stage primaryStagea) throws Exception {

        DynamicGame dynamicGame=new DynamicGame(primaryStagea);
        dynamicGame.setVisible(true);
        this.getChildren().add( dynamicGame);

        FadeTransition ft = new FadeTransition(Duration.seconds(0.1), this);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setOnFinished(evt -> {setVisible(true);getChildren().removeAll(menu0,logo,bg);});
        ft.play();

    }


}