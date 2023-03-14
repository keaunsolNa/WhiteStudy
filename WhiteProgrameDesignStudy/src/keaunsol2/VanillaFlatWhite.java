package keaunsol2;

public class VanillaFlatWhite extends Espresso{

	public static int price;
	@Override
	public void getNutritionalInformation(int size) {
		
		if(size == 1) {
			
			nutritionalInformation[0] = "145kcal";
			nutritionalInformation[1] = "18g";
			nutritionalInformation[2] = "15g";
			nutritionalInformation[3] = "85mg";
			nutritionalInformation[4] = "6g";
			nutritionalInformation[5] = "5g";
			nutritionalInformation[6] = "15mg";
			nutritionalInformation[7] = "0g";
			nutritionalInformation[8] = "195mg";
			nutritionalInformation[9] = "3.2g";
			
		}
		
		else if(size == 2) {

			nutritionalInformation[0] = "220kcal";
			nutritionalInformation[1] = "27g";
			nutritionalInformation[2] = "23g";
			nutritionalInformation[3] = "130mg";
			nutritionalInformation[4] = "9g";
			nutritionalInformation[5] = "8g";
			nutritionalInformation[6] = "25mg";
			nutritionalInformation[7] = "0g";
			nutritionalInformation[8] = "260mg";
			nutritionalInformation[9] = "5g";
			
		}
		
	}

	@Override
	public void getAllergyTriggers() {
		
		allergyList.add("milk");
		
	}
	
	@Override
	public Integer getPrice() {
		
		if(amount.containsKey("vanillaFlatWhite1")) 
			price += (5400 * amount.get("vanillaFlatWhite1"));
		
		if(amount.containsKey("vanillaFlatWhite2"))
			price += (5900 * amount.get("vanillaFlatWhite2"));
		
		return price;
	}
	
	@Override
	public void setAmount(int choiseSize) {

		amount.put("vanillaFlatWhite" + choiseSize, amount.getOrDefault("vanillaFlatWhite", 0) + 1);
	}
}
