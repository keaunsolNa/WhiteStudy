package keaunsol2;

public class Espresso implements Drink {

	@Override
	public void getSize() {

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
	public Integer getPrice(int size) {
		return null;
	}

	@Override
	public void setAmount(int choiseSize) {
		// TODO Auto-generated method stub
		
	}

}
