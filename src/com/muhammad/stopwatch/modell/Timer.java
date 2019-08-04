package com.muhammad.stopwatch.modell;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class Timer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Instant startTime;
	private Instant endTime;
	
	public Timer () {
		this.startTime = Instant.now();
	}
	
	public String getStartTime() {	
		LocalDateTime ldt1 = LocalDateTime.ofInstant(startTime, ZoneId.systemDefault());
		String startingTime = ldt1.getHour() + " hr " + ldt1.getMinute() + " min";
		return startingTime;
	}
	public void setStartTime() {
		this.startTime = Instant.now();
	}
	public String getEndTime(){
		if((endTime == null)) {
			return "";
		}
		LocalDateTime ldt1 = LocalDateTime.ofInstant(endTime, ZoneId.systemDefault());
		String endingTime = ldt1.getHour() + " hr " + ldt1.getMinute() + " min";
		return endingTime;
		
	}
	public void setEndTime() {
		this.endTime = Instant.now();
	}
	
	public String interval() {
		
		String difference = "";
		if (!(startTime == null) && !(endTime == null)) {
			long diff = Duration.between(startTime, endTime).toSeconds();
			difference = Long.toString(diff/60) + " min " + Long.toString(diff % 60) + " sec";
			return difference;
		}
		return "";
	}
	
	public String runningTime() {
		String difference = "";
		if (!(startTime == null)) {
			long diff = Duration.between(startTime, Instant.now()).toSeconds();
			difference = Long.toString(diff/60) + " min " + Long.toString(diff % 60) + " sec";
			return difference;
		}
		return "";
	}
	
	public String currentTime() {
		LocalDateTime ldt1 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		String time = ldt1.getHour() + " hr " + ldt1.getMinute() + " min";
		return time;
	}
	
	public void resetTimer() {
		this.startTime = Instant.now();
		this.endTime = null;
	}
}
