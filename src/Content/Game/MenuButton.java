package Content.Game;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public   class MenuButton extends StackPane {
    private Text text;

    //Konstruktor z wartoscia podana
    public MenuButton(String name) {
        //wstawienie tekstu
        text = new Text(name);
        text.setFont(text.getFont().font(20));
        text.setFill(Color.WHITE);

        //Prostokat na przyciski
        Rectangle rectbg = new Rectangle(250, 30);
        rectbg.setOpacity(0.6);
        rectbg.setFill(Color.BLACK);
        rectbg.setEffect(new GaussianBlur(3.5));

        //    setAlignment(Pos.CENTER_LEFT);
        setRotate(-0.5);
        getChildren().addAll(rectbg, text);

        //Kiedy  ma kontaktu obiekt z myszka
        setOnMouseEntered(event -> {
            rectbg.setTranslateX(10);
            text.setTranslateX(10);
            rectbg.setFill(Color.WHITE);
            text.setFill(Color.BLACK);
        });

        //Kiedy nie ma kontaktu obiekt z myszka
        setOnMouseExited(event -> {
            rectbg.setTranslateX(0);
            text.setTranslateX(0);
            rectbg.setFill(Color.BLACK);
            text.setFill(Color.WHITE);
        });

        //Dodanie efektów cienia po naciśnieciu
        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());

        setOnMousePressed(event -> setEffect(drop));
        setOnMouseReleased(event -> setEffect(null));
    }

}