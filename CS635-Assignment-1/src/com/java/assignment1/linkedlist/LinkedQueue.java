package com.java.assignment1.linkedlist;

import com.java.cs635.assignment1.beans.ListNode;
import com.java.cs635.assignment1.beans.WorkProcess;

public class LinkedQueue {
	int length;
	ListNode front,rear;
	public LinkedQueue()
	{
		length=0;
		front=null;
		rear=null;
		
	}
	
	public void enQueue(WorkProcess oWorkProcess)
	{
		//expand();
		ListNode node=new ListNode(oWorkProcess);
		if(isEmpty())
			front=node;
		else
		rear.setNext(node);
		rear=node;
		length++;
	}
	
	
	public WorkProcess deQueue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Underflow");
		else {
			WorkProcess deletedWorkProcess=front.getWorkprocess();
			front=front.getNext();
			length--;
			if(isEmpty())
				rear=null;
			return  deletedWorkProcess;
		}
		
	}
	
	public WorkProcess getFirst() throws Exception
	{
		if(isEmpty())
			throw new Exception("Length is 0.");
		else {
			
			WorkProcess oWorkProcess=front.getWorkprocess();
			return oWorkProcess;
		}
	}
	
	public int getLength()
	{
		return length;
	}
	
	public boolean isEmpty()
	{
		return (length==0);
	}
	public String toString()
	{
		String result="[";
		if(length==0)
		{
			return result+"]";
		}
		WorkProcess headWorkProcess=front.getWorkprocess();
		result=result+"Process Name:"+" "+headWorkProcess.getWorkProcessName()+" "+"Proccess ID:"+" "+headWorkProcess.getWorkProcessID()+" "+
				"Number of threads:"+headWorkProcess.getNoOfThreadsRunning()+" "+"CPU usage:"+" "+headWorkProcess.getCpuUsage()+" "+
				"CPU Usage:"+headWorkProcess.getCpuTime()+"\n";
		ListNode node=front.getNext();
		while(node!=null)
		{
			WorkProcess workProcess=node.getWorkprocess();
			result=result+"Process Name:"+" "+workProcess.getWorkProcessName()+" "+"Proccess ID:"+" "+workProcess.getWorkProcessID()+" "+
			"Number of threads:"+workProcess.getNoOfThreadsRunning()+" "+"CPU usage:"+" "+workProcess.getCpuUsage()+" "+
			"CPU Usage:"+workProcess.getCpuTime()+"\n";
			node=node.getNext();
		}
		return result+"]";
	}

	
	
}
