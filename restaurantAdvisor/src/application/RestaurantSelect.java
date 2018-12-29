package application;

import java.awt.Insets;
import java.io.IOException;
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

public class RestaurantSelect extends Application {

Scene scene1, scene2, signUp, actionScreen, cuisine;
static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
static String selection;
static String cuisineSelection;
    
@Override
public void start(Stage primaryStage) {
//potential dropbox to pick restaurant
final Text selected = new Text();
primaryStage.setTitle("Restaurant Advisor");
Label labelfirst= new Label("What type of restaurant would you like to eat at? Definitions are listed below");
Label labelresponse= new Label();
Button submitButton = new Button("Submit");
ChoiceBox<String> dropdown= new ChoiceBox<>();
dropdown.getItems().addAll("Fast Food", "Fast Casual", "Formal", "Family Dining");
dropdown.getSelectionModel().select(0);
ChoiceBox<String> cuisineDrop = new ChoiceBox<>();
Label secondLabel = new Label("Which type of cuisine are you looking for today?");
cuisineDrop.getItems().addAll("Mexican" , "Chinese","American","Italian","Pizza","Sandwich");
submitButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
    	selection = dropdown.getValue();
    	cuisineSelection = cuisineDrop.getValue();
    	 selected.setFill(Color.FIREBRICK);
         selected.setText("You selected " + selection + " and " + cuisineSelection);
         AllRestaurants rest = new AllRestaurants();
         try {
			rest.addRestaurants();
            rest.addReviews();
         }
         catch(IOException e1) {
			e1.printStackTrace();
         }
         ArrayList<Restaurant>list=rest.getRestaurants();
         Cuisine temp = new Cuisine(list,selection,cuisineSelection);
         
         temp.start(primaryStage);
    }
});
VBox layout= new VBox(5);
Text restaurantDescriptions = new Text("Fast Food: Easy take-and-grab food. \n Fast Casual: Healthier food with a slightly-longer wait time. \n Formal: Sit-down and table dining only, upscale places with higher prices \n Family Dining: Restaurants catered towards families!");
layout.getChildren().addAll(labelfirst, dropdown, secondLabel, cuisineDrop, submitButton, labelresponse, selected, restaurantDescriptions);
Scene pickFood= new Scene(layout, 400, 250);
primaryStage.setScene(pickFood);
primaryStage.show();
}


public static void main(String[] args) {
launch(args);
}
    
}

