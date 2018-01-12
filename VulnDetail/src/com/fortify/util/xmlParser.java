package com.fortify.util;
 
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class xmlParser
{
	protected fileInformation inform;
  	protected DocumentBuilderFactory factory;
  	protected DocumentBuilder builder;
  	protected Document doc;
 
  	public void init(fileInformation information)
  	{
  		this.inform = information;
 
  		this.factory = DocumentBuilderFactory.newInstance();
  		try {
  			this.builder = this.factory.newDocumentBuilder();
  			this.doc = this.builder.parse(this.inform.getFileName());
  			this.doc.getDocumentElement().normalize();
  		} catch (ParserConfigurationException e) {
  			e.printStackTrace();
  		} catch (SAXException e) {
  			e.printStackTrace();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	}
 }