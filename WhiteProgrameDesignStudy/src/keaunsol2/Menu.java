package keaunsol2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Menu {

	static String[] nutritionalInformation = new String[10];
	static List<String> drinkSize = new ArrayList<>();
	static List<String> allergyList = new ArrayList<>();
	static Map<String, Integer> custom = new HashMap<>();
	static Map<String, Integer> basket = new HashMap<>();
	
	public abstract void getNutritionalInformation(int size);
	public abstract void getAllergyTriggers();
	public abstract Integer getPrice(int size);

	
}
