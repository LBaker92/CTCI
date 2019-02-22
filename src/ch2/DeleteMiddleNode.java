package ch2;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		{
			System.out.println("ODD NUM NODES");
			CTCIList list = new CTCIList();
			list.append(10);
			list.append(20);
			list.append(30);
			list.append(40);
			list.append(50);
			list.printList();
			deleteMiddleNode(list.getNodeAt(3));
			list.printList();
			System.out.println();
		}

		{
			System.out.println("EVEN NUM NODES");
			CTCIList list = new CTCIList();
			list.append(10);
			list.append(20);
			list.append(30);
			list.append(40);
			list.printList();
			deleteMiddleNode(list.getNodeAt(2));
			list.printList();
			System.out.println();
		}
		
		{
			System.out.println("EVEN NUM NODES");
			CTCIList list = new CTCIList();
			list.append(10);
			list.append(20);
			list.printList();
			deleteMiddleNode(list.getNodeAt(1));
			list.printList();	
			System.out.println();
		}
	}

	/*
	 * Implement an algorithm to delete a node in the moddle(any node but the first
	 * and last node, not necessarility exact middle) of a singly linked list, given
	 * only access to that node.
	 * 
	 * Since we are only given access to the node we want to delete, we simply
	 * replace the current node with the next one.
	 */
	public static void deleteMiddleNode(CTCINode node) {
		if (node == null || node.getNext() == null) {
			return;
		}
		CTCINode ptr = node.getNext();
		node.setData(ptr.getData());
		node.setNext(ptr.getNext());
	}

}
