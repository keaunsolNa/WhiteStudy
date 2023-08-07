package keaunsol2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DSTest {

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);

		Stack stack = new Stack<>();
		
		stack.add("String");
		stack.add(1234);
		stack.add(1.234);
		
		stack.add(new int[]{ 1,2 , 3, 4});
		List<Integer> list = new ArrayList<>();
		list.add(123456);
		stack.add(list);
		
		while(!stack.isEmpty()) {
			
			Object temp = stack.pop();
			
			System.out.println(temp + " : " + temp.getClass().getTypeName());
		}
		
		System.out.println();
		System.out.println("=================List 생성 비교====================");
		System.out.println();
		
		System.out.println(list1 == list2);
		System.out.println(list1.equals(list2));
		System.out.println(list1.hashCode() + " , " + list2.hashCode() + " is? : " + (list1.hashCode() == list2.hashCode()));
		
		System.out.println();
		System.out.println("================List parameter 비교=====================");
		System.out.println();
		
		List<Integer> list3 = new ArrayList<>(list1);
		
		System.out.println(list1 == list3);
		System.out.println(list1.equals(list3));
		System.out.println(list1.hashCode() + " , " + list3.hashCode() + " is? : " + (list1.hashCode() == list3.hashCode()));
		
		List<Integer> list4 = list1;
		
		System.out.println("==================List = 비교 ===================");
		System.out.println();
		
		System.out.println(list1 == list4);
		System.out.println(list1.equals(list4));
		System.out.println(list1.hashCode() + " , " + list4.hashCode() + " is? : " + (list1.hashCode() == list4.hashCode()));
		
		
		System.out.println();
		System.out.println("=================배열 생성 비교====================");
		System.out.println();
		
		int[] arr1 = new int[] {1, 2};
		int[] arr2 = new int[] {1, 2};
		
		System.out.println(arr1 == arr2);
		System.out.println(arr1.equals(arr2));
		System.out.println(arr1.hashCode() + " , " + arr2.hashCode() + " is? : " + (arr1.hashCode() == arr2.hashCode()));
		
		
		System.out.println();
		System.out.println("==================배열 clone 비교 ===================");
		System.out.println();
		
		int[] arr3 = arr1.clone();
		
		System.out.println(arr1 == arr3);
		System.out.println(arr1.equals(arr3));
		System.out.println(arr1.hashCode() + " , " + arr3.hashCode() + " is? : " + (arr1.hashCode() == arr3.hashCode()));

		System.out.println();
		System.out.println("================배열 = 비교 =====================");
		System.out.println();
		
		int[] arr4 = arr1;

		System.out.println(arr1 == arr4);
		System.out.println(arr1.equals(arr4));
		System.out.println(arr1.hashCode() + " , " + arr4.hashCode() + " is? : " + (arr1.hashCode() == arr4.hashCode()));
		
	}
}
