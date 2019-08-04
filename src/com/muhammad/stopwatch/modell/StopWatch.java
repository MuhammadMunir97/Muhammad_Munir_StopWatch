package com.muhammad.stopwatch.modell;

import java.io.Serializable;
import java.util.ArrayList;

public class StopWatch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Timer> timer;
	
	public StopWatch(){
		timer = new ArrayList<Timer>();
	}

	public void addTime(Timer timer) {
		this.timer.add(timer);
	}
	public ArrayList<Timer> getTimer() {
		return timer;
	}

	public void setTimer(ArrayList<Timer> timer) {
		this.timer = timer;
	}
}
