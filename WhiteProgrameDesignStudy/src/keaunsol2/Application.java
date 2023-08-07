package keaunsol2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Application {

	private static Class<?> dynamicClass;
	private static Object dynamicObject;
	private static Method dynamicMethod;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("★★★ Javabucks ★★★");
			
			System.out.println("메뉴를 선택 해 주세요.");
			System.out.println("1. 음료");
			System.out.println("2. 디저트");
			System.out.println("3. 장바구니 확인");
			System.out.println("4. 종료");
			int choiseMenu = Integer.parseInt(br.readLine());
			
			switch(choiseMenu) {
			
				case 1 : choiseDrink(); break;
				case 2 : choiseDessert(); break;
				case 3 : checkBasket(); break;
				case 4 : break;
				
				default : break;
				
			}
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void makeClass(String choiseDrink) throws Exception {
		
		dynamicClass = Class.forName("keaunsol2." + choiseDrink);
		dynamicObject = dynamicClass.newInstance();

		Menu.drinkSize.clear();
		dynamicMethod = dynamicClass.getMethod("getSize");
		dynamicMethod.invoke(dynamicObject);

	}
	
	public static void choiseDrink() throws Exception {

		DrinkMap.getDrinkMap();
		
		System.out.println("음료 종류를 선택 해 주세요.");
		int idx = 1;
		for (String key : DrinkMap.drinkMap.keySet()) {
			
			System.out.println(idx +" : " +  key );
			idx++;
		}

		String choiseVariable = br.readLine();
		
		switch(choiseVariable) {
		
			case "Espresso" :
	
				for(int i = 1; i <= DrinkMap.drinkMap.get("Espresso").size(); i++) 
					System.out.println(i + " : " + DrinkMap.drinkMap.get("Espresso").get(i - 1));
				
				break;
			
			case "Blended" :
				
				for(int i = 1; i <= DrinkMap.drinkMap.get("Blended").size(); i++) 
					System.out.println(i + " : " + DrinkMap.drinkMap.get("Blended").get(i - 1));
				
				break;
				
			default : 
				System.out.println("잘못된 선택입니다. "); 
				return;
			
		}
		
		System.out.println("원하시는 음료를 고르세요. ");
		String choiseDrink = br.readLine();
		
		makeClass(choiseDrink);
		
		while(true) {
			
			System.out.println("원하시는 메뉴를 고르세요. ");
			
			System.out.println("1. 영양 정보 확인");
			System.out.println("2. 알레르기 정보 확인");
			System.out.println("3. 가격 확인");
			System.out.println("4. 장바구니 담기");
			System.out.println("5. 이전 메뉴로");
			
			String choiseMenu = br.readLine();
			
			if(!choiseMenu(choiseMenu, choiseDrink)) return;
			System.out.println();
		}
		
	}
	
	public static void choiseDessert() {
		
	}
	
	public static boolean choiseMenu(String choiseMenu, String choiseDrink) throws Exception {
		
		String size;
		
		switch(choiseMenu) {
		
			case "1" : 
				
				System.out.println("사이즈를 고르세요. ");
				for(String key : Menu.drinkSize)
					System.out.println(key);
				
				size = br.readLine();
				dynamicMethod = dynamicClass.getMethod("getNutritionalInformation", int.class);
		        dynamicMethod.invoke(dynamicObject, Integer.parseInt(size));
		        
				for (String key : Menu.nutritionalInformation) 
					System.out.println(key);
				
				break;
				
			case "2" : 
				
				dynamicMethod = dynamicClass.getMethod("getAllergyTriggers");
		        dynamicMethod.invoke(dynamicObject);
		        
		        for(String key : Menu.allergyList) 
		        	System.out.println(key);
		        
				break;
				
			case "3" : 
				
				System.out.println("사이즈를 고르세요. ");
				for(String key : Menu.drinkSize)
					System.out.println(key);
				
				size = br.readLine();
				dynamicMethod = dynamicClass.getMethod("getPrice", int.class);
		        System.out.println(dynamicMethod.invoke(dynamicObject, Integer.parseInt(size)));
		        
				break;
				
			case "4" : 
				System.out.println("사이즈를 고르세요. ");
				for(String key : Menu.drinkSize)
					System.out.println(key);
				size = br.readLine();
				
				System.out.println("수량을 입력하세요.");
				int amount = Integer.parseInt(br.readLine());
				
				Menu.basket.put(size + " " + choiseDrink, Menu.basket.getOrDefault(size + choiseDrink, 0) + amount);
				break;
				
			case "5" : 
				return false;
		
		}
		
		return true;
	}
	
	public static void checkBasket() {
		
		for (String key : Menu.basket.keySet()) {

			int size = Integer.parseInt(key.split(" ")[0]);
			String cupSize = size == 1 ? "Short Size " : size == 2 
									   ? "Tall Size " : size == 3 
									   ? "Grande Size " : "Venti Size ";
			
			System.out.println(cupSize + key.split(" ")[1] + " : " + Menu.basket.get(key));
		}
	}
}
