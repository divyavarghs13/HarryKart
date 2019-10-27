package com.demo.HorseDemo.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.HorseDemo.model.Participant;

@Component
public class RaceUtilitiy {
	
	private static final Logger logger = LoggerFactory.getLogger(RaceUtilitiy.class);
	private String jsonStr;
	public String GetJSONData(List<Participant> outputList){
		JSONArray outputArray = new JSONArray();
		JSONObject outputJson = new JSONObject();

		try {
			JSONObject participantJson = null;
			int counter = 1;
			for (Participant participant : outputList) {
				participantJson = new JSONObject();
				participantJson.put("horse", participant.getName());
				participantJson.put("Position", counter);
				counter++;
				outputArray.put(participantJson);
			}
			outputJson.put("ranking", outputArray);

			// get Organisation object as a json string
			 jsonStr = outputJson.toString();
			// Displaying JSON String
			logger.info(jsonStr);
			
	}

	catch (JSONException e) {
		e.printStackTrace();
	}
return jsonStr;
}
}