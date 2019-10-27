package com.demo.HorseDemo.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "harryKart")
public class Input implements Serializable {
	
	private static final long serialVersionUID = -4224978928573054791L;

	private int numberOfLoops;

	@JacksonXmlElementWrapper(localName = "startList")
	@JacksonXmlProperty(localName = "participant")
	private ArrayList<Participant> startList;

	@JacksonXmlElementWrapper(localName = "powerUps")
	@JacksonXmlProperty(localName = "loop")
	private ArrayList<Loop> powerUps;

	public int getNumberOfLoops() {
		return numberOfLoops;
	}

	public void setNumberOfLoops(int numberOfLoops) {
		this.numberOfLoops = numberOfLoops;
	}

	public ArrayList<Participant> getStartList() {
		if (startList == null) {
			startList = new ArrayList<Participant>();
		}
		return this.startList;
	}

	public void setStartList(ArrayList<Participant> startList) {
		this.startList = startList;
	}

	public ArrayList<Loop> getPowerUps() {
		if (powerUps == null) {
			powerUps = new ArrayList<Loop>();
		}
		return this.powerUps;
	}

	public void setPowerUps(ArrayList<Loop> powerUps) {
		this.powerUps = powerUps;
	}

	@Override
	public String toString() {
		return "Input [numberOfLoops=" + numberOfLoops + ", startList=" + startList + ", powerUps=" + powerUps + "]";
	}

}
