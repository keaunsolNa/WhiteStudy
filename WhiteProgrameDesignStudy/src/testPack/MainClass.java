package testPack;

public class MainClass {

	public static void main(String[] args) {
		
		int j = 0;
		
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			j++;
		}
		System.out.println(1);
		System.out.println(j);
		
//		MiniCupper car = new MiniCupper();
		Book book1 = new Book();
		Book book2 = new Book();
		
		book1.getName();
		book1.getPrice();
		

		book2.setName("박경연");
		book2.setPrice(234435);
		book2.setSaleYN(false);
		book2.name2 = "김현희";
		
		System.out.println(book2.getName());
		System.out.println(book2.toString());
		
	}

}
