package keaunsol2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Application {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			
			System.out.println("★★★ Javabucks ★★★");
			
			System.out.println("1. 메뉴를 선택 해 주세요.");
			System.out.println("1. 음료");
			System.out.println("2. 디저트");
			System.out.println("3. 계산");
			System.out.println("4. 종료");
			int choiseMenu = Integer.parseInt(br.readLine());
			
			if(choiseMenu == 1) choiseDrink();
			else choiseDessert();
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void choiseDrink() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
		
		Class<?> dynamicClass;
		Object dynamicObject;
		Method dynamicMethod;
		
		dynamicClass = Class.forName("keaunsol2." + choiseDrink);
		dynamicObject = dynamicClass.newInstance();

		while(true) {
			
			System.out.println("원하시는 메뉴를 고르세요. ");
			
			System.out.println("1. 영양 정보 확인");
			System.out.println("2. 알레르기 정보 확인");
			System.out.println("3. 가격 확인");
			System.out.println("4. 장바구니 담기");
			System.out.println("5. 이전 메뉴로");
			
			String choiseMenu = br.readLine();
			
			switch(choiseMenu) {
			
				case "1" : 
					
					dynamicMethod = dynamicClass.getMethod("getNutritionalInformation", int.class);
			        dynamicMethod.invoke(dynamicObject, 2);
			        
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
					break;
					
				case "4" : 
					break;
					
				case "5" : 
					return;
					
			}
			
			System.out.println();
		}
		
	}
	
	public static void choiseDessert() {
		
	}
}
