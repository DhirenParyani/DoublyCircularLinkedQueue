package com.java.cs635.assignment1.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import com.java.assignment1.linkedlist.CircularDoublyLinkedQueue;
import com.java.assignment1.linkedlist.CircularDoublyLinkedQueue.WorkProcessParams;
import com.java.assignment1.linkedlist.LinkedQueue;
import com.java.cs635.assignment1.array.DynamicQueue;
import com.java.cs635.assignment1.beans.DoublyLinkedListNode;
import com.java.cs635.assignment1.beans.WorkProcess;

public class Test {
	public static void main(String[] args) {

		WorkProcess wp1 = new WorkProcess("Paint", 6, 2, 5, 10,"Dhiren");
		WorkProcess wp2 = new WorkProcess("IE", 4, 2, 5, 10,"Dhiren");
		WorkProcess wp3 = new WorkProcess("Eclipse", 1, 2, 5, 10,"Dhiren");
		WorkProcess wp4 = new WorkProcess("Instagram", 3, 2, 5, 10,"Dhiren");
		WorkProcess wp5 = new WorkProcess("AcrobatReader", 9, 2, 5, 10,"Dhiren");

		
		
		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue(3);
		oCircularLinkedList.enQueue(wp1);
		oCircularLinkedList.enQueue(wp2);
		oCircularLinkedList.enQueue(wp3);
		
		oCircularLinkedList.enQueue(wp5);
		DoublyLinkedListNode clonedFrontNode=oCircularLinkedList.getClonedLinkedList();
		oCircularLinkedList.Param=WorkProcessParams.PID;
		
		DoublyLinkedListNode sortedList=oCircularLinkedList.mergeSort(clonedFrontNode);
		
		
	}

}
