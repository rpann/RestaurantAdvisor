package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage extends Application{

	public void start(Stage primaryStage) {
		
		BorderPane layout = new BorderPane();
		HBox options = new HBox();
		Button find = new Button("Find a Restaurant");
		Button review = new Button("Write a Review");
		RestaurantSelect selectRest = new RestaurantSelect();
		find.setOnAction(e -> selectRest.start(primaryStage));
		review.setOnAction(e -> selectRest.start(primaryStage));
		options.getChildren().addAll(find,review);
		layout.setTop(options);
		Button home = new Button("Home");
		EnterProfile first = new EnterProfile();
		home.setOnAction(e -> first.start(primaryStage));
		layout.getChildren().add(home);
		Scene scene = new Scene(layout, 500, 475);
		primaryStage.setScene(scene);
		
		GridPane center = new GridPane();
		Text welcome = new Text("Welcome to Restaurant Advisor");
		welcome.setFill(Color.BLUE);
		welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		GridPane.setConstraints(welcome, 0,0);
		center.getChildren().addAll(welcome);
		layout.setCenter(welcome);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

