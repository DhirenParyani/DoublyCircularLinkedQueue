package com.java.cs635.assignment1.beans;

public class ListNode {
	private WorkProcess workprocess;
	private ListNode next;
	
	public ListNode() {
		this.workprocess = null;

	}
	public ListNode(WorkProcess workprocess) {
		this.workprocess = workprocess;

	}

	public WorkProcess getWorkprocess() {
		return workprocess;
	}

	public void setWorkprocess(WorkProcess workprocess) {
		this.workprocess = workprocess;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
	public int listLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}

		return length;
	}

}
