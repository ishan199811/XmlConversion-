//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.11 at 03:15:04 PM IST 
//


package com.ApiCalling.model;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ApiCalling.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ApiCalling.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FileDump }
     * 
     */
    public FileDump createFileDump() {
        return new FileDump();
    }

    /**
     * Create an instance of {@link FileTranferedEnd }
     * 
     */
    public FileTranferedEnd createFileTranferedEnd() {
        return new FileTranferedEnd();
    }

    /**
     * Create an instance of {@link FileTransferedStarted }
     * 
     */
    public FileTransferedStarted createFileTransferedStarted() {
        return new FileTransferedStarted();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link ParticepentEntered }
     * 
     */
    public ParticepentEntered createParticepentEntered() {
        return new ParticepentEntered();
    }

    /**
     * Create an instance of {@link ParticepentExit }
     * 
     */
    public ParticepentExit createParticepentExit() {
        return new ParticepentExit();
    }

}