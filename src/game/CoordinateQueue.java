package game;

public class CoordinateQueue {
	
	// class for easier representation of coordinates in project
	public static class Coordinates {
		int x;
		int y;
		
		public Coordinates (int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
	}
	
	//private class that defines CoordinateNodes
	private static class CoordinateNode {
		Coordinates coordinates;
		CoordinateNode next;
		CoordinateNode prev;
		
		public CoordinateNode(int x, int y) {
			this.coordinates = new Coordinates(x, y);
			this.next = null;
			this.prev = null;
		}
		
		public CoordinateNode(int x, int y, CoordinateNode next) {
			this.coordinates = new Coordinates(x, y);
			this.next = next;
			this.prev = null;
		}
		
		public CoordinateNode(int x, int y, CoordinateNode prev, CoordinateNode next) {
			this.coordinates = new Coordinates(x, y);
			this.next = next;
			this.prev = prev;
		}
	}
	
	// implementation of some Queue methods that will be needed for work
	
	CoordinateNode tail;
	CoordinateNode head;
	
	public CoordinateQueue () {
		tail = null;
		head = null;
	}
	
	public void add(int x, int  y) {
		CoordinateNode temp = new CoordinateNode(x, y);
		if(this.head == null && this.tail == null) {
			this.head = temp;
			this.tail = head;
		}
		else if(head == tail) {
			tail = temp;
			tail.next = head;
			head.prev = tail;
		}
		
		else {
			temp.next = tail;
			tail.prev = temp;
			tail = temp;
		}
	}
	
	public void remove() {
		if(head == null) return;
		
		CoordinateNode temp = head.prev;
		if(temp == null) {
			head = null;
			tail = null;
		}
		else {
			head = temp;
			head.next = null;
		}
	}
	
	public Coordinates peek() {
		return head.coordinates;
	}
	
	
	public  boolean isEmpty() {
		return head == null;
	}
	
}
