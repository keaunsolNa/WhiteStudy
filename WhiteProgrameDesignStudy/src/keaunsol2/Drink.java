package keaunsol2;

public interface Drink extends Menu{
	
	public static final int shortSize = 237;
	public static final int tallSize = 355;
	public static final int grandeSize = 473;
	public static final int venteSize = 591;

	public static final String storeCup =  "storeCup";
	public static final String personalCup = "personalCup";
	public static final String disposableCup = "disposableCup";
	
	public abstract Integer getSize(int choise);
	public abstract String getCupType(int choise);
	public abstract String[] personalOption();

	
}
