package com.ApiCalling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ApiCalling.iConnectionModel.RequestFileDump;
import com.ApiCalling.iConnectionModel.RequestFileDumpRepository;
import com.ApiCalling.repo2.FileTransferedEndRepository;
import com.ApiCalling.repo2.FileTransferedStartedRepository;
import com.ApiCalling.repo2.MessageRepository;
import com.ApiCalling.repo2.ParticepentExitRepository;
import com.ApiCalling.repo2.ParticiepentEnterRepository;
import com.ApiCalling.smarshModel.FileDump;
import com.ApiCalling.smarshModel.FileTranferedEnd;
import com.ApiCalling.smarshModel.FileTransferedStarted;
import com.ApiCalling.smarshModel.Message;
import com.ApiCalling.smarshModel.ParticepentEntered;
import com.ApiCalling.smarshModel.ParticepentExit;
import com.ApiCalling.smarshModel.XmlToJava;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;



@Service
public class Sservice {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RequestFileDumpRepository fileDumpRepo;
	
	@Autowired
	ParticiepentEnterRepository  participentEnteredRepo;
	
	@Autowired
	ParticepentExitRepository participentExitRepo;
	
	@Autowired
	MessageRepository messagerepo;
	
	@Autowired
	FileTransferedEndRepository fileTransferedEndRepository ;

	@Autowired
	FileTransferedStartedRepository fileTransferedStartedRepository;
	
	
	  public  ResponseEntity<?> getApiRequest() throws IOException {
	        
	        // Get 10th record data
	        URL getUrl = new URL("https://jsonplaceholder.typicode.com/posts/1");
	        
	        HttpURLConnection conection = (HttpURLConnection) getUrl.openConnection();
	        
	        // Set request method
	        conection.setRequestMethod("GET");

	        // Getting response code
	        int responseCode = conection.getResponseCode();

	        // If responseCode is 200 means we get data successfully
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
	            StringBuffer jsonResponseData = new StringBuffer();
	            String readLine = null;
	            
	            // Append response line by line
	            while ((readLine = in.readLine()) != null) {
	                jsonResponseData.append(readLine);
	            } 
	            
	            in.close();
	            
	            String str=jsonResponseData.toString();
	            // Print result in string format
	            System.out.println("JSON String Data " + str); 
	            return ResponseEntity.ok(str);
	        } else {
	            System.out.println(responseCode);
	        }
	      return ResponseEntity.ok( "Empty");
	    }
	  
	  
	  public  ResponseEntity<?> converJsonintoXml() throws IOException {
	        
	        // Get 10th record data
	        URL getUrl = new URL("https://jsonplaceholder.typicode.com/posts/1");
	        
	        HttpURLConnection conection = (HttpURLConnection) getUrl.openConnection();
	        
	        // Set request method
	        conection.setRequestMethod("GET");

	        // Getting response code
	        int responseCode = conection.getResponseCode();

	        // If responseCode is 200 means we get data successfully
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
	            StringBuffer jsonResponseData = new StringBuffer();
	            String readLine = null;
	            
	            // Append response line by line
	            while ((readLine = in.readLine()) != null) {
	                jsonResponseData.append(readLine);
	            } 
	            
	            in.close();
	            
	            String str=jsonResponseData.toString();
	            // Print result in string format
	            System.out.println("JSON String Data " + str);
	            
	            //Converting json into xml 
	            JSONObject json = new JSONObject(str);
	      	  String xml = XML.toString(json);
	      	 System.out.println("XML String Data " + xml);
	            return ResponseEntity.ok( xml);
	        } else {
	            System.out.println(responseCode);
	        }
	      return ResponseEntity.ok( "Empty");
	    }
	  
	  public  ResponseEntity<?> converJsonintoXml2()  throws JSONException, IOException, JAXBException  {
		  URL getUrl = new URL("https://jsonplaceholder.typicode.com/posts/1");
	       
		 Sservice ss=new Sservice(); 
		  String loc =  "/Applications/untitled folder/XML/json.txt"; 
	    	String result;
	    	
	    	
	    	
	    		  result = new String(Files.readAllBytes(Paths.get(loc)));
//	        HttpURLConnection conection = (HttpURLConnection) getUrl.openConnection();
//	        
//	        // Set request method
//	        conection.setRequestMethod("GET");
//
//	        // Getting response code
//	        int responseCode = conection.getResponseCode();
//
//	        // If responseCode is 200 means we get data successfully
//	        if (responseCode == HttpURLConnection.HTTP_OK) {
//	            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
//	            StringBuffer jsonResponseData = new StringBuffer();
//	            String readLine = null;
//	            
//	            // Append response line by line
//	            while ((readLine = in.readLine()) != null) {
//	                jsonResponseData.append(readLine);
//	            } 
//	            
//	            in.close();
//		  String result=jsonResponseData.toString();
		  
	    		  Date date = new Date();    
	 	    	 FileDump book = new FileDump();
	 	    	 
	 	    	List<FileDump> filed=new ArrayList<>();
	 	    	 Long id=(long) 1.0;
	 	    	 List<RequestFileDump>  rfd= fileDumpRepo.findAll();
	 	    	RequestFileDump fileDump= fileDumpRepo.getById(id);
	 	    
	 	    	List<Message> messageList=messagerepo.findAll();
	 	    	
	 	    	List<ParticepentEntered> list= participentEnteredRepo.findAll();
	 	    	List<FileTransferedStarted> fileList=fileTransferedStartedRepository.findAll();
	 	    	List<FileTranferedEnd> fileList1=fileTransferedEndRepository.findAll();
	 	    	List<ParticepentExit> list2= participentExitRepo.findAll();
	 	    	book.setParticipentEntered(list);
		 	   	book.setMessage(messageList);
		 		book.setFileTransferedStarted(fileList);
		 		book.setFileTranferedEnd(fileList1);
		 		book.setParticipentExit(list2);
		 		
		 		String partEn=ss.coustomXML(list , book , messageList ,fileList , fileList1 , list2);
//		 		for(ParticepentEntered pe:list) {
//	 	      		pe.setDateTimeUtc( date);
//	 	      		pe.setLoginName(fileDump.getLoginName());
//	 	      		pe.setCorporateEmailid(fileDump.getCorporateEmailId());
//	 	    partEn= "<ParticipantEntered>"
//	 	      			+"\n"+"<LoginName>"+pe.getLoginName()+"</LoginName>"
//	 	      			+"\n"+"<DateTimeUTC>"+pe.getDateTimeUtc()+"</DateTimeUTC>"
//	 	      	+"\n"+"<InternalFlag>"+pe.isInternalFlag()+"</InternalFlag>"
//	 	      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
//	 	      	+"\n"+"<CorporateEmailId>"+pe.getCorporateEmailid()+"<CorporateEmailID>"
//	 	      	+"\n"+"</ParticipantEntered>";
//	 	    System.out.println("-------------"+partEn);
// 	    	
//		 		}
		 		
		 		
	 	    	
	 	    	for(Message m:messageList) {
	 	      		m.setDateTimeUtc( date);
	 	      		m.setLoginName(fileDump.getLoginName());
	 	      		m.setCorporateEmailId(fileDump.getCorporateEmailId());
	 	      		m.setMessageId((long)22);
	 		    	m.setMessageType(fileDump.getMessageType());
	 	      	}
	 	    	
	 	    	for(FileTransferedStarted fts:fileList) {
	 	      		fts.setDateTimeUtc( date);
	 	      		fts.setLoginName(fileDump.getLoginName());
	 	      		
	 	      	}
	 	    	

	 	    	for(FileTranferedEnd fte:fileList1) {
	 	      		fte.setDateTimeUtc( date);
	 	      		
	 	      	}
	 	    	
	 	    	for(ParticepentExit pe2:list2) {
	 	      		pe2.setDateTimeUtc(date);
	 	      		pe2.setLoginName(fileDump.getLoginName());
	 	      		pe2.setCorporateEmailId(fileDump.getCorporateEmailId());
	 	      		
	 	      	}
	 	    	
	 	    	
	          	book.setRoomId(fileDump.getRoomId());
	          	book.setStartTimeUtc(date);
	 	    	
	 		book.setEndTimeUtc(date);
	 	
	 	    
	 		//converting object into json 
	 		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	 		String json = ow.writeValueAsString(book);
	 		

	 		
	 		   
	 		String s="<FileDump xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
	 				+"\n"+"<Conversation Perspective=\"Abend term Finance disussion group channel\">"
	 				+"\n"+"<RoomId>"+book.getRoomId()+"</RoomId>"
	 				+"\n"+"<StartTimeUtc>"+book.getStartTimeUtc()+"<StartTimeUtc/>"
	 				+"\n";
	 		
	 		
	 	    	 String xml = convertToXML(	book,partEn, s); 
	 	    	FileWriter file1 = new FileWriter("/Applications/untitled folder/XML/Samples.xml");
			    file1.write(xml);   
	            file1.flush();  
	            System.out.println("Your XML data is successfully written into Samplexml.xml");  
	            file1.close();  
		       return ResponseEntity.ok(xml);
	 	    	
		  
		  
	       
	  }
	  
	  // create convertToXML() method for converting JSOn data into XML  
	    public static String convertToXML(FileDump book,String jsonString, String root) throws JSONException, JAXBException {    // handle JSONException  
	    	
	    	
	    	//JSONObject jsonObject = new JSONObject(jsonString);  
	          
	        JAXBContext context = JAXBContext.newInstance(FileDump.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        // Write to System.out
	        m.marshal(book, System.out);

	        m.marshal(book, new File("/Applications/untitled folder/XML/files.xml"));
	        // use XML.toString() method to convert JSON into XML and store the result into a string  
	       
	        
	        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+root+"\n"+jsonString+
	        "<EndTimeUTC>"+book.getEndTimeUtc()+"<EndTimeUtc/>"
	        +"\n" +"</Conversation>"
	        +"\n"+"</FileDump>" ;  
	        xml=xml.replaceAll("\\\\s?","\\.\n");
	      
	        // pass the XML data to the main() method  
	        return xml;  
	    }  
	    
	    
	    
	    public ResponseEntity<?> xmltoJson() throws IOException {
	    	 String loc =  "/Applications/untitled folder/XML/Samplexml.txt"; 
	    	String result;
	    	
	    	
	    	
	    		  result = new String(Files.readAllBytes(Paths.get(loc))); 
	              //Convert XML to JSON by using convertToJSON() method  
	              String jsonString = convertToJSON(result);  
	              // use try-catch to store JSON data into file.  
	              FileWriter file = new FileWriter("/Applications/untitled folder/XML/json.txt");  
	              // use write() method of File to write JSON data into Sample.json  
	              file.write(jsonString);   
	              file.flush();  
	              System.out.println("Your JSON data is successfully written into Sample.json");   
	              // close FileWriter  
	              file.close();   
	         
	              // TODO Auto-generated catch block  
	             
	           
			return ResponseEntity.ok(jsonString);
	      }  
	      // create convertToXML() method for converting JSOn data into XML  
	   
	    public static String convertToJSON(String xmlString) {    
	        JSONObject obj;  
	        String jsonString = "";  
	        try {  
	            // use XML.toJSONObject() method to convert XML data into JSON and store result into a variable of type JSONObject  
	            obj = XML.toJSONObject(xmlString);  
	            // get JSON string from JSON object and store it into a variable of type string  
	            jsonString = obj.toString();  
	        } catch (JSONException e) {  
	         
	            e.printStackTrace();  
	        }  
	        // pass the JSON data to the main() method  
	        return jsonString;  
	    }  
	    
	    public ResponseEntity<?> saveData(){
List<User> user=new ArrayList<>();
	    	RestTemplate restTemplate=new RestTemplate();
	    	ResponseEntity<User> response = restTemplate.getForEntity(
	    			"https://jsonplaceholder.typicode.com/posts/",
	    		    User.class
	    		);
	    	user.add(response.getBody());
	    	userRepo.saveAll(user);
	    	return ResponseEntity.ok("UserSaved");
	    	
	    }
	    
	    public  ResponseEntity<?>  convertObjectToXML() throws JAXBException, IOException, ParseException {
	    	
	    	Date date = new Date();    
	    	 FileDump boo = new FileDump();
	    	 
	    	List<FileDump> filed=new ArrayList<>();
	    	 Long id=(long) 1.0;
	    	 List<RequestFileDump>  rfd= fileDumpRepo.findAll();
	    	RequestFileDump fileDump= fileDumpRepo.getById(id);
	    
	    	boo.setRoomId(fileDump.getRoomId());
	    	boo.setStartTimeUtc(date);
	    	
	    	List<ParticepentEntered> list= participentEnteredRepo.findAll();
	      	for(ParticepentEntered pe:list) {
	      		pe.setDateTimeUtc( date);
	      		pe.setLoginName(fileDump.getLoginName());
	      		pe.setCorporateEmailid(fileDump.getCorporateEmailId());
	      	}
	    	
	    	
	    	List<Message> messageList=messagerepo.findAll();
	    	for(Message m:messageList) {
	      		m.setDateTimeUtc( date);
	      		m.setLoginName(fileDump.getLoginName());
	      		m.setCorporateEmailId(fileDump.getCorporateEmailId());
	      		m.setMessageId((long)22);
		    	m.setMessageType(fileDump.getMessageType());
	      	}
	    	List<FileTransferedStarted> fileList=fileTransferedStartedRepository.findAll();
	    	for(FileTransferedStarted fts:fileList) {
	      		fts.setDateTimeUtc( date);
	      		fts.setLoginName(fileDump.getLoginName());
	      		
	      	}
	    	
	    	List<FileTranferedEnd> fileList1=fileTransferedEndRepository.findAll();
	    	for(FileTranferedEnd fte:fileList1) {
	      		fte.setDateTimeUtc( date);
	      		
	      	}
	    	List<ParticepentExit> list2= participentExitRepo.findAll();
	    	for(ParticepentExit pe2:list2) {
	      		pe2.setDateTimeUtc(date);
	      		pe2.setLoginName(fileDump.getLoginName());
	      		pe2.setCorporateEmailId(fileDump.getCorporateEmailId());
	      		
	      	}
         	
      boo.setParticipentEntered(list);
	    	boo.setMessage(messageList);
	    	boo.setFileTransferedStarted(fileList);
	    	boo.setFileTranferedEnd(fileList1);
	    	boo.setParticipentExit(list2);
	    	boo.setEndTimeUtc(date);
	    	
	    	
	    	
	    	
//	    	book.setFileTransferedEnd(fileDump.getFileTransferedEnd());
//	    	book.setFileTransferStatus(fileDump.getFileTransferStatus());
	    	
	    	// create JAXB context and instantiate marshaller
	        JAXBContext context = JAXBContext.newInstance(FileDump.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        // Write to System.out
	        m.marshal(boo, System.out);

	        
	        for(int i=1;i<=3;i++) {
	
	        // Write to File
	        m.marshal(boo, new File("/Applications/untitled folder/XML/filesss"+i+".xml"));
}
	        return null;
	    
}
	    
	    
	    
	    public  String  coustomXML(List<ParticepentEntered> list, FileDump fileDump,List<Message> messageList
	    		,List<FileTransferedStarted> fileList , List<FileTranferedEnd> fileList1
	    		,List<ParticepentExit> list2) throws JAXBException, IOException {
	    	 Long id=(long) 1.0;
	    	
	    	Date date = new Date();    
	    	String partEn="";
	 		for(ParticepentEntered pe:list) {
 	      		pe.setDateTimeUtc( date);
 	      		pe.setLoginName(fileDump.getLoginName());
 	      		pe.setCorporateEmailid(fileDump.getCorporateEmailId());
 	    partEn= partEn +"<ParticipantEntered>"
 	      			+"\n"+"<LoginName>"+pe.getLoginName()+"</LoginName>"
 	      			+"\n"+"<DateTimeUTC>"+pe.getDateTimeUtc()+"</DateTimeUTC>"
 	      	+"\n"+"<InternalFlag>"+pe.isInternalFlag()+"</InternalFlag>"
 	      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
 	      	+"\n"+"<CorporateEmailId>"+pe.getCorporateEmailid()+"<CorporateEmailID>"
 	      	+"\n"+"</ParticipantEntered>"
 	      	+"\n"+"\n";
 	    System.out.println("-------------"+partEn);
 	   
	 		}
	 		
	 		for(Message m:messageList) {
	 			m.setDateTimeUtc( date);
 	      		m.setLoginName(fileDump.getLoginName());
 	      		m.setCorporateEmailId(fileDump.getCorporateEmailId());
	 			partEn= partEn +"<Message>"
	 	      			+"\n"+"<LoginName>"+m.getLoginName()+"</LoginName>"
	 	      			+"\n"+"<DateTimeUTC>"+m.getDateTimeUtc()+"</DateTimeUTC>"
	 	      	+"\n"+"<CorporateEmailId>"+m.getCorporateEmailId()+"</CorporateEmailId>"
	 	      	+"\n"+"<Content>"+m.getMessageContent()+"</Content>"
	 	      	+"\n"+"<MessageType>"+m.getMessageType()+"</MessageType>"
	 	      	+"\n"+"<MessageId>"+m.getMessageId()+"</MessageId>"
	 	      	+"\n"+"</Message>"
	 	      	+"\n"+"\n";
	 		}
	 		
	 		for(FileTransferedStarted fts:fileList) {
	      		fts.setDateTimeUtc( date);
	      		fts.setLoginName(fileDump.getLoginName());
	      		partEn= partEn +"<FileTransferStarted>"
	 	      			+"\n"+"<LoginName>"+fts.getLoginName()+"</LoginName>"
	 	      			+"\n"+"<DateTimeUTC>"+fts.getDateTimeUtc()+"</DateTimeUTC>"
	 	      	+"\n"+"<UserFileName>"+fts.getUserFileName()+"</UserFileName>"
	 	      	+"\n"+"<FileName>"+fts.getFileName()+"</FileName>"
	 	      	+"\n"+"<Status>"+fts.getFileTranferedId()+"</Status>"
	 	      	+"\n"+"</FileTransferStarted>"
	 	      	+"\n"+"\n";
	      	}
	 		
	 		for(FileTranferedEnd fts:fileList1) {
	      		fts.setDateTimeUtc( date);
	      		fts.setLoginName(fileDump.getLoginName());
	      		partEn= partEn +"<FileTransferEnd>"
	 	      			+"\n"+"<LoginName>"+fts.getLoginName()+"</LoginName>"
	 	      			+"\n"+"<DateTimeUTC>"+fts.getDateTimeUtc()+"</DateTimeUTC>"
	 	      	+"\n"+"<UserFileName>"+fts.getUserFileName()+"</UserFileName>"
	 	      	+"\n"+"<FileName>"+fts.getFileName()+"</FileName>"
	 	      	+"\n"+"<Status>"+fts.getStatus()+"</Status>"
	 	      	+"\n"+"</FileTransferEnd>"
	 	      	+"\n"+"\n";
	      	}
	 		for(ParticepentExit pe:list2) {
 	      		pe.setDateTimeUtc( date);
 	      		pe.setLoginName(fileDump.getLoginName());
 	      		pe.setCorporateEmailId(fileDump.getCorporateEmailId());
 	    partEn= partEn +"<ParticipantLeft>"
 	      			+"\n"+"<LoginName>"+pe.getLoginName()+"</LoginName>"
 	      			+"\n"+"<DateTimeUTC>"+pe.getDateTimeUtc()+"</DateTimeUTC>"
 	      	+"\n"+"<InternalFlag>"+pe.getInternalFlag()+"</InternalFlag>"
 	      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
 	      	+"\n"+"<CorporateEmailId>"+pe.getCorporateEmailId()+"<CorporateEmailID>"
 	      	+"\n"+"</ParticipantLeft>"
 	      	+"\n"+"\n";
 	    System.out.println("-------------"+partEn);
 	   
	 		}
	 		
	    return partEn;
	    }
	    
	  }
	


