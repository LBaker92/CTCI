package ch2;

public class CTCINode {
	private int data = 0;
	private CTCINode next = null;
	
	public CTCINode(int d) {
		data = d;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CTCINode getNext() {
		return next;
	}

	public void setNext(CTCINode next) {
		this.next = next;
	}
	
}
