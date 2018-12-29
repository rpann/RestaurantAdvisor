package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AllRestaurants {

	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

	public AllRestaurants() {

	}

	public void addRestaurants() throws IOException {
		File fileName = new File("C:/Users/ctbin/eclipse-workspace/restaurantAdvisor/src/application/restaurantList.txt");
		
		Scanner input = new Scanner(fileName);

		while (input.hasNext()) {
			//System.out.println(input.nextLine());
			restaurants.add(new Restaurant(input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine()));
		}
		input.close();
	}
	
	public void addReviews() throws IOException {
		File fileName = new File("reviewList.txt");
		
		Scanner input = new Scanner(fileName);

		ArrayList<String[]> reviews = new ArrayList<String[]>();
		int count = 0;
		while (input.hasNext()) {
			reviews.add(new String[3]);
			reviews.get(count)[0]=input.nextLine();
			reviews.get(count)[1]=input.nextLine();
			reviews.get(count)[2]=input.nextLine();
			count++;
		}
		for(int i = 0; i < reviews.size();i++) {
			String name = reviews.get(i)[0];
			//System.out.println(reviews.get(i)[1]);
			//System.out.println(reviews.get(i)[2]);
			for(int x = 0; x<restaurants.size();x++) {
				if(name.equalsIgnoreCase(restaurants.get(x).getName())) {
					restaurants.get(x).addReview(Integer.parseInt(reviews.get(i)[1]), reviews.get(i)[2]);
				}
			}
		}
		input.close();
	}


	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}

	public ArrayList<Restaurant> getRestaurants(String dining, String cuisine) {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

		for (int i = 0; i < restaurants.size(); i++) {
			Restaurant temp = restaurants.get(i);
			if (temp.getCuisine().equals(cuisine) && temp.getDining().equals(dining)) {
				restaurants.add(temp);
			}
		}
		if (restaurants.size() > 0) {
			return restaurants;
		}
		return null;
	}
}

