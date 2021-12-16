Implement double-ended (deque) queue that stores string



class Deque {
	class Node {
		String val;
		Node pre;
		Node post;
		public Node(String val) {
			this.val = val;
		}	
	}
	private int size;
	private Node head, tail;
	
	public Deque(int size) {
		this.size = size;
		this.head = null;
		this.tail = head;
	}

	public Deque() {
		this.size = 10;
		this.head = null;
		this.tail = head;
	}

	public boolean isEmpty() {
		if(head == tail) {
			return true;
		}
		return false;
	}
	
	public void insertFront(int val) {
		Node p = new Node()
	}

	public static void main(String args[]) {
		
	}

}