import java.util.Scanner;

import org.w3c.dom.css.Counter;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySequence {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String arrSize = scanner.nextLine();
		String binaryStrNums = scanner.nextLine().replaceAll("\\s", "");
		
		ArrayList<Integer> binaryList = validateData(arrSize, binaryStrNums);
		/*for(Integer i: arrayList) {
			System.out.println(i);
		}*/
		int[] zeros = getZeroSeq(binaryList);
		System.out.println(Arrays.toString(zeros));
		
	}
	
	public static int[] getZeroSeq(ArrayList<Integer>binaryList) {
		int[] zeroAnswer = new int[2];
		int counter = 0;
		int max = 0;
		int lastIndex = 0;
		int newIndex = 0;
		for(int i = 0; i < binaryList.size(); i++) {
			if(binaryList.get(i) == 0) {
				counter++;
				//lastIndex = i;
				System.out.println("index in if " + i);
			} else {
				max = Math.max(counter, max);
				System.out.println("index in else " + i);
				//newIndex = Math.max(lastIndex, newIndex);
				//System.out.println("New index " + newIndex);
				counter = 0;
			}
		}
		zeroAnswer[0] = max;
		zeroAnswer[1] = newIndex;
		return zeroAnswer;
	}
		
	public static ArrayList<Integer> validateData(String arrSize, String binaryStrNums) {
		ArrayList<Integer> arr= new ArrayList<Integer>();
		try {
			int binaryNumsLen = binaryStrNums.length();
			int size = Integer.parseInt(arrSize);
			Integer allBinNums = Integer.parseInt(binaryStrNums);
			
			if(size < 2 || size > 100) {
				System.out.println("The size of the array shouls be 2 =< n >= 100. Please"
						+ " validate your input.");
				System.exit(0);
			}
			
			if(binaryNumsLen < 2 || binaryNumsLen > 100) {
				System.out.println("The size of the array shouls be 2 =< n >= 100. Please"
						+ " validate your input.");
				System.exit(0);
			}
			
			if (binaryNumsLen == size) {
				
				for(int i = 0; i < size; i++) {
					arr.add(allBinNums % 10);
					allBinNums /= 10;
				}
			}
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Input must be an integer.");
		} 
		
		return arr;
		
	}
	
	

	
}
