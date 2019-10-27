package com.demo.HorseDemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.HorseDemo.model.Input;
import com.demo.HorseDemo.model.Lane;
import com.demo.HorseDemo.model.Loop;
import com.demo.HorseDemo.model.Participant;
import com.demo.HorseDemo.model.ParticipantLane;
import com.demo.HorseDemo.service.HorseService;
import com.demo.HorseDemo.util.RaceUtilitiy;

@RestController
@RequestMapping("/api")
public class WelcomeController {
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private HorseService horseService;

	@Autowired
	private RaceUtilitiy raceUtil;

	Map<Integer, Participant> participantMap = new HashMap<>();
	List<ParticipantLane> partList = new ArrayList<>();
	Map<Integer, List<ParticipantLane>> participantLoop = new HashMap<>();
	ParticipantLane partLaneObj = null;
	String resultData;

	@RequestMapping(value = "play", method = RequestMethod.POST, produces = "application/json" , consumes="application/xml")
	public String handleXMLPostRequest(@RequestBody Input inputXml) throws IOException {
		try {
			processXMLToPojo(inputXml);
			List<Participant> outputList = horseService.fetchWinner(participantLoop, participantMap);
			resultData = raceUtil.GetJSONData(outputList);
			return resultData;
		}
		catch (JSONException e) {
			e.printStackTrace();
		} 
		
		return resultData;
	}

	public void processXMLToPojo(Input input) throws IOException {
		/**
		 * Retrieving Participant details as list from startList. Set a pojo class with
		 * Lane number as Participant ID along with other Participant data. Initialize a
		 * map with Key as Participant ID and Participant Object as Value
		 **/
		for (Participant participant : input.getStartList()) {
			partLaneObj = new ParticipantLane();
			partLaneObj.setPartId(participant.getLane());
			partLaneObj.setParticipant(participant);
			partLaneObj.setSpeed(10);
			participantMap.put(participant.getLane(), participant);
			partList.add(partLaneObj);
			logger.info(" Participant: " + participant.getName() + ", Lane: " + participant.getLane());
		}
		/**
		 * Initialize the map with key as 0 to consider as 1st loop and value as the
		 * list with participant details
		 **/
		participantLoop.put(0, partList);
		/**
		 * Retrieve the loop data from input xml file. The lane number is added to
		 * participant object and adding to the list
		 **/
 		for (Loop loop : input.getPowerUps()) {
			ParticipantLane partLaneNewObj = null;
			partList = new ArrayList<>();
			for (Lane lane : loop.getLane()) {
				partLaneNewObj = new ParticipantLane();
				 logger.info("lane number :" + lane.getNumber()+", lane value :" +
				 lane.getLaneValue());
				partLaneNewObj.setPartId(lane.getNumber());
				partLaneNewObj.setSpeed(lane.getLaneValue());
				partLaneNewObj.setParticipant(participantMap.get(lane.getNumber()));
				partList.add(partLaneNewObj);
			} 
			 System.out.println(" Loop number: " + loop.getNumber());
			/** We add the data to the map with key increasing each time in the loop **/
			participantLoop.put(loop.getNumber(), partList);

		}
	}
}
