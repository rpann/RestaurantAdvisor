package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Wrong extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox organized = new VBox();
		Text sorry = new Text("We're so sorry, we couldn't find any a profile with that username and password.Please double-check, passwords and usernames are case-sensitive");
		Button tryAgain = new Button("Try Again");
		SignIn second = new SignIn();
		tryAgain.setOnAction(e -> second.start(primaryStage));
		Button home = new Button("Go home");
		HomePage first = new HomePage();
		home.setOnAction(e -> first.start(primaryStage));
		Text signUp = new Text("Don't have an account? Sign up!");
		Button sign = new Button("Sign-Up");
		SignUp up = new SignUp();
		sign.setOnAction(e -> up.start(primaryStage));
		organized.getChildren().addAll(sorry, tryAgain, home, signUp, sign);
		GridPane grid = new GridPane();
		grid.getChildren().add(organized);
		Scene wrong = new Scene(grid, 300, 300);
		primaryStage.setScene(wrong);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
		}

}
