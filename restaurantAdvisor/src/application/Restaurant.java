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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Restaurant extends Application{

	private static int idNum = 11111;
	private String name;
	private String address1;
	private String address2;
	private String phone;
	private String email;
	private String hours1;
	private String hours2;
	private String hours3;
	private String hours4;
	private String hours5;
	private String hours6;
	private String hours7;
	private String cuisine;
	private String dining;
	private String priceRange;
	//add menu items and prices
	private double averagerating;
	private ArrayList<String> reviews;
	private ArrayList<Integer> ratings;
	private ArrayList<String> menu;
	public Menu restaurantMenu;
	public int averageratingcount;
	
	public Restaurant(String n,String a1,String a2,String phoneNum,String e,String h1,String h2,String h3,String h4,String h5,String h6,String h7,String c,String d,String price, String menuItem, String menuItem1, String menuItem2, String menuItem3, String menuItem4) {
		name=n;
		address1=a1;
		address2=a2;
		phone=phoneNum;
		email=e;
		hours1=h1;
		hours2=h2;
		hours3=h3;
		hours4=h4;
		hours5=h5;
		hours6=h6;
		hours7=h7;
		cuisine=c;
		dining=d;
		priceRange=price;
		averagerating=-1;
		reviews = new ArrayList<String>();
		ratings = new ArrayList<Integer>();
		idNum++;
		menu = new ArrayList<String>();
		menu.add(menuItem);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		menu.add(menuItem4);
		restaurantMenu = new Menu(this.name, menu);
		
	}
	
	public Stage getStage() {
		Stage primaryStage = new Stage();
		
		BorderPane layout = new BorderPane();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle = new Text(name);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		GridPane.setConstraints(scenetitle, 0, 0);
		
		Text apetext = new Text("Address: \n"+address1+"\n"+address2+"\n \n"+"Phone: "+phone+"\n \n"+"Email: "+email);
		GridPane.setConstraints(apetext, 0, 2);
		
		Text hourstext = new Text("Hours: \n"+hours1+"\n"+hours2+"\n"+hours3+"\n"+hours4+"\n"+hours5+"\n"+hours6+"\n"+hours7);
		GridPane.setConstraints(hourstext, 1, 2);
		
		Text cuisinetext = new Text(cuisine+"/"+dining);
		GridPane.setConstraints(cuisinetext, 0, 1);
		
		Text priceRangetext = new Text("Price range: "+priceRange);
		GridPane.setConstraints(priceRangetext, 0, 3);
		
		Text ratingtext;
		if(averagerating==-1) {
			ratingtext = new Text("No ratings yet");
		}
		else {
			ratingtext = new Text("Average rating: "+averagerating/averageratingcount);
		}
		GridPane.setConstraints(ratingtext, 0, 4);
		
		Button order = new Button("Order Now");
		Menu menu1 = new Menu(this.name, menu);
		order.setOnAction(e -> menu1.start(primaryStage));
		GridPane.setConstraints(order, 1, 3);
		
		
		grid.getChildren().addAll(scenetitle, apetext, hourstext, cuisinetext, priceRangetext, ratingtext,order);
		
		//Text reviews = new Text("Reviews: ");
		//GridPane.setConstraints(ratingtext, 0, 5);
		//grid.getChildren().addAll(reviews);
		
		VBox bottom = new VBox();
		Text reviewsTitle = new Text("Reviews:");
		reviewsTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
	    bottom.getChildren().addAll(reviewsTitle);
		
	    for(int i = 0; i<reviews.size();i++) {
			Text review = new Text("Rating: "+ratings.get(i)+"/5 \nComments: "+reviews.get(i));
		    bottom.getChildren().addAll(review);
	    }
	    
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
	    layout.setBottom(bottom);
		Scene scene = new Scene(layout, 500, 475);
		primaryStage.setScene(scene);
		return primaryStage;
	}
	public void addReview(int r,String c) {
		if(averagerating==-1) {
			averagerating=0;
		}
		averagerating=averagerating+r;
		reviews.add(c);
		ratings.add(r);
		averageratingcount++;
	}
	public String getDining() {
		return dining;
	}
	public String getCuisine() {
		return cuisine;
	}
	public Menu getMenu() {
		return restaurantMenu;
	}
	public String getName() {
		return name;
	}
	public void start(Stage primaryStage) {
		primaryStage = getStage();
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
