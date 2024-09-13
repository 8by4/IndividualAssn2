package com.apiPRTYPE.aqApiPrototype;
/**
AUTHOR: Aidan Quinn
 YEAR: 2024
 CLASS: CSC340
 ASSIGNMENT: Induvidual Assingment #2 - API Prototype
 API: Hyrule Compendium API
 **/

//Necessary imports to make the project function
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

//Controller for request and springboot
@RestController
@SpringBootApplication
public class AqApiPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqApiPrototypeApplication.class, args);
	}


	//Test mapping function
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}

	//Finds a specified monster when given a name, returning the name, id, description, and an image as a URL.
	@GetMapping("/monster")
	public Object getMonster(@RequestParam(value = "name") String monster_name) {
		try {
			//API URL + name of creature
			String url = "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/" + monster_name;
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();

			String jsonListResponse = restTemplate.getForObject(url, String.class);
			JsonNode root = mapper.readTree(jsonListResponse);


			//Adding data to a single variable for return.
			//Has root.get("data") because of API's format.
			Entry monster = new Entry(root.get("data").get("name").asText(), root.get("data").get("id").asText(),
									  root.get("data").get("description").asText(),
					                  root.get("data").get("image").asText());
			return monster;
			//Error catching
		} catch (JsonProcessingException ex) {
			Logger.getLogger(Entry.class.getName()).log(Level.SEVERE,
					null, ex);
			return "error in /monster";
		}
	}

}
