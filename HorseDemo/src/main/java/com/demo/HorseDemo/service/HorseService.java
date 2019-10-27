package com.demo.HorseDemo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.HorseDemo.model.Participant;
import com.demo.HorseDemo.model.ParticipantLane;

@Service
public class HorseService {

	private static final Logger logger = LoggerFactory.getLogger(HorseService.class);
	public List<Participant> fetchWinner(Map<Integer, List<ParticipantLane>> partLoopMap,
			Map<Integer, Participant> partList) {

		List<ParticipantLane> partLaneList = null;
		Map<Integer, Integer> outputPartTimeMap = new HashMap<>();
		Map<Integer, Integer> partSpeedMap = new HashMap<>();

		for (Integer loop : partLoopMap.keySet()) {
			partLaneList = partLoopMap.get(loop);
			for (ParticipantLane partLane : partLaneList) {
				int partlaneSpeed = 0;
				if (partSpeedMap.get(partLane.getPartId()) != null)
					partlaneSpeed = partLane.getSpeed() + partSpeedMap.get(partLane.getPartId());
				else
					partlaneSpeed = partLane.getSpeed();
				partSpeedMap.put(partLane.getPartId(), partlaneSpeed);
				int partTime = 1000 / partlaneSpeed;
				logger.info("Time="+partTime);
				if (outputPartTimeMap.get(partLane.getPartId()) != null)
					partTime = partTime + outputPartTimeMap.get(partLane.getPartId());
				outputPartTimeMap.put(partLane.getPartId(), partTime);
			}

		}

		List<Entry<String, Integer>> sortedMap = sortByValue(outputPartTimeMap);
		
		List<Participant> sortedParticipants = new ArrayList<>();
		sortedParticipants.add(partList.get(sortedMap.get(0).getKey()));
		sortedParticipants.add(partList.get(sortedMap.get(1).getKey()));
		sortedParticipants.add(partList.get(sortedMap.get(2).getKey()));
		return sortedParticipants;

	}

	private static List<Entry<String, Integer>> sortByValue(Map<Integer, Integer> outputPartMap) {

		// 1. Convert Map to List of Map		
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
				(Collection<? extends Entry<String, Integer>>) outputPartMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		return list;

	}
}
