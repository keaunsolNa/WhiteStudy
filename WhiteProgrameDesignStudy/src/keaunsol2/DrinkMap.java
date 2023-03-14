package keaunsol2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrinkMap {

	static Map<String, List<String>> drinkMap = new HashMap<>();

	public static void getDrinkMap() {
		
		List<String> espresso = new ArrayList<>();
		espresso.add("Vanilla Flat White");
		espresso.add("Javabucks Dolce Latte");
		espresso.add("Caffe Mocha");
		espresso.add("Caffe Americano");
		espresso.add("Caffe Latte");
		espresso.add("Cappuccino");
		espresso.add("Caramel Macchiato");
		espresso.add("White Chocolate Mocha");
		espresso.add("Caffe Javabucks Double Shot");
		espresso.add("Vanilla Javabucks Double Shot");
		espresso.add("Hazelnut Javabucks Double Shot");
		espresso.add("Espresso");
		espresso.add("Espresso Macchiato");
		espresso.add("Espresso Con Panna");
		espresso.add("Jeju Forest Mugwort Latte");
		
		List<String> blended = new ArrayList<>();
		blended.add("Mint Chocolate Chip Blended");
		blended.add("Strawberry Delight Yogurt Blended");
		blended.add("Mango Banana Blended");
		blended.add("Mango Passion Tea Blended");
		blended.add("Red Power Smash Blended");
		blended.add("The Green Mugwort Blended");
		blended.add("Jeju Tangerine Carrot Snowing Blended");
		
		
		drinkMap.put("Espresso", espresso);
		drinkMap.put("Blended", blended);
	}

}
