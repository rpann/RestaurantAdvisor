package application;

import java.awt.Insets;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EnterProfile extends Application {

Scene scene1, scene2, signUp, actionScreen, cuisine;
static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
static String selection;
static String cuisineSelection;
    
@Override
public void start(Stage primaryStage) {
	VBox order = new VBox();
	GridPane center = new GridPane();

	Button login = new Button("Log-in");
	SignIn signIn = new SignIn();
	login.setOnAction(e -> signIn.start(primaryStage));
	Text noAcc = new Text("No account? Create one!!");
	Button signUp = new Button("Sign-Up");
	SignUp signUp1 = new SignUp();
	Text welcome = new Text("Welcome to Restaurant Advisor");
	welcome.setFill(Color.DARKCYAN);
	welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
	signUp.setOnAction(e -> signUp1.start(primaryStage));
	order.getChildren().addAll(welcome,login, noAcc, signUp);
	center.getChildren().add(order);
	Scene account = new Scene(center, 500, 475);
	primaryStage.setScene(account);
	primaryStage.show();
}


public static void main(String[] args) {
launch(args);
}
    
}

