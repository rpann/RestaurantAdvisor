package application;

import java.util.ArrayList;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import javafx.stage.Stage; 
public class Menu extends Application { 
	Receipt receipt = new Receipt();
	ArrayList<String> menu = new ArrayList<String>();
	public Menu(String name, ArrayList<String> foodItems) {
		menu = foodItems;
	}

	// launch the application 
	public void start(Stage primaryStage) 
	{ 
		// set title for the stage 
		primaryStage.setTitle("creating CheckBox"); 

		// create a tile pane 
		VBox r = new VBox(); 
		

		// create a label 
		Label l = new Label("Select your food"); 

		// string array 
		String[] st = {"Water", menu.get(0), menu.get(1), menu.get(2), menu.get(3), menu.get(4)}; 

		// add label 
		r.getChildren().add(l); 
		
		for (int i = 0; i < st.length; i++) { 

			// create a checkbox 
			CheckBox c = new CheckBox(st[i]); 

			// add checkbox 
			r.getChildren().add(c); 


			// create a string 
			String s1 = st[i]; 
			int price = 0;
			String food = st[i];
			// create a event handler 
			EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
				public void handle(ActionEvent e) 
				{ 
					ArrayList<String> ordered = new ArrayList<String>();
					if (c.isSelected()) 
						receipt.addOrder(food);
					
					
				} 

			}; 
			
			// set event to check box 
			c.setOnAction(event); 
			

		} 
		Button finished = new Button("Finished Ordering");
		finished.setOnAction(e -> receipt.start(primaryStage));
		r.getChildren().add(finished);

		// create a scene 
		Scene sc = new Scene(r, 150, 200); 

		// set the scene 
		primaryStage.setScene(sc); 

		primaryStage.show(); 
	} 

	public static void main(String args[]) 
	{ 
		// launch the application 
		launch(args); 
	} 
} 

