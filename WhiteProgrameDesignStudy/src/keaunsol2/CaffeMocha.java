package keaunsol2;

public class CaffeMocha extends Espresso{

	@Override
	public void getNutritionalInformation(int size) {
		
		if(size == 1) {
			
			nutritionalInformation[0] = "200kcal";
			nutritionalInformation[1] = "22g";
			nutritionalInformation[2] = "17g";
			nutritionalInformation[3] = "65mg";
			nutritionalInformation[4] = "7g";
			nutritionalInformation[5] = "11g";
			nutritionalInformation[6] = "35mg";
			nutritionalInformation[7] = "0g";
			nutritionalInformation[8] = "90mg";
			nutritionalInformation[9] = "6g";
			
		}
		
		else if(size == 2) {

			nutritionalInformation[0] = "290kcal";
			nutritionalInformation[1] = "33g";
			nutritionalInformation[2] = "25g";
			nutritionalInformation[3] = "105mg";
			nutritionalInformation[4] = "10g";
			nutritionalInformation[5] = "15g";
			nutritionalInformation[6] = "45mg";
			nutritionalInformation[7] = "0g";
			nutritionalInformation[8] = "95mg";
			nutritionalInformation[9] = "9g";
			
		}
		
		else if(size == 3) {
		
			nutritionalInformation[0] = "360kcal";
			nutritionalInformation[1] = "42g";
			nutritionalInformation[2] = "32g";
			nutritionalInformation[3] = "125mg";
			nutritionalInformation[4] = "13g";
			nutritionalInformation[5] = "19g";
			nutritionalInformation[6] = "55mg";
			nutritionalInformation[7] = "0g";
			nutritionalInformation[8] = "175mg";
			nutritionalInformation[9] = "10g";
			
		}
		
		else {
			
			nutritionalInformation[0] = "450kcal";
			nutritionalInformation[1] = "53g";
			nutritionalInformation[2] = "41g";
			nutritionalInformation[3] = "170mg";
			nutritionalInformation[4] = "17g";
			nutritionalInformation[5] = "22g";
			nutritionalInformation[6] = "65mg";
			nutritionalInformation[7] = "0.5g";
			nutritionalInformation[8] = "180mg";
			nutritionalInformation[9] = "12g";
		}
		
	}

	@Override
	public void getAllergyTriggers() {
		
		allergyList.add("milk");
		
	}
	
	@Override
	public Integer getPrice(int size) {
		
		int price = size == 1 ? 5000 : size == 2 ? 5500 : size == 3 ? 6000 : 6500;
		
		return price;
	}
	
	@Override
	public void getSize() {
		
		drinkSize.add("Short");
		drinkSize.add("Tall");
		drinkSize.add("Grande");
		drinkSize.add("Venti");
		
	}
}
