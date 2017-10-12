package implementations;

public class HashMap {

	static class Node {
		int value;
		int key;
		Node next;

		public Node(int key, int data) {
			this.key = key;
			this.value = data;
		}
	}

	public HashMap() {
		node = new Node[size];
	}

	public HashMap(int size) {
		this.size = (int) Math.pow(2.0,
				Math.ceil(Math.log10((double) size) / Math.log10((double) 2)));
		node = new Node[this.size];
		limit = (int) (0.75 * this.size);
	}

	public HashMap(int size, double limitFactor) {

		this.size = (int) Math.pow(2.0,
				Math.ceil(Math.log10((double) size) / Math.log10((double) 2)));
		node = new Node[this.size];
		if (limitFactor > 0.0 && limitFactor < 1.0)
			limit = (int) (limitFactor * this.size);
		else
			limit = (int) (0.75 * this.size);
	}
	public HashMap(HashMap hm) {
		this.size = hm.size;
		node = new Node[this.size];
			limit = hm.limit;
	}

	int size = 16, count = 0, limit = 12;
	Node[] node;

	private int getHashcode(int number) {
		return number % size;
	}

	private void reHash() {
		size = size * 2;
		Node[] temp = new Node[size];
		Node[] swapNode = node;
		node = temp;
		temp = null;
		count = 0;
		for (int i = 0; i < limit; i++) {
			Node tempNode = swapNode[i];
			while (tempNode != null) {
				put(tempNode.key, tempNode.value);
				tempNode = tempNode.next;
			}

		}
		swapNode = null;
		System.out.println("Rehashed");
		System.gc();
		limit = (int) (size * 0.75);
	}

	public int get(int key) {
		try {
			Node tempNode = node[getHashcode(key)];
			while (tempNode != null) {
				if (tempNode.key == key)
					return tempNode.value;
				tempNode = tempNode.next;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void put(int key, int value) {
		try {
			if (count == limit && get(key) == -1)
				reHash();
			Node tempNode = node[getHashcode(key)];
			if (tempNode == null) {
				node[getHashcode(key)] = new Node(key, value);
				count++;
				return;
			}
			Node prev = null;
			while (tempNode != null) {
				if (tempNode.key == key) {
					tempNode.value = value;
					return;
				}
				prev = tempNode;
				tempNode = tempNode.next;
			}
			prev.next = new Node(key, value);
			count++;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void remove(int key) {
		try {
			int index = getHashcode(key);
			Node tempNode = node[index];
			if (tempNode.key == key) {
				node[index] = null;
				return;
			}
			Node prev = tempNode;
			tempNode = tempNode.next;
			while (tempNode != null) {
				if (tempNode.key == key) {
					prev.next = tempNode.next;
					count--;
					return;
				}
				prev = tempNode;
				tempNode = tempNode.next;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
