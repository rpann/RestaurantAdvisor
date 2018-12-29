package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Reviews extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 500, 475);
		primaryStage.setScene(scene);
		
		Text scenetitle = new Text("Write a review");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label restaurant = new Label("Restaurant:");
		grid.add(restaurant, 0, 1);

		TextField restaurantInput = new TextField();
		grid.add(restaurantInput, 1, 1);

		Label rate = new Label("Rating(out of 5):");
		grid.add(rate, 0, 2);

		TextField ratingInput = new TextField();
		grid.add(ratingInput, 1, 2);

		Label comment = new Label("Comments:");
		grid.add(comment, 0, 3);

		TextField commentInput = new TextField();
		grid.add(commentInput, 1, 3);
		
		Button btn = new Button("Submit");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


