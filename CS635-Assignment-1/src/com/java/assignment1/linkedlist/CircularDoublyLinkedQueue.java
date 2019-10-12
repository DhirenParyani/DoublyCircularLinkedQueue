package com.java.assignment1.linkedlist;



import com.java.cs635.assignment1.beans.DoublyLinkedListNode;
import com.java.cs635.assignment1.beans.WorkProcess;

public class CircularDoublyLinkedQueue
{
	private DoublyLinkedListNode front;
	private DoublyLinkedListNode rear;
	private static int capacity;
	private int length;

	public enum WorkProcessParams
	{
		PID, PNAME, CPUTIME, CPUPERCENT, CPUUSAGE, OWNER

	}

	public WorkProcessParams Param;

	/**
	 * CircularDoublyLinkedList(): When initialized with default constructor: Default capacity as 2, two blank DoublyLinkedList nodes are created. 
	 * for circular implementation,(Node1->next=Node2, Node2->Previous=Node1),(Node1->Previous=Node2,Node2->Next=Node1).
	 * Front and rear nodes are pointing to the first blank node for starters.
	 */

	public CircularDoublyLinkedQueue()
	{
		DoublyLinkedListNode oDoublyLinkedListNode1 = new DoublyLinkedListNode();
		DoublyLinkedListNode oDoublyLinkedListNode2 = new DoublyLinkedListNode();
		front = oDoublyLinkedListNode1;
		rear = oDoublyLinkedListNode1;
		// Circular Implementation
		oDoublyLinkedListNode1.setPrev(oDoublyLinkedListNode2);
		oDoublyLinkedListNode1.setNext(oDoublyLinkedListNode2);
		oDoublyLinkedListNode2.setPrev(oDoublyLinkedListNode1);
		oDoublyLinkedListNode2.setNext(oDoublyLinkedListNode1);
		capacity = 2;
		length = 0;
	}

	/**
	 * CircularDoublyLinkedList(int capacity): When initialized with parameterized constructor: initial capacity is set by the argument, blank nodes are created according to the capacity. 
	 * As a Doubly Linked List, consecutive nodes are connected by next and previous pointers.
	 * for Circular Implementation, first and last nodes are connected by next and previous pointers. 
	 * Front and rear nodes are pointing to the first blank node for starters.
	 */

	public CircularDoublyLinkedQueue(int capacity)
	{
		DoublyLinkedListNode firstDoublyLinkedListNode = new DoublyLinkedListNode();
		front = firstDoublyLinkedListNode;
		rear = firstDoublyLinkedListNode;

		if (capacity >= 2)
		{
			//getBlankDoublyLinkedListNodes() is an utility function which creates blank nodes- loop starts from 2 since one is already created above.
			DoublyLinkedListNode followingLinkedListNode=getBlankDoublyLinkedListNodes(firstDoublyLinkedListNode, 2, capacity);
			// Circular implementation->followingLinkedListNode points to the last node after the loop i.e last blank node
			followingLinkedListNode.setNext(firstDoublyLinkedListNode);
			firstDoublyLinkedListNode.setPrev(followingLinkedListNode);
		} else
			return;

		CircularDoublyLinkedQueue.capacity = capacity;
		length = 0;
	}

	/**
	 * enQueue doesn't create any new nodes rather it sets work process object of the existing nodes
	 * Logic: just like a queue at the ticket counter, we keep setting nodes with work process objects from the rear(behind).
	 * Point to remember:* only for first insertion, since front and rear are pointing to the same node,we set the work process object of front. 
	 * Going ahead, we will make front static and will only move it in case of deQueue.
	 */

	public void enQueue(WorkProcess oWorkProcess)
	{

		if (isEmpty())
		{

			front.setWorkProcess(oWorkProcess);

		}

		else
		{
			if (length == capacity)
				expand();

			rear.getNext().setWorkProcess(oWorkProcess);
			rear = rear.getNext();

		}

		length++;

	}

	/**
	 * In deQueue() We don't delete the node rather we set the work process object of node to null starting from the front. 
	 * Point to remember: To maintain the length of the queue, we don't delink the node from other nodes.
	 */

	public WorkProcess deQueue() throws Exception
	{
		if (isEmpty())
			throw new Exception("Underflow.");
		else
		{
			WorkProcess workProcess = front.getWorkProcess();
			front.setWorkProcess(null);
			front = front.getNext();
			length--;
			return workProcess;
		}
	}

	/**
	 * expand() creates as many more blank nodes as are already filled by enQueue new Nodes are linked to the the rear and last created node is linked to the front.(Circular Doubly Linked Queue)
	 */

	public void expand()
	{
		DoublyLinkedListNode doublyLinkedListNodeNextToRear = new DoublyLinkedListNode(null, rear, front);
		doublyLinkedListNodeNextToRear.getPrev().setNext(doublyLinkedListNodeNextToRear);
		front.setPrev(doublyLinkedListNodeNextToRear);
		// loop starts from capacity to 2*capacity-1 since one node is already created above.
		DoublyLinkedListNode followingBlankDoublyLinkedListNode=getBlankDoublyLinkedListNodes(doublyLinkedListNodeNextToRear, capacity, (getDoubleCapacity()-1));
		// Circular implementation->followingBlankDoublyLinkedListNode points to the last node after the loop.
		followingBlankDoublyLinkedListNode.setNext(front);
		front.setPrev(followingBlankDoublyLinkedListNode);
		capacity=getDoubleCapacity();

	}




	/**
	 * getClonedLinkedList() creates a copy of Queue in a Singly Linked List without using previous address of the doubly linked list class, for convenience 
	 */

	public DoublyLinkedListNode getClonedLinkedList()
	{
		DoublyLinkedListNode helperNode = front;
		DoublyLinkedListNode clonedFrontNode = new DoublyLinkedListNode(helperNode.getWorkProcess());
		DoublyLinkedListNode clonedRearNode = clonedFrontNode;


		helperNode = helperNode.getNext();
		while (helperNode != rear.getNext())
		{
			DoublyLinkedListNode node = new DoublyLinkedListNode(helperNode.getWorkProcess());
			if (clonedFrontNode == null)
			{
				clonedFrontNode = node;
				clonedRearNode = node;

			} else
			{
				clonedRearNode.setNext(node);
				clonedRearNode = node;

			}
			helperNode = helperNode.getNext();

		}
		clonedRearNode.setNext(null);
		return clonedFrontNode;

	}

	/**For Merge Sort, To find the middle element, Cloned list is traversed using two pointers, one take one more stride before they both move to their next element.
	 * eventually it takes twice more number of strides than slow pointer, when fast pointer runs out of the list, slow pointer gives the central node.
	 * (1,2->2,4->3,6->4,8)*
	 */

	public DoublyLinkedListNode getMiddle(DoublyLinkedListNode startNode)
	{
		if (startNode == null)
			return startNode;
		DoublyLinkedListNode slowNode = startNode;
		DoublyLinkedListNode fastNode = startNode.getNext();

		while (fastNode != null)
		{
			fastNode = fastNode.getNext();
			if (fastNode != null)
			{
				slowNode = slowNode.getNext();
				fastNode = fastNode.getNext();
			}
		}
		return slowNode;
	}


	public DoublyLinkedListNode mergeSort(DoublyLinkedListNode startNode)
	{
		if (startNode == null || startNode.getNext() == null)
		{
			return startNode;
		}
		DoublyLinkedListNode middleElement = getMiddle(startNode);
		DoublyLinkedListNode nextOfMiddle = middleElement.getNext();
		middleElement.setNext(null);
		DoublyLinkedListNode left = mergeSort(startNode);
		DoublyLinkedListNode right = mergeSort(nextOfMiddle);
		DoublyLinkedListNode sortedList = sortedMerge(left, right);

		return sortedList;
	}

	public DoublyLinkedListNode sortedMerge(DoublyLinkedListNode left, DoublyLinkedListNode right)
	{
		DoublyLinkedListNode result = null;
		if (left == null)
			return right;
		if (right == null)
			return left;

		if (compareParameter(left, right))
		{
			result = left;
			result.setNext(sortedMerge(left.getNext(), right));
		} else
		{
			result = right;
			result.setNext(sortedMerge(left, right.getNext()));
		}
		return result;
	}

	public boolean compareParameter(DoublyLinkedListNode left, DoublyLinkedListNode right)
	{
		boolean isRightNodeParamGreater = false;

		switch (Param) {
			case PID:
				isRightNodeParamGreater = left.getWorkProcess().getWorkProcessID() <= right.getWorkProcess()
				.getWorkProcessID();
				break;
			case PNAME:
				isRightNodeParamGreater = left.getWorkProcess().getWorkProcessName()
				.compareTo(right.getWorkProcess().getWorkProcessName()) <= 0;
				break;
			case CPUTIME:
				isRightNodeParamGreater = left.getWorkProcess().getCpuTime() <= right.getWorkProcess().getCpuTime();
				break;
			case CPUPERCENT:
				isRightNodeParamGreater = left.getWorkProcess().getCpuUsage() <= right.getWorkProcess().getCpuUsage();
				break;

			case OWNER:
				isRightNodeParamGreater = left.getWorkProcess().getWorkProcessOwner().compareTo(right.getWorkProcess().getWorkProcessOwner()) <= 0;
				break;

		}
		return isRightNodeParamGreater;
	}

	public String displayList()
	{
		String result = "[";
		if (length == 0)
		{
			return result + "]";
		}

		DoublyLinkedListNode node = front;
		for (int i = 1; i <= length; i++)
		{

			WorkProcess workProcess = node.getWorkProcess();
			result = result + "Process Name:" + " " + workProcess.getWorkProcessName() + " "+ "Owner Name"+" "+workProcess.getWorkProcessOwner()+" "+"Proccess ID:" + " " + workProcess.getWorkProcessID() + " " + "Number of threads:"+ workProcess.getNoOfThreadsRunning() + " " + "CPU usage:" + " "+ workProcess.getCpuUsage() + " " + "CPU Time:" + workProcess.getCpuTime() + "\n";

			node = node.getNext();
		}
		return result + "]";
	}


	public String displayList(DoublyLinkedListNode start)
	{
		String result = "[";
		while (start != null)
		{
			WorkProcess workProcess = start.getWorkProcess();
			result = result + "Process Name:" + " " + workProcess.getWorkProcessName() + " "+ "Owner Name"+" "+workProcess.getWorkProcessOwner()+" "+"Proccess ID:" + " " + workProcess.getWorkProcessID() + " " + "Number of threads:"+ workProcess.getNoOfThreadsRunning() + " " + "CPU usage:" + " "+ workProcess.getCpuUsage() + " " + "CPU Time:" + workProcess.getCpuTime() + "\n";
			start = start.getNext();
		}
		return result + "]";
	}

	public DoublyLinkedListNode getBlankDoublyLinkedListNodes(DoublyLinkedListNode DoublyLinkedListNodePrevToRear,int start,int end)
	{
		DoublyLinkedListNode helperDoublyLinkedListNode = DoublyLinkedListNodePrevToRear;

		for (int i = start; i <= end; i++)
		{
			DoublyLinkedListNode followingDoublyLinkedListNode = new DoublyLinkedListNode();
			helperDoublyLinkedListNode.setNext(followingDoublyLinkedListNode);
			followingDoublyLinkedListNode.setPrev(helperDoublyLinkedListNode);
			helperDoublyLinkedListNode = followingDoublyLinkedListNode;

		}
		// Circular implementation->helperDoublyLinkedListNode points to the last node after the loop. i.e last blank node

		return helperDoublyLinkedListNode;

	}


	public boolean isEmpty()
	{
		return (length == 0);
	}

	public int getLength()
	{

		return length;
	}


	public int getDoubleCapacity()
	{
		// << is left shift operator, shifts bits(2^(n+1)) returns double Example for 4(2^2 or 0100 becomes 2^3 or 1000)
		return getLength() << 1;
	}

	public DoublyLinkedListNode getFront()
	{
		return front;
	}

	public DoublyLinkedListNode getRear()
	{

		return rear;
	}

	public int getCapacity()
	{
		return CircularDoublyLinkedQueue.capacity;
	}

}
