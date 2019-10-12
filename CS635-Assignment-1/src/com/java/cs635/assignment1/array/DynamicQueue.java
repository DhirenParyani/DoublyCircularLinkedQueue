
package com.java.cs635.assignment1.array;


import com.java.cs635.assignment1.beans.WorkProcess;

public class DynamicQueue {

	private int front, rear, size;
	private WorkProcess[] queueArray;
	private static int capacity = 3;
	private static int maxCapacity = 1 << 15;

	public DynamicQueue() {
		queueArray = new WorkProcess[capacity];
		front = 0;
		rear = 0;
		size=0;

	}

	public DynamicQueue(int capacity) {
		queueArray = new WorkProcess[capacity];
		front = 0;
		rear = 0;
		size=0;
	}

	// Insert a work process into the queue
	public void enQueue(WorkProcess oWorkProcess) {
		size = size + 1;
		if (size == capacity)
			expand();
		
		queueArray[rear] = oWorkProcess;

		rear = (rear + 1) % capacity;

	}

	public WorkProcess deQueue() {
		WorkProcess workProcessToBeDeletd;
		if (size <= 0)
			throw new IllegalStateException("Queue is empty.Underflow");
		else {
			workProcessToBeDeletd = queueArray[front];
			queueArray[front % capacity] = null;
			front = (front + 1) % capacity;
			size = size - 1;
			return workProcessToBeDeletd;
		}
		
	}

	public int getSize() {
		return size;
	}

	public void expand() {
		int length = getSize();
		WorkProcess[] newQueue = new WorkProcess[length << 1];
		for (int i = front; i < rear; i++) {
			newQueue[i - front] = queueArray[i%capacity];
		}
		queueArray = newQueue;
		front = 0;
		rear = size - 1;
		capacity = capacity * 2;

	}

	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result = result + "Name:" + " " + queueArray[i].getWorkProcessName() + " " + "Process ID:" + " "
					+ queueArray[i].getWorkProcessID() + " " + "Number of threads running:"
					+ queueArray[i].getNoOfThreadsRunning() + " " + "CPU time used:" + " " + queueArray[i].getCpuTime()
					+ " " + "CPU Percentage:" + " " + queueArray[i].getCpuUsage() + "\n";
		}
		return result;
	}

}
