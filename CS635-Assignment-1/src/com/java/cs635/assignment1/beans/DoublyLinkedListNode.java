package com.java.cs635.assignment1.beans;

public class DoublyLinkedListNode {
	private WorkProcess workProcess;
	private DoublyLinkedListNode prev;
	private DoublyLinkedListNode next;

	public DoublyLinkedListNode()
	{
		this.workProcess=null;
		this.next=null;
		this.prev=null;
	}

	public DoublyLinkedListNode(WorkProcess oWorkProcess)
	{
		this.workProcess=oWorkProcess;
		this.next=null;
		this.prev=null;
	}
	public DoublyLinkedListNode(WorkProcess oWorkProcess,DoublyLinkedListNode prev, DoublyLinkedListNode next)
	{
		this.workProcess=oWorkProcess;
		this.next=next;
		this.prev=prev;
	}

	public WorkProcess getWorkProcess() {
		return workProcess;
	}
	public void setWorkProcess(WorkProcess workProcess) {
		this.workProcess = workProcess;
	}
	public DoublyLinkedListNode getPrev() {
		return prev;
	}
	public void setPrev(DoublyLinkedListNode prev) {
		this.prev = prev;
	}
	public DoublyLinkedListNode getNext() {
		return next;
	}
	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}

}
