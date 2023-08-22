package com.ApiCalling;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiCalling.repo2.Service2;

@RestController
public class Controller {
	
	@Autowired
	Sservice service;
	
	@Autowired
	Service2 service2;
	
	@Autowired 
	CoustomXMLService cxs;
	
	@GetMapping("/")
	public ResponseEntity<?> readDataFromApi() throws IOException {
			service.getApiRequest();
		return service.getApiRequest();
	}
	@GetMapping("/jsontoxml")
	public ResponseEntity<?> convertJsonIntoXml() throws IOException {
			return service.converJsonintoXml();
	}
	@GetMapping("/jsontoxml2")
	public ResponseEntity<?> convertJsonIntoXml2() throws IOException, JSONException, JAXBException {
		return service.converJsonintoXml2();
		}
	@GetMapping("/xmltojson")
	public ResponseEntity<?> convertxmltojson() throws IOException {
		return service.xmltoJson();
		}
	@GetMapping("/save")
	public ResponseEntity<?> saveDataFromApi() throws IOException {
		return service.saveData();
	}
	@GetMapping("/sa")
	public ResponseEntity<?> con() throws IOException {
		return service2.changefileFormat();
	}
	@GetMapping("/se")
	public ResponseEntity<?> co() throws IOException, JAXBException, ParseException {
		return service.convertObjectToXML();
	}
	@GetMapping("/se2")
	public ResponseEntity<?> co2() throws IOException, JAXBException, ParseException {
		return cxs.converJsonintoXml2();
	}
	
}
