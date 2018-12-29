package application;

import java.io.FileInputStream;

import javafx.application.Application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Categories extends Application {
	public void start(Stage primaryStage) throws Exception{
		Text scenetitle = new Text("Popular Restaurant Types");
		scenetitle.setFill(Color.MAGENTA);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    HBox topMenu = new HBox();
	    Button fastCas = new Button("Fast Casual");
	    fastCas.setPrefSize(120,30);

	    topMenu.getChildren().addAll(fastCas);

	    HBox left = new HBox();
	    Button fastFood = new Button("Fast Food");
	    fastFood.setPrefSize(120, 30);
	    Button casDin = new Button("Casual Dining");
	    casDin.setPrefSize(120,30);
	    
	    Button home = new Button("HOME");
	    left.getChildren().addAll(home);
	    

       // FileInputStream input = new FileInputStream("resources/images/iconmonstr-home-6-48.png");
       // Image image = new Image(input);
        //ImageView imageView = new ImageView(image);

       // Button button = new Button("Home", imageView);

	    VBox right = new VBox();
	    Button fam = new Button("Family Style ");
	    fam.setPrefSize(120, 30);
	    Button fineDin = new Button("Fine Dining");
	    topMenu.getChildren().addAll(fam, fineDin);
	    topMenu.getChildren().addAll(fastFood, casDin);

	    fineDin.setPrefSize(120, 30);

	    BorderPane borderPane = new BorderPane();
	    borderPane.setBottom(left);
	   borderPane.setLeft(topMenu);



	    Scene scene = new Scene(borderPane, 300,300);

	    primaryStage.setScene(scene);
	    borderPane.setTop(scenetitle);
	    primaryStage.show();
	}




	public static void main(String[] args) {
	    launch(args);
	}
}
