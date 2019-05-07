package ch3;

import java.util.ArrayList;

class Node {
	int val = 0;
	Node next = null;
	
	Node(int v) {
		val = v;
	}
}

class Stack {
	int size = 0;
	Node tos = null;
	
	void push(int v) {
		Node n = new Node(v);
		if (tos == null) {
			tos = n;
		} else {
			Node temp = tos;
			tos = n;
			n.next = temp;
		}
		++size;
	}
	int pop() {
		int res = -1;
		if (tos == null) {
			return res;
		}
		res = tos.val;
		tos = tos.next;
		--size;
		return res;
	}
}

/*
 * 
 */
public class StackOfStacks {
	private final static int STACK_LIMIT = 4;
	private ArrayList<Stack> stacks = new ArrayList<>();
	private int stackIndex = 0;
	
	public void push(int v) {
		if (stacks.isEmpty()) {
			stacks.add(new Stack());
			stacks.get(stackIndex).push(v);
			return;
		}
		if (stacks.get(stackIndex).size == STACK_LIMIT) { // If the stack is at max capacity, make a new stack
			stacks.add(new Stack());
			stacks.get(++stackIndex).push(v);
			return;
		}
		stacks.get(stackIndex).push(v);
	}
	
	public int pop() {
		if (stacks.isEmpty()) {
			throw new NullPointerException();
		}
		int res = stacks.get(stackIndex).pop();
		if (stacks.get(stackIndex).size == 0) {
			if (stackIndex > 0) { // Prevent stack index from going negative.
				stacks.remove(stacks.get(stackIndex--));
			} else {
				stacks.remove(stacks.get(stackIndex));
			}
		}
		return res;
	}
	
	public int popAt(int i) {
		if (stacks.get(i) == null) {
			throw new NullPointerException();
		}
		return stacks.get(i).pop();
	}
	
	public static void main(String[] args) {
		StackOfStacks s = new StackOfStacks();
		s.push(10);
		s.push(11);
		s.push(20);
		s.push(21);
		s.push(30);
		s.push(31);
		s.push(40);
		s.push(41);
		s.push(50);
		System.out.println(s.popAt(0));
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(10);
	}

}
