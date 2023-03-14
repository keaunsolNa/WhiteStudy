package keaunsol2;

public class Espresso implements Drink {

	@Override
	public Integer getSize(int choise) {
		
		switch(choise) {
			
			case 1 : return Drink.shortSize; 
			case 2 : return Drink.tallSize; 
			case 3 : return Drink.grandeSize;
			case 4 : return Drink.venteSize;
			
			default : return null;
			
		}
	}

	@Override
	public String getCupType(int choise) {
		
		switch(choise) {
		
			case 1 : return Drink.storeCup;
			case 2 : return Drink.personalCup;
			case 3 : return Drink.disposableCup;
			
			default : return null;
		}
	}
	
	@Override
	public void getNutritionalInformation(int choise) {
	}

	@Override
	public void getAllergyTriggers() {
	}


	@Override
	public String[] personalOption() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPrice() {
		return null;
	}

	@Override
	public void setAmount(int choiseSize) {
		// TODO Auto-generated method stub
		
	}

}
