package keaunsol2;

public class JavabucksDolceLatte extends Espresso{

	@Override
	public void getNutritionalInformation(int size) {
		
		if(size == 1) {
			
			nutritionalInformation[0] = "175kcal";
			nutritionalInformation[1] = "28g";
			nutritionalInformation[2] = "26g";
			nutritionalInformation[3] = "130mg";
			nutritionalInformation[4] = "8g";
			nutritionalInformation[5] = "3g";
			nutritionalInformation[6] = "10mg";
			nutritionalInformation[7] = "0.2g";
			nutritionalInformation[8] = "75mg";
			nutritionalInformation[9] = "2g";
			
		}
		
		else if(size == 2) {

			nutritionalInformation[0] = "255kcal";
			nutritionalInformation[1] = "42g";
			nutritionalInformation[2] = "39g";
			nutritionalInformation[3] = "190mg";
			nutritionalInformation[4] = "12g";
			nutritionalInformation[5] = "4.2g";
			nutritionalInformation[6] = "15mg";
			nutritionalInformation[7] = "0.3g";
			nutritionalInformation[8] = "150mg";
			nutritionalInformation[9] = "2.6g";
			
		}
		
		else if(size == 3) {
		
			nutritionalInformation[0] = "335kcal";
			nutritionalInformation[1] = "55g";
			nutritionalInformation[2] = "51g";
			nutritionalInformation[3] = "240mg";
			nutritionalInformation[4] = "16g";
			nutritionalInformation[5] = "6g";
			nutritionalInformation[6] = "17mg";
			nutritionalInformation[7] = "0.4g";
			nutritionalInformation[8] = "225mg";
			nutritionalInformation[9] = "3.5g";
			
		}
		
		else {
			
			nutritionalInformation[0] = "420kcal";
			nutritionalInformation[1] = "70g";
			nutritionalInformation[2] = "64g";
			nutritionalInformation[3] = "305mg";
			nutritionalInformation[4] = "20g";
			nutritionalInformation[5] = "7g";
			nutritionalInformation[6] = "20mg";
			nutritionalInformation[7] = "0.4g";
			nutritionalInformation[8] = "300mg";
			nutritionalInformation[9] = "4.5g";
		}
		
	}

	@Override
	public void getAllergyTriggers() {
		
		allergyList.add("milk");
		
	}
	
	@Override
	public Integer getPrice(int size) {
		
		int price = size == 1 ? 5400 : size == 2 ? 5900 : size == 3 ? 6400 : 6900;
		
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
