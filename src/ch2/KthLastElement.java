package ch2;

public class KthLastElement {

	public static void main(String[] args) {
		{
			CTCIList list = new CTCIList();
			list.append(10);
			list.append(20);
			list.append(30);
			list.append(40);
			list.append(50);
			kToLastRecursive(list.getHead(), 2);
		}

		{
			CTCIList list = new CTCIList();
			list.append(10);
			list.append(20);
			list.append(30);
			list.append(40);
			list.append(50);
			System.out.println("2 to last node is: " + kToLastIterative(list.getHead(), 2).getData());
		}
	}

	/*
	 * Recursive solution involves starting at the head of the list and calling the
	 * same function on the next element in the list, incrementing i by one each
	 * time. When we have found the node, we print a message. This function will be
	 * run on every element in the list, but only the matching element will be
	 * printed. Thus, requiring O(N) space and time.
	 */
	public static int kToLastRecursive(CTCINode head, int k) {
		if (head == null) {
			return 0;
		}
		int i = kToLastRecursive(head.getNext(), k) + 1;
		if (i == k) {
			System.out.println(k + " to last node is: " + head.getData());
		}
		return i;
	}

	/*
	 * For an iterative solution, you can take 2 pointers and start them at the head
	 * of the list, but then move one of the pointers down the list k times. After
	 * that, you would keep iterating over the list until the pointer that was moved
	 * over k times is at the end of the list. Once it is at the end, we return the
	 * pointer that ran from the beginning of the list because it will be pointing
	 * at the kth to last node. This requires O(N) time, but takes O(1) space.
	 */
	public static CTCINode kToLastIterative(CTCINode head, int k) {
		if (head == null) {
			return null;
		}
		CTCINode beginPtr = head;
		CTCINode kPtr = head;
		for (int i = 0; i < k; ++i) {
			if (kPtr == null) {
				return null;
			}
			kPtr = kPtr.getNext();
		}
		while (kPtr != null) {
			kPtr = kPtr.getNext();
			beginPtr = beginPtr.getNext();
		}
		return beginPtr;
	}
}
