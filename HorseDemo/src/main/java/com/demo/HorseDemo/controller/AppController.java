package com.demo.HorseDemo.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {
	/**
	@PostMapping(path = "/read", consumes={MediaType.APPLICATION_XML_VALUE})
public void handleXMLPostRequest (@RequestBody MyPojo mypojo) {
    	System.out.println(mypojo);
}
	**/

	/*@RequestMapping(value="/read",method=RequestMethod.POST,consumes = MediaType.APPLICATION_XML_VALUE)
    public String convertXMLtoJson(@RequestBody MyPojo mypojo) {
        String json="";
        try {
        	*//**
            ObjectMapper objectMapper = new XmlMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ObjectMapper jsonMapper = new ObjectMapper();
           mypojo = objectMapper.readValue(mypojo, MyPojo.class);
         json =jsonMapper.writeValueAsString(mypojo);
           System.out.println(jsonMapper.writeValueAsString(mypojo));
         **//*
           System.out.println(mypojo.toString());
          
          
         
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }*/
}
