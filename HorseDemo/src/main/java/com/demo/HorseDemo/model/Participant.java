package com.demo.HorseDemo.model;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "participant")
public class Participant implements Serializable {

	private static final long serialVersionUID = 1121430650842415126L;
	
	@JacksonXmlProperty
	private int lane;
	@JacksonXmlProperty
	private String name;
	@JacksonXmlProperty
	private int baseSpeed;

	public int getLane() {
		return lane;
	}

	public String getName() {
		return name;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	@Override
	public String toString() {
		return "Participant [lane=" + lane + ", name=" + name + ", baseSpeed=" + baseSpeed + "]";
	}

}
