package evaluation14Oct;

import java.util.Arrays;
import java.util.Scanner;

public class succeedingInteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the size of the Array");

		int size = scan.nextInt();
		if (size<0) {
			System.out.println("Size can't be negative, please enter a +ve number");
			size = scan.nextInt();
		}
		int [] array = new int[size] ;
		
		System.out.println("please enter value for each index of the array");

		for (int i = 0; i < array.length; i++) {

			array[i] = scan.nextInt();
		}
		
		succeedInt(array);
	}

	private static void succeedInt(int[] array) {
		String num = "";
		
		for (int i = 0; i < array.length; i++) {
			num = num+array[i];
		}
		
		String sucInt = ""+ (Integer.parseInt(num) +1) ;
		
		int[] newArry =  new int[sucInt.length()];
		
		for (int i = 0; i < newArry.length; i++) {
			newArry[i] = sucInt.charAt(i) - 48;
		}
		
		System.out.println(Arrays.toString(newArry));
	}
	
	

}
