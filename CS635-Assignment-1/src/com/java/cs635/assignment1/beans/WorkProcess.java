package com.java.cs635.assignment1.beans;

public class WorkProcess {
	private String workProcessName;
	private int workProcessID;
	private int noOfThreadsRunning;
	private int cpuTime;
	private int cpuUsage;
	private String workProcessOwner;
	public WorkProcess(String workProcessName, int workProcessID, int noOfThreadsRunning, int cpuTime, int cpuUsage,String owner) {
		this.workProcessName = workProcessName;
		this.workProcessID = workProcessID;
		this.noOfThreadsRunning = noOfThreadsRunning;
		this.cpuTime = cpuTime;
		this.cpuUsage = cpuUsage;
		this.workProcessOwner=owner;
	}

	public String getWorkProcessName() {
		return workProcessName;
	}

	public void setWorkProcessName(String workProcessName) {
		this.workProcessName = workProcessName;
	}

	public int getWorkProcessID() {
		return workProcessID;
	}

	public void setWorkProcessID(int workProcessID) {
		this.workProcessID = workProcessID;
	}

	public int getNoOfThreadsRunning() {
		return noOfThreadsRunning;
	}

	public void setNoOfThreadsRunning(int noOfThreadsRunning) {
		this.noOfThreadsRunning = noOfThreadsRunning;
	}

	public int getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}

	public int getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(int cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public String getWorkProcessOwner() {
		return workProcessOwner;
	}

	public void setWorkProcessOwner(String workProcessOwner) {
		this.workProcessOwner = workProcessOwner;
	}

}
