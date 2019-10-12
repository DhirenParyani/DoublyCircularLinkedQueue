package com.java.cs635.assignment1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.java.assignment1.linkedlist.CircularDoublyLinkedQueue;
import com.java.assignment1.linkedlist.CircularDoublyLinkedQueue.WorkProcessParams;
import com.java.cs635.assignment1.beans.DoublyLinkedListNode;
import com.java.cs635.assignment1.beans.WorkProcess;

class TestAdder
{

	@Test
	public void testExceptionWhenDoingDequeueWithoutAnyEnqueue()
	{

		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue();
		try
		{
			oCircularLinkedList.deQueue();

		} catch (Exception exception)
		{
			assertEquals("UnderFlow case: CareTaker Stack", exception.getMessage());
		}

	}

	@Test
	public void testEnqueueOperation()
	{
		WorkProcess workProcess1 = new WorkProcess("Paint", 6, 2, 5, 10, "Dhiren");
		WorkProcess workProcess2 = new WorkProcess("IE", 4, 2, 5, 10, "Dhiren");

		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue();
		oCircularLinkedList.enQueue(workProcess1);
		oCircularLinkedList.enQueue(workProcess2);

		assertEquals(2, oCircularLinkedList.getLength());

	}

	@Test
	public void testDequeueOperation()
	{
		WorkProcess workProcess1 = new WorkProcess("Paint", 6, 2, 5, 10, "Dhiren");
		WorkProcess workProcess2 = new WorkProcess("IE", 4, 2, 5, 10, "Dhiren");
		WorkProcess workProcess3 = new WorkProcess("Eclipse", 1, 2, 5, 10, "Dhiren");
		WorkProcess workProcess4 = new WorkProcess("Instagram", 3, 2, 5, 10, "Dhiren");
		WorkProcess workProcess5 = new WorkProcess("AcrobatReader", 9, 2, 5, 10, "Dhiren");

		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue(3);
		oCircularLinkedList.enQueue(workProcess1);
		oCircularLinkedList.enQueue(workProcess2);
		oCircularLinkedList.enQueue(workProcess3);
		oCircularLinkedList.enQueue(workProcess4);
		oCircularLinkedList.enQueue(workProcess5);
		try
		{
			oCircularLinkedList.deQueue();
			oCircularLinkedList.deQueue();
			oCircularLinkedList.deQueue();
			oCircularLinkedList.deQueue();
			oCircularLinkedList.deQueue();
		} catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		assertEquals(0, oCircularLinkedList.getLength());

	}

	@Test
	public void testFIFO() throws Exception
	{
		WorkProcess workProcess1 = new WorkProcess("Paint", 6, 2, 5, 10, "Dhiren");
		WorkProcess workProcess2 = new WorkProcess("IE", 4, 2, 5, 10, "Dhiren");
		WorkProcess workProcess3 = new WorkProcess("Eclipse", 1, 2, 5, 10, "Dhiren");
		WorkProcess workProcess4 = new WorkProcess("Instagram", 3, 2, 5, 10, "Dhiren");
		WorkProcess workProcess5 = new WorkProcess("AcrobatReader", 9, 2, 5, 10, "Dhiren");
		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue(3);
		oCircularLinkedList.enQueue(workProcess1);
		oCircularLinkedList.enQueue(workProcess2);
		oCircularLinkedList.enQueue(workProcess3);
		oCircularLinkedList.enQueue(workProcess4);
		oCircularLinkedList.enQueue(workProcess5);

		WorkProcess workProcessFirstEnqueued = oCircularLinkedList.getFront().getWorkProcess();
		WorkProcess workProcessFirstDeleted = oCircularLinkedList.deQueue();
		assertEquals(workProcessFirstEnqueued, workProcessFirstDeleted);

	}

	@Test
	public void testCapacityExpansion() throws Exception
	{
		WorkProcess workProcess1 = new WorkProcess("Paint", 6, 2, 5, 10, "Dhiren");
		WorkProcess workProcess2 = new WorkProcess("IE", 4, 2, 5, 10, "Dhiren");
		WorkProcess workProcess3 = new WorkProcess("Eclipse", 1, 2, 5, 10, "Dhiren");
		WorkProcess workProcess4 = new WorkProcess("Instagram", 3, 2, 5, 10, "Dhiren");
		WorkProcess workProcess5 = new WorkProcess("IntelliJ", 8, 2, 5, 10, "Dhiren");
		WorkProcess workProcess6 = new WorkProcess("Chrome", 10, 2, 5, 10, "Dhiren");
		WorkProcess workProcess7 = new WorkProcess("MS Word", 13, 2, 5, 10, "Dhiren");
		WorkProcess workProcess8 = new WorkProcess("Edge", 11, 2, 5, 10, "Dhiren");
		WorkProcess workProcess9 = new WorkProcess("Anaconda", 12, 2, 5, 10, "Dhiren");
		int initialCapacity = 3;
		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue(initialCapacity);
		oCircularLinkedList.enQueue(workProcess1);
		oCircularLinkedList.enQueue(workProcess2);
		oCircularLinkedList.enQueue(workProcess3);
		oCircularLinkedList.enQueue(workProcess4);
		assertFalse(initialCapacity == oCircularLinkedList.getCapacity());
		
		oCircularLinkedList.enQueue(workProcess5);
		oCircularLinkedList.enQueue(workProcess6);
		assertEquals(6,oCircularLinkedList.getCapacity());
		oCircularLinkedList.enQueue(workProcess7);
		oCircularLinkedList.enQueue(workProcess8);
		oCircularLinkedList.enQueue(workProcess9);
		assertEquals(12,oCircularLinkedList.getCapacity());
		oCircularLinkedList.deQueue();//Paint
		oCircularLinkedList.deQueue();//IE
		oCircularLinkedList.deQueue();//Eclipse
		oCircularLinkedList.deQueue();//Instagram
		assertEquals(12,oCircularLinkedList.getCapacity());
		assertEquals("IntelliJ", oCircularLinkedList.getFront().getWorkProcess().getWorkProcessName());
	}
	
	@Test
	public void testCircularityOfQueue()
	{
		WorkProcess workProcess1 = new WorkProcess("Paint", 6, 2, 5, 10, "Dhiren");
		WorkProcess workProcess2 = new WorkProcess("IE", 4, 2, 5, 10, "Dhiren");
		WorkProcess workProcess3 = new WorkProcess("Eclipse", 1, 2, 5, 10, "Dhiren");
		int initialCapacity = 3;
		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue(initialCapacity);
		//Assumption:No of enqueues equal to capacity of the list
		oCircularLinkedList.enQueue(workProcess1);
		oCircularLinkedList.enQueue(workProcess2);
		oCircularLinkedList.enQueue(workProcess3);
		
		
		
		assertTrue(oCircularLinkedList.getFront() == oCircularLinkedList.getRear().getNext());
	}
	

	@Test
	public void testOrderChangedAfterSorting()
	{
		WorkProcess workProcess1 = new WorkProcess("Paint", 6, 2, 5, 10, "Dhiren");
		WorkProcess workProcess2 = new WorkProcess("IE", 4, 2, 5, 10, "Dhiren");
		WorkProcess workProcess3 = new WorkProcess("Eclipse", 1, 2, 5, 10, "Dhiren");
		WorkProcess workProcess4 = new WorkProcess("Instagram", 3, 2, 5, 10, "Dhiren");
		int initialCapacity = 3;
		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue(initialCapacity);
		oCircularLinkedList.enQueue(workProcess1);
		oCircularLinkedList.enQueue(workProcess2);
		oCircularLinkedList.enQueue(workProcess3);
		oCircularLinkedList.enQueue(workProcess4);
		DoublyLinkedListNode clonedLinkedList = oCircularLinkedList.getClonedLinkedList();
		//Sort by process ID
		oCircularLinkedList.Param = WorkProcessParams.PID;
		DoublyLinkedListNode sortedList = oCircularLinkedList.mergeSort(clonedLinkedList);

		assertFalse(clonedLinkedList.getWorkProcess().getWorkProcessName() == sortedList.getWorkProcess().getWorkProcessName());
	}

	@Test
	public void testOrderCorrectnessAfterSorting()
	{
		WorkProcess workProcess1 = new WorkProcess("Paint", 4, 2, 5, 10, "Dhiren");
		WorkProcess workProcess2 = new WorkProcess("IE", 4, 2, 5, 10, "Dhiren");
		WorkProcess workProcess3 = new WorkProcess("Eclipse", 1, 2, 5, 10, "Dhiren");
		WorkProcess workProcess4 = new WorkProcess("Instagram", 3, 2, 5, 10, "Dhiren");
		WorkProcess workProcess5 = new WorkProcess("Acrobat Reader", 3, 2, 5, 10, "Dhiren");
		int initialCapacity = 3;
		CircularDoublyLinkedQueue oCircularLinkedList = new CircularDoublyLinkedQueue(initialCapacity);
		oCircularLinkedList.enQueue(workProcess1);
		oCircularLinkedList.enQueue(workProcess2);
		oCircularLinkedList.enQueue(workProcess3);
		oCircularLinkedList.enQueue(workProcess4);
		oCircularLinkedList.enQueue(workProcess5);
		DoublyLinkedListNode clonedLinkedList = oCircularLinkedList.getClonedLinkedList();
		//Sort by Process ID
		oCircularLinkedList.Param = WorkProcessParams.PID;
		DoublyLinkedListNode sortedList = oCircularLinkedList.mergeSort(clonedLinkedList);
		assertTrue("Eclipse" == sortedList.getWorkProcess().getWorkProcessName());
		
		//Sort by Process Name
		clonedLinkedList = oCircularLinkedList.getClonedLinkedList();
		oCircularLinkedList.Param = WorkProcessParams.PNAME;
		DoublyLinkedListNode sortedList2 = oCircularLinkedList.mergeSort(clonedLinkedList);
		
		assertTrue("Acrobat Reader" == sortedList2.getWorkProcess().getWorkProcessName());
	}

}
