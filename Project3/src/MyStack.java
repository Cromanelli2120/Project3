import java.util.EmptyStackException;

public class MyStack<E> implements StackInterface<E> {

	public class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E dataPart, Node<E> nextNode) {
			data = dataPart;
			next = nextNode;
		}
		
		public Node(E dataPart) {
			this(dataPart, null);
		}
		
		public E getData() {
			return data;
		}
		
		public void setData(E newEntry) {
			data = newEntry;
		}
		
		public Node<E> getNextNode(){
			return next;
		}
		
		public void setNextNode(Node<E> nextNode) {
			next = nextNode;
		}
	}
	
	private int numOfEntries;
	private Node<E> topOfStack;
	@Override
	public void push(E newEntry) {
		if(isEmpty()) {
			Node<E> newNode = new Node(newEntry);
			topOfStack = newNode;
		}
		else {
			Node<E> newNode = new Node(newEntry, topOfStack);
			topOfStack = newNode;
		}
		numOfEntries++;
	}

	@Override
	public E pop() {
		if(topOfStack != null) {
			E result = topOfStack.getData();
			topOfStack = topOfStack.getNextNode();
			numOfEntries--;
			return result;
		}
		else throw new EmptyStackException();
	}

	@Override
	public E peek() {
		if(topOfStack != null) {
			return topOfStack.getData();
		}
		else throw new EmptyStackException();
	}

	@Override
	public boolean isEmpty() {
		if (numOfEntries <= 0) {
			return true;
		}
		else return false;
	}

	@Override
	public void clear() {
		if(topOfStack != null) {
			topOfStack.setNextNode(null);
			topOfStack = null;
			numOfEntries = 0;
		}
	}

}
