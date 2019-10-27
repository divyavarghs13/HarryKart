package com.demo.HorseDemo.model;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "lane")
public class Lane implements Serializable {

	private static final long serialVersionUID = 417692028491105010L;

	@JacksonXmlProperty(isAttribute = true)
	private int number;

	@JacksonXmlText
	private int laneValue;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLaneValue() {
		return laneValue;
	}

	public void setLaneValue(int laneValue) {
		this.laneValue = laneValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lane [number=").append(number).append(", laneValue=").append(laneValue).append("]");
		return builder.toString();
	}

}
