package com.ApiCalling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
public class CoustomXMLService {
	
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
	
	
	 public  ResponseEntity<?> converJsonintoXml2()  throws JSONException, IOException, JAXBException  {
		  Date date = new Date();    
	 	    	 FileDump book = new FileDump();
	 	    	 CoustomXMLService cxs=new CoustomXMLService();
	 	    	List<FileDump> filed=new ArrayList<>();
	 	    	 Long id=(long) 1.0;
	 	    	 List<RequestFileDump>  rfd= fileDumpRepo.findAll();
	 	    	RequestFileDump fileDump= fileDumpRepo.getById(id);
	 	    	List<Message> messageList=messagerepo.findAll();
	 	    	List<ParticepentEntered> list= participentEnteredRepo.findAll();
	 	    	List<FileTransferedStarted> fileList=fileTransferedStartedRepository.findAll();
	 	    	List<FileTranferedEnd> fileList1=fileTransferedEndRepository.findAll();
	 	    	List<ParticepentExit> list2= participentExitRepo.findAll();
	 	    	String partEn=cxs.coustomXML(list , book , messageList ,fileList , fileList1 , list2);
		     	book.setRoomId(fileDump.getRoomId());
	          	book.setStartTimeUtc(date);
	 	        book.setEndTimeUtc(date);
	 		String head="<FileDump xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
	 				+"\n"+"<Conversation Perspective=\"Abend term Finance disussion group channel\">"
	 				+"\n"+"<RoomId>"+book.getRoomId()+"</RoomId>"
	 				+"\n"+"<StartTimeUtc>"+book.getStartTimeUtc()+"<StartTimeUtc/>"
	 				+"\n"+"<CallInitiator>"+book.getCallInitiator()+"</CallInitiator>"
	 				+"\n"+"<CallType>"+book.getCallType()+"</CallType>"
	 				+"\n"+"<Vendor>"+book.getVendor()+"</Vendore>"
	 				+"\n"+"<Network>"+book.getNetwork()+"</Network>"
	 				+"\n"+"<Channel>"+book.getChannel()+"</Channel>"
	 				+"\n";
	 			String xml = convertToXML(	book,partEn, head); 
	 	    	for(int i=0;i<=2;i++) {
	 			FileWriter file1 = new FileWriter("/Applications/untitled folder/XML/Samples"+i+".xml");
			    file1.write(xml);   
	            file1.flush();  
	            System.out.println("Your XML data is successfully written into Samplexml.xml");  
	            file1.close();  
	 	    	}
		       return ResponseEntity.ok(xml);
	 }
	 
	 public static String convertToXML(FileDump book,String jsonString, String root) throws JSONException, JAXBException {    // handle JSONException  
	      String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+root+"\n"+jsonString+
	        "<EndTimeUTC>"+book.getEndTimeUtc()+"<EndTimeUtc/>"
	        +"\n" +"</Conversation>"
	        +"\n"+"</FileDump>" ;  
	        xml=xml.replaceAll("\\\\s?","\\.\n");
	      
	        // pass the XML data to the main() method  
	        return xml;  
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
