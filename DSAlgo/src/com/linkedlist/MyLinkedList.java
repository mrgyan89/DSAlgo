package com.linkedlist;

/* This program shows, how we can create our own linked list in JAVA with list of
 * operations like add, delete, traverse, search etc.
 */

class Node<E> {
	E data;
	Node<E> next;

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}
}

public class MyLinkedList<E> {

	private Node<E> start;
	/*
	 * keep a pointer always on last node to add new item in O(1) time complexity,
	 * instead of looping from start to end node on addition of every new node
	 */
	private Node<E> last;
	private Node<E> tmp;

	public void add(E data) {
		if (start == null) {
			start = new Node<E>(data, null);
			last = start;
			return;
		}
		last.next = new Node<E>(data, null);
		last = last.next;
	}

	public boolean delete(E data) {
		/*
		 * Return false if item cannot be deleted because it does not exist in list else
		 * return true
		 */
		boolean isDeleted = false;
		if (start != null && start.data.equals(data)) {
			isDeleted = true;
			start = start.next;
			return isDeleted;
		}
		tmp = start;
		while (tmp != null) {
			if (tmp.next != null && tmp.next.data.equals(data)) {
				isDeleted = true;
				tmp.next = tmp.next.next;
				break;
			}
			tmp = tmp.next;
		}
		return isDeleted;
	}

	public void traverse() {
		tmp = start;
		while (tmp != null) {
			System.out.print("->" + tmp.data);
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.traverse();
		boolean isDeleted = list.delete(4);
		System.out.println("\nIs item 4 deleted:" + isDeleted);
		list.add(6);
		list.traverse();
	}

}
