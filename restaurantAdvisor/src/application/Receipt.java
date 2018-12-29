package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Receipt extends Application{
	public ArrayList<String> ordered = new ArrayList<String>();
	public void start(Stage primaryStage) {
		VBox first = new VBox();
		for (int i = 0; i < ordered.size(); i++) {
			Text orders = new Text("You ordered " + ordered.get(i));
			first.getChildren().add(orders);
		}
		Scene scene = new Scene(first, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void addOrder(String order) {
		ordered.add(order);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
