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

public class SignUp extends Application {

Scene scene1, scene2, signUp, actionScreen, cuisine;
static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
static String selection;
static String cuisineSelection;
public UsernamePW only = new UsernamePW();
@Override
public void start(Stage primaryStage) {
//Sign Up
ArrayList<String> username = new ArrayList<String>();
primaryStage.setTitle("JavaFX Welcome");
GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
Text scenetitle = new Text("Welcome to RestaurantAdvisor!");
scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
grid.add(scenetitle, 0, 0, 2, 1);
Label userName = new Label("Set your User Name:");
grid.add(userName, 0, 1);
TextField userTextField = new TextField();
grid.add(userTextField, 1, 1);
Label pw = new Label("Create a password:");
grid.add(pw, 0, 2);
PasswordField pwBox = new PasswordField();
grid.add(pwBox, 1, 2);
Button btn = new Button("Sign Up");
RestaurantSelect selectRest = new RestaurantSelect();
btn.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
    	only.hashmap.put(userTextField.getText(),pwBox.getText());
    	selectRest.start(primaryStage);
    }
});
Button home = new Button("Home");
EnterProfile first = new EnterProfile();
home.setOnAction(e -> first.start(primaryStage));
HBox hbBtn = new HBox(10);
hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
hbBtn.getChildren().add(btn);
grid.add(home, 5, 5);
grid.add(hbBtn, 1, 4);
final Text actiontarget = new Text();
grid.add(actiontarget, 1, 6);
Scene signUp = new Scene(grid, 300, 275);
primaryStage.setScene(signUp);
primaryStage.show();
}


public static void main(String[] args) {
launch(args);
}
    
}

