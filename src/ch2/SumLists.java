package ch2;

import java.util.Arrays;
import java.util.LinkedList;

public class SumLists {

	public static void main(String[] args) {
		{
			LinkedList<Integer> a = new LinkedList<Integer>(Arrays.asList(7, 1, 6, 3));
			LinkedList<Integer> b = new LinkedList<Integer>(Arrays.asList(5, 9, 2, 3, 1));
			printList(reverseOrderSum(a, b));
			System.out.println("\n==================");
			printList(sum(a, b));
		}
	}
	
	public static LinkedList<Integer> reverseOrderSum(LinkedList<Integer> a, LinkedList<Integer> b) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		int carry = 0;
		int counter = 0;
		for (int i = 0; i < a.size(); ++i) {
			if (carry > 0) {
				res.add(((a.get(i) + b.get(i)) % 10) + carry);
			} else {
				res.add((a.get(i) + b.get(i)) % 10);
			}
			carry = (a.get(i) + b.get(i)) / 10;
			++counter;
		}
		for (int i = counter; i < b.size(); ++i) { // PROBLEM HERE
			if (carry > 0) {
				res.add(b.get(i) + carry);
			} else {
				res.add(b.get(i));
			}
			carry = 0;
		}
		return res;
	}
	
	public static LinkedList<Integer> sum(LinkedList<Integer> a, LinkedList<Integer> b) {
		a = reverseList(a);
		b = reverseList(b);
		LinkedList<Integer> res = reverseOrderSum(a, b);
		return reverseList(res);
	}
	
	public static LinkedList<Integer> reverseList(LinkedList<Integer> l) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int i = l.size() - 1; i >= 0; --i) {
			res.add(l.get(i));
		}
		return res;
	}
	
	public static void printList(LinkedList<Integer> l) {
		for (Integer num : l) {
			if (num == l.getLast()) {
				System.out.print(num);
			} else {
				System.out.print(num + "->");
			}
		}
	}

}
