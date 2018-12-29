package application;

import java.util.ArrayList;

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

public class Cuisine extends Application{

	//private static final String Final = null;
	private ArrayList<Restaurant> restaurantList;
	private String dining;
	private String cuisine;
	
	public Cuisine(ArrayList<Restaurant> temp,String d,String c) {
		restaurantList = temp;
		dining=d;
		cuisine=c;
	}
	public ArrayList<Restaurant> getRestaurants(String dining,String cuisine) {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		
		for(int i = 0; i < restaurantList.size();i++) {
			Restaurant temp = restaurantList.get(i);
			if(temp.getCuisine().equals(cuisine)&&temp.getDining().equals(dining)) {
				restaurants.add(temp);
			}
		}
		if(restaurants.size()>0) {
			return restaurants;
		}
		return null;
	}
	public Stage getStage() {
		Stage primaryStage = new Stage();
		
		ArrayList<Restaurant> list = getRestaurants(dining,cuisine);
		
		BorderPane layout = new BorderPane();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle;
		if(list!=null) {
			scenetitle = new Text(cuisine+" "+dining+" Restaurants");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			GridPane.setConstraints(scenetitle, 0, 0);
			
			for(int i = 1; i<=list.size();i++) {
				String name = list.get(i-1).getName();
				Button temp = new Button(name);
				final int temp1 = i;
				temp.setOnAction(e -> list.get(temp1-1).start(primaryStage));
				GridPane.setConstraints(temp, 0, i);
				grid.getChildren().addAll(temp);
			}
		}
		else {
			scenetitle = new Text("No search results");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			GridPane.setConstraints(scenetitle, 0, 0);
		}
		grid.getChildren().addAll(scenetitle);
		
		HBox left = new HBox();
		Button home = new Button("HOME");
		Button write = new Button("Write a Review");
	    left.getChildren().addAll(home,write);
		
	    HomePage home1 = new HomePage();
	    home.setOnAction(e -> home1.start(primaryStage));
	    
	    Reviews review = new Reviews();
	    write.setOnAction(e -> review.start(primaryStage));
	    layout.setCenter(grid);
	    layout.setTop(left);
		Scene scene = new Scene(layout, 500, 475);
		primaryStage.setScene(scene);
		return primaryStage;
	}
	public void start(Stage primaryStage) {
		primaryStage = getStage();
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

