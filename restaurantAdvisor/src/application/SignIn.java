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

public class SignIn extends Application {

Scene scene1, scene2, signUp, actionScreen, cuisine;
    
@Override
public void start(Stage primaryStage) {
//Sign In
	Label label1= new Label("Welcome back to RestaurantAdvisor!"); // the label for the program
	Button button1= new Button("Log-in"); //the button that could activate the next one
	HomePage actions = new HomePage();
 //when the sign in button is clicked, it goes to the next scene
	VBox layout1 = new VBox(20);    //the layout for the scene 
	layout1.getChildren().add(label1);
	Label userName = new Label("User Name:");
	layout1.getChildren().add(userName);
	TextField userTextField = new TextField();
	layout1.getChildren().add(userTextField);
	Label pw = new Label("Password:");
	PasswordField pwBox = new PasswordField(); //adds the buttons
	scene1= new Scene(layout1, 300, 250); //creates the actual scene
	SignUp trial = new SignUp();
	button1.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
	    	Wrong uwaswrong = new Wrong();
	    	if (trial.only.userExists(userTextField.getText()) == true) {
	    		HomePage home = new HomePage();
	    		home.start(primaryStage);
	    	} else
				try {
					uwaswrong.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    }
	});
	Button home = new Button("Home");
	EnterProfile first = new EnterProfile();
	home.setOnAction(e -> first.start(primaryStage));
	layout1.getChildren().addAll(pw, pwBox, button1, home);
	
	primaryStage.setScene(scene1);
	primaryStage.show();
}


public static void main(String[] args) {
launch(args);
}
    
}