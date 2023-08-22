package com.ApiCalling.repo2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ApiCalling.User;
import com.ApiCalling.UserRepository;

@Service
public class Service2 {
	
	@Autowired
	UserRepository repo;
	
	public ResponseEntity<?> changefileFormat(){
	
		long id=1;
	User org = repo.getById(id);
	org.getId();
	org.getTitle();
	org.getUserId();
	org.getBody();
	//Get the bean  
	ByteArrayOutputStream out = null;  
	try {  
	    JAXBContext jctx = JAXBContext.newInstance(User.class);  
	    Marshaller marshaller = jctx.createMarshaller();  
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    out = new ByteArrayOutputStream();  
	    marshaller.marshal(org, out);  
	    String contents = new String(out.toByteArray());  
	    System.out.println("---------------Generated XML------------\n"  
	        +  
	        contents);  
	} catch (JAXBException e) {  
	    System.out.println("JAXB Exception thrown ...");  
	    e.printStackTrace();  
	} catch (Exception ex) {  
	    System.out.println("UnExpected Error ...");  
	    ex.printStackTrace();  
	} finally {  
	    try {  
	        out.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}
	return null;  
	}
}
