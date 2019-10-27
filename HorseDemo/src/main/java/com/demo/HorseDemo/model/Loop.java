package com.demo.HorseDemo.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "loop")
public class Loop implements Serializable {

	private static final long serialVersionUID = -6278609851334218948L;

	@JacksonXmlProperty(isAttribute = true)
	private int number;

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "lane")
	private ArrayList<Lane> lane;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<Lane> getLane() {
		if (lane == null) {
			lane = new ArrayList<Lane>();
		}
		return lane;
	}

	public void setLane(ArrayList<Lane> lane) {
		this.lane = lane;
	}

	@Override
	public String toString() {
		return "Loop [number=" + number + ", laneList=" + lane + "]";
	}

}