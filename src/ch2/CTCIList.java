package ch2;

import java.util.HashSet;

/*
 * Basic implementation of a singly linked list for the Chapter 2 problems.
 */
public class CTCIList {
	private CTCINode head = null;
	private CTCINode tail = null;

	public void append(int d) {
		CTCINode temp = new CTCINode(d);
		if (head == null) {
			head = temp;
			tail = temp;
			return;
		}
		tail.setNext(temp);
		tail = tail.getNext();
	}

	public int remove(int num) {
		if (head == null) { // List is empty.
			return -1;
		}
		int result = 0;
		if (head.getData() == num) {
			result = head.getData();
			head = head.getNext();
			return result;
		}
		CTCINode temp = head;
		CTCINode prev = null;
		while (temp != null) {
			if (temp.getData() != num) {
				prev = temp;
			} else {
				prev.setNext(temp.getNext());
				result = temp.getData();
				return result;
			}
			temp = temp.getNext();
		}
		return -1;
	}

	/*
	 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP How
	 * would you solve this problem if a temporary buffer is not allowed?
	 * 
	 * We can start from the beginning of the list, adding the node's data to a set
	 * and move to the next node. We keep track on the previous node. If we come
	 * across a duplicate, we tell the previous node to "skip" the duplicate by
	 * changing it's next to the node's next. This makes that duplicate node lose
	 * its references and get garbage collected.
	 */
	public void removeDupes() {
		HashSet<Integer> set = new HashSet<Integer>();
		CTCINode curr = head;
		CTCINode prev = null;
		while (curr != null) {
			if (set.contains(curr.getData())) { // Runner contains a duplicate number.
				prev.setNext(curr.getNext());
			} else {
				set.add(curr.getData());
				prev = curr;
			}
			curr = curr.getNext();
		}
	}

	/*
	 * This does the same thing, but uses a runner. For every node in the list, a
	 * runner compares all other nodes to that node. If at any point there is a
	 * duplicate, it will be removed.
	 */
	public void removeDupesRunner() {
		CTCINode curr = head;
		while (curr != null) {
			CTCINode runner = curr;
			while (runner.getNext() != null) {
				if (runner.getNext().getData() == curr.getData()) {
					runner.setNext(runner.getNext().getNext());
				} else {
					runner = runner.getNext();
				}
			}
			curr = curr.getNext();
		}
	}

	public CTCINode getHead() {
		return head;
	}

	public void setHead(CTCINode head) {
		this.head = head;
	}

	public CTCINode getTail() {
		return tail;
	}

	public void setTail(CTCINode tail) {
		this.tail = tail;
	}
}
